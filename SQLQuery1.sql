


declare @err varchar(100) 
exec USP_ADD_NEW_INVOICE_EXPORT_DETAIL @err out,'Corsair KX50', '10','1','1','E0013'
print @err


select * from InvoiceExportDetail
select iid.Number-sum(ied.Counts) as 'hihi' from InvoiceExportDetail ied 
			join InvoiceImportDetail iid on ied.IdInvoiceImportDetail = iid.Id 
			join Products p on p.Id = iid.IdProduct 
			     where p.name = 'Iphone 12'
				 group by iid.id,iid.Number,p.name
--quy ước errOutput
	--1: không đủ số lượng
	--2: insert thất bại tại dòng bao nhiêu, do lỗi xử lý
    --3: insert thành công
ALTER PROC USP_ADD_NEW_INVOICE_EXPORT_DETAIL
		@errOutput int out,
		@nameProduct varchar(50),
		@counts_export int,
		@idUser int,
		@idCustomer int,
		@idInvoiceExport varchar(10)
	as
	BEGIN
		--tạo bảng tạm và insert dl số lượng tồn tại trong kho theo tên sản phẩm

		IF OBJECT_ID('tempdb..##tmpRemainingAmountByProduct','U') IS NOT NULL
			BEGIN
				DROP TABLE  ##tmpRemainingAmountByProduct;
			END
			CREATE  TABLE ##tmpRemainingAmountByProduct(
				totalHangTonKho int
			)
			Insert into ##tmpRemainingAmountByProduct(totalHangTonKho)
			select iid.Number-sum(ied.Counts) as 'hihi' from InvoiceExportDetail ied 
			join InvoiceImportDetail iid on ied.IdInvoiceImportDetail = iid.Id 
			join Products p on p.Id = iid.IdProduct 
			     where p.name = @nameProduct
				 group by iid.id,iid.Number,p.name having iid.Number-sum(ied.Counts) > 0
		DECLARE @number_rest int --số lượng còn lại trong kho)
		SET @number_rest = (select sum(i.totalHangTonKho) from ##tmpRemainingAmountByProduct i)
		if (@counts_export < @number_rest) -- so sánh với số lượng còn lại trong kho
			BEGIN TRY
				BEGIN TRANSACTION 
				--set id export chung
				declare @id_invoice_export varchar(10)
				set @id_invoice_export = @idInvoiceExport
					--b0: insert dl vào bảng invoiceexport
					 --tính mã id tự tăng cho invoicexport
					DECLARE @id_invoiceexport_current varchar(10)
					SET @id_invoiceexport_current = (select top(1) i.id from InvoiceExport i)
					DECLARE @Idx_invoiceexport int
					SET @Idx_invoiceexport = 1
					WHILE EXISTS(SELECT ID FROM InvoiceExport WHERE Id = @id_invoiceexport_current)
						BEGIN
							SET @Idx_invoiceexport = @Idx_invoiceexport + 1
							SET @id_invoiceexport_current = 'E' + REPLICATE('0', 4 - LEN(CAST(@Idx_invoiceexport AS VARCHAR))) + CAST(@Idx_invoiceexport AS VARCHAR)
						END
					--null là hóa đơn mới, còn không null hóa đơn cũ
					IF (@idInvoiceExport = '')
						begin
							INSERT INTO InvoiceExport(Id,DateOutput,IdCustomer,idUser)
							VALUES (@id_invoiceexport_current,GETDATE(),@idCustomer,@idUser)
							set @id_invoice_export = @id_invoiceexport_current
						end
					--b1: insert dl vao bang tam
					IF OBJECT_ID('tempdb..##tmprecordnumber','U') IS NOT NULL
						BEGIN
							DROP TABLE  ##tmprecordnumber;
						END
					CREATE  TABLE ##tmprecordnumber(
						totalHangTonKho int,
						idImportDetail varchar(10)
					)
					
					INSERT  INTO  ##tmprecordnumber(totalHangTonKho,idImportDetail)
					select iid.Number-sum(ied.Counts) as 'Ton kho', iid.Id 'idImportDetail'  from InvoiceExportDetail ied 
							join InvoiceImportDetail iid on ied.IdInvoiceImportDetail = iid.Id 
							join Products p on p.Id = iid.IdProduct 
								 where p.name = @nameProduct
								 group by iid.id,iid.Number having iid.Number-sum(ied.Counts) > 0
					--b2: lấy ra số bảng ghi của bảng tạm
					DECLARE @total_recore_##tmprecordnumber int
					SET @total_recore_##tmprecordnumber = (select count(idImportDetail) from ##tmprecordnumber)
					--b3: tạo 1 biến đêm a và dùng while để chạy vòng quanh bảng tạm sau đó insert
					declare @a int -- biến đêm vòng lặp để dừng
					set @a = 1
					
					WHILE(@a <= @total_recore_##tmprecordnumber)
					BEGIN
					
						--lấy biến tự tăng
						DECLARE @id_invoiceexportdetail_current varchar(10)
						SET @id_invoiceexportdetail_current = (select top(1) i.id from InvoiceExportDetail i)
						DECLARE @Idx_invoiceexportdetail int
						SET @Idx_invoiceexportdetail = 1
						WHILE EXISTS(SELECT ID FROM InvoiceExportDetail WHERE Id = @id_invoiceexportdetail_current)
						BEGIN
							SET @Idx_invoiceexportdetail = @Idx_invoiceexportdetail + 1;
							SET @id_invoiceexportdetail_current = 'ED' + REPLICATE('0', 4 - LEN(CAST(@Idx_invoiceexportdetail AS VARCHAR))) + CAST(@Idx_invoiceexportdetail AS VARCHAR)
						END

						
						declare @total_product_current int
						set @total_product_current = (select top(1) b.totalHangTonKho from ##tmprecordnumber b)
						declare @id_importdetail_##tmprecordnumber varchar(10)
						set @id_importdetail_##tmprecordnumber = (select top(1) b.idImportDetail from ##tmprecordnumber b)

						

						IF (@counts_export > @total_product_current)
							begin
								INSERT INTO InvoiceExportDetail(id,IdInvoiceImportDetail,IdInvoiceExport,Counts)
								VALUES(@id_invoiceexportdetail_current,@id_importdetail_##tmprecordnumber,@id_invoice_export,@total_product_current)
								SET @counts_export = (@counts_export - @total_product_current)
								SET @a = @a + 1
							end
						ELSE
							begin
								INSERT INTO InvoiceExportDetail(id,IdInvoiceImportDetail,IdInvoiceExport,Counts)
								VALUES(@id_invoiceexportdetail_current,@id_importdetail_##tmprecordnumber,@id_invoice_export,@counts_export)
								BREAK
							end

						if( @a >= 2)
						begin
							delete from ##tmprecordnumber where idImportDetail = @id_importdetail_##tmprecordnumber
						end
					END
					--b4 : insert thêm giá tiền vào bảng invoiceexport
					DECLARE @money_invoiceexport int
					
					IF (@idInvoiceExport = '')
						BEGIN
							SET @money_invoiceexport = (select sum(ied.Counts*p.price) as 'hoa don tien'  from InvoiceExportDetail ied join InvoiceImportDetail iid 
													on ied.IdInvoiceImportDetail = iid.Id join Products p
													on p.Id = iid.IdProduct join InvoiceExport ie
													on ie.Id = ied.IdInvoiceExport where ie.Id = @id_invoiceexport_current)
							UPDATE InvoiceExport Set totalMoney = @money_invoiceexport where id = @id_invoiceexport_current
						END
					ELSE
						BEGIN
							SET @money_invoiceexport = (select sum(ied.Counts*p.price) as 'hoa don tien'  from InvoiceExportDetail ied join InvoiceImportDetail iid 
													on ied.IdInvoiceImportDetail = iid.Id join Products p
													on p.Id = iid.IdProduct join InvoiceExport ie
													on ie.Id = ied.IdInvoiceExport where ie.Id = @idInvoiceExport)
							UPDATE InvoiceExport Set totalMoney = @money_invoiceexport where id = @idInvoiceExport
						END
					SET @errOutput = 3
				COMMIT 
			END TRY
			BEGIN CATCH
				--SET @errOutput =  'INSERT THAT BAT TAI DONG:' +  CAST(ERROR_LINE() as varchar(5)) + '   ' + ERROR_MESSAGE()
				SET @errOutput = 2
				ROLLBACK TRANSACTION 
			END CATCH
		else
			SET @errOutput = 1
	END
