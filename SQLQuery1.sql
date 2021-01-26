


declare @err varchar(100) 
exec USP_ADD_NEW_INVOICE_EXPORT_DETAIL @err out,'Iphone 12', '3000','1','1',''
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


	--select hiển thị hàng hóa
	select ie.Id as 'IdInvoiceExport',c.name as 'NameCustomer',p.name as 'NameProduct',sum(ied.Counts) as 'Counts',sum(ied.Counts * p.price) as 'money',u.Name as 'NameUser',ie.DateOutput from InvoiceExportDetail ied join InvoiceImportDetail iid
	on ied.IdInvoiceImportDetail = iid.Id join Products p
	on p.Id = iid.IdProduct join InvoiceExport ie
	on ie.Id = ied.IdInvoiceExport join Users u
	on u.Id = ie.idUser join customer c
    on c.id = ie.IdCustomer
	group by p.name, ie.Id, c.name,u.Name,ie.DateOutput
	order by ie.Id
	-- end select hiển thị hàng hóa
	

	alter proc update_invoice_export_detail
		@errOutput  varchar(10) out,
		@idInvoiceExport varchar(10),
		@nameProduct varchar(50),
		@counts_repay int
	as
	begin
		declare @counts_paid int
		set @counts_paid = (select sum(ied.Counts) as 'so luong da ban ra' from InvoiceExport ie join InvoiceExportDetail ied on ied.IdInvoiceExport = ie.Id 
							join InvoiceImportDetail iid on iid.Id = ied.IdInvoiceImportDetail
							join Products p on p.Id = iid.IdProduct where ie.Id = @idInvoiceExport and p.name = @nameProduct
							group by p.name) 
		if(@counts_repay < @counts_paid)
			begin
				begin try
					begin transaction
						--b1: insert dl vao bang tam
						IF OBJECT_ID('tempdb..##tmprecordnumber_edit','U') IS NOT NULL
							BEGIN
								DROP TABLE  ##tmprecordnumber_edit;
							END
						CREATE  TABLE ##tmprecordnumber_edit(
							idExportDetail varchar(10),
							total_goods_sold int
						)
						INSERT  INTO  ##tmprecordnumber_edit(idExportDetail,total_goods_sold)
						select  ied.Id, ied.Counts from InvoiceExport ie join InvoiceExportDetail ied on ied.IdInvoiceExport = ie.Id 
							join InvoiceImportDetail iid on iid.Id = ied.IdInvoiceImportDetail
							join Products p on p.Id = iid.IdProduct where ie.Id = @idInvoiceExport and p.name = @nameProduct and ied.Counts > 0
							order by ied.Id desc
							--: lấy ra số bản ghi của bảng tạm
						DECLARE @total_recore_##tmprecordnumber_edit int
						SET @total_recore_##tmprecordnumber_edit = (select count(idExportDetail) from ##tmprecordnumber_edit)
						DECLARE @a int
						SET @a = 1
						WHILE (@a <= @total_recore_##tmprecordnumber_edit) 
						begin
							SET @a = @a +  1

							DECLARE @quanlity_product_paid_by_id_new_earliest int
							SET @quanlity_product_paid_by_id_new_earliest = (select top(1) total_goods_sold from ##tmprecordnumber_edit where total_goods_sold > 0 order by idExportDetail desc )
							print 'quanlity' + cast(@quanlity_product_paid_by_id_new_earliest as varchar(10))
							DECLARE @id_product_paid_by_id_new_earliest varchar(10)
							SET @id_product_paid_by_id_new_earliest = (select top(1) idExportDetail from ##tmprecordnumber_edit where total_goods_sold > 0 order by idExportDetail desc)
							print @id_product_paid_by_id_new_earliest
							if(@counts_repay > @quanlity_product_paid_by_id_new_earliest)
								begin
									delete from InvoiceExportDetail where Id = @id_product_paid_by_id_new_earliest
									delete from ##tmprecordnumber_edit where idExportDetail = @id_product_paid_by_id_new_earliest
									SET @counts_repay = @counts_repay - @quanlity_product_paid_by_id_new_earliest
								end
							else
								begin
									update InvoiceExportDetail
									SET Counts =  @quanlity_product_paid_by_id_new_earliest - @counts_repay
									WHEre Id = @id_product_paid_by_id_new_earliest
									break
								end
						end
						--b2: tính giá tiền
						DECLARE @money_invoiceexport bigint
						SET @money_invoiceexport = (select sum(ied.Counts*p.price) as 'hoa don tien'  from InvoiceExportDetail ied join InvoiceImportDetail iid 
													on ied.IdInvoiceImportDetail = iid.Id join Products p
													on p.Id = iid.IdProduct join InvoiceExport ie
													on ie.Id = ied.IdInvoiceExport where ie.Id = @idInvoiceExport)
						UPDATE InvoiceExport Set totalMoney = @money_invoiceexport where id = @idInvoiceExport

						SET @errOutput = 'thanh cong'
					commit
				end try
				begin catch
					SET @errOutput =  'INSERT THAT BAT TAI DONG:' +  CAST(ERROR_LINE() as varchar(5)) + '   ' + ERROR_MESSAGE()
					ROLLBACK TRANSACTION 
				end catch
			end
		else
			begin
				SET @errOutput = 'so luong hang tra lai khong the lon hon so luong hang ban ra'
			end
	end

	declare @err varchar(100) 
	exec update_invoice_export_detail @err out,'E0014', 'Iphone 12',2900
	print @err 

	