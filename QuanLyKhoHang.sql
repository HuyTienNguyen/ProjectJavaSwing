create database QuanLyKhoHang
go
use QuanLyKhoHang
go

--tạo bảng Users
create table Users(
	Id int identity(1,1) primary key,
	Name nvarchar(100),
	Username nvarchar(100),
	Password nvarchar(100),
	email varchar(200) ,
	images varchar(max),
	verifyCode int NULL
)
go
--tạo bảng Unit
create table Unit(
	Id int identity(1,1) primary key,
	name nvarchar(100),
	status int default(1)
)
go
exec sp_get_total_reports_from_nearest_week
exec sp_get_total_reports_from_6_most_recent_months
CREATE proc getunitNameById
@input_id int

AS	
	BEGIN 

	SELECT name from unit where id = @input_id
	END
	
	exec getunitNameById 0
	select @name1
	select * from users
--tạo bảng Suplier
create table Suplier(
	Id int identity(1,1) primary key,
	name nvarchar(100),
	address nvarchar(100),
	phone nvarchar(20),
	email nvarchar(200),
	MoreInfo nvarchar(max),
	ContractDate DateTime,
	characters nvarchar(100),
	status int default(1)
)
go
--tạo bảng category
 create table category(
	Id int identity(1,1) primary key,
	name nvarchar(100),
	characters nvarchar(20),
	status int default(1)
 )	
 go
--tạo bảng Products
create table Products(
	Id nvarchar(100) primary key,
	name nvarchar(100),
	IdUnit int not null,
	IdSuplier int not null,
	IdCate int,
	price float check(price>=0) default 0,
	taxProduct float check(taxProduct >=0 AND taxProduct <=100) default 0
)
go


--tạo bảng Customer
create table Customer(
	Id int identity(1,1) primary key,
	name nvarchar(100),
	address nvarchar(100),
	phone nvarchar(100),
	email nvarchar(100),
	MoreInfo nvarchar(max),
	ContractDate DateTime
)
go
--tạo bảng InvoiceImport
create table InvoiceImport(
	Id nvarchar(100) primary key,
	DateInput DateTime,
	idUser int	
)
go
--tạo bảng InvoiceImportDetail
create table InvoiceImportDetail(
	Id nvarchar(100) primary key,
	IdProduct nvarchar(100) not null,
	IdInvoiceImport nvarchar(100) not null,
	Number int,
	InputPrice float default(0),
	Status nvarchar(100)
)
go

--tạo bảng InvoiceExport
create table InvoiceExport(
	Id nvarchar(100) primary key,
	DateOutput DateTime,
	IdCustomer int not null,
	idUser int null,
	totalMoney bigint default(0)
)
go
--tạo bảng InvoiceExportDetail
create table InvoiceExportDetail(
	Id nvarchar(100) primary key,
	IdProduct nvarchar(100) not null,
	IdInvoiceImportDetail nvarchar(100) not null,
	IdInvoiceExport nvarchar(100) not null,
	Counts int,
	Status nvarchar(100)
)
go
--tạo thêm 2 cột iduser cho invoiceimport va invoiceexport
ALTER TABLE InvoiceImport
ADD IdUser int;
ALTER TABLE InvoiceExport
ADD IdUser int;

--tạo khóa ngoại Cateogry và Products
ALTER TABLE Products
ADD CONSTRAINT FK_01 FOREIGN KEY (IdCate) REFERENCES Category(Id);
--tạo khóa ngoại Suplier và Products
ALTER TABLE Products
ADD CONSTRAINT FK_02 FOREIGN KEY (IdSuplier) REFERENCES Suplier(Id);
--tạo khóa ngoại Unit và Products
ALTER TABLE Products
ADD CONSTRAINT FK_03 FOREIGN KEY (IdUnit) REFERENCES Unit(Id);



ALTER TABLE InvoiceImportDetail
ADD CONSTRAINT FK_05 FOREIGN KEY (IdProduct) REFERENCES Products(Id);


--tạo khóa ngoại InvoiceImportDetail và InvoiceImport
ALTER TABLE InvoiceImportDetail
ADD CONSTRAINT FK_06 FOREIGN KEY (IdInvoiceImport) REFERENCES InvoiceImport(Id);

--tạo khóa ngoại InvoiceExport và Customer
ALTER TABLE InvoiceExport
ADD CONSTRAINT FK_07 FOREIGN KEY (IdCustomer) REFERENCES Customer(Id);



--tạo khóa ngoại InvoiceExportDetail và InvoiceImportDetail
ALTER TABLE InvoiceExportDetail
ADD CONSTRAINT FK_09 FOREIGN KEY (IdInvoiceImportDetail) REFERENCES InvoiceImportDetail(Id);
--tạo khóa ngoại InvoiceExportDetail và invoiceExport
ALTER TABLE InvoiceExportDetail
ADD CONSTRAINT FK_10 FOREIGN KEY (idinvoiceExport) REFERENCES invoiceExport(Id)

--tạo khóa ngoại InvoiceExport và users
ALTER TABLE InvoiceExport
ADD CONSTRAINT FK_11 FOREIGN KEY (idUser) REFERENCES users(Id)

--tạo khóa ngoại InvoiceImport và users
ALTER TABLE InvoiceImport

ADD CONSTRAINT FK_12 FOREIGN KEY (idUser) REFERENCES users(Id)
GO



/*
  *  Tạo thủ tục
  PRocedure ADD new unit
	*	@param 1 : out put param
	*	@param 2: param name(String) input
 */

 -- Thủ tục thêm mới Unit
create procedure sp_add_new_unit
 (

	@output int output,
	@name varchar(100)

 )
 AS
	BEGIN 
		IF NOT EXISTS(SELECT * FROM Unit WHERE name =@name)
			BEGIN
				INSERT INTO Unit(name) VALUES (@name)
				SET @output = 0
			END
		ELSE
			BEGIN
				SET @output =1
			END
	END
	GO
/* Test Procedure sp_add_new_unit
	declare  @a int 
	exec sp_add_new_unit  @a output ,'Kg'
	Select @a	
	*/

	/*
	*	PRocedure update unit
	*	@param 1 : out put param
	*	@param 2: param id (Integer) input
	*	@param 3: param name(String) input
	*/
	create procedure sp_update_unit
 (

	@output int output,
	@id int,
	@name nvarchar(100)

 )
 AS
	BEGIN 
		IF  EXISTS(SELECT * FROM Unit WHERE id= @id)
			BEGIN
				UPDATE  Unit
				SET name=@name  
				WHERE id = @id
				SET @output = @@ROWCOUNT
			END
		ELSE
			BEGIN
				SET @output =0
			END
	END
	GO
	/* Test PROCEDURE sp_update_unit
	*	declare  @output int 
	*	exec sp_update_unit @output output ,2,'aaa'
	*	Select @output
	*/


	
	/*
	*	PRocedure delete unit
	*	@param 1 : out put param
	*	@param 2: param id (Integer) input
	*	@param 3: param newstatus (Integer) input

	*/
	create procedure sp_delete_unit
 (
	@output int output,
	@id int
 )
 AS
	BEGIN 
		IF  EXISTS(SELECT * FROM Unit  WHERE id= @id)
			BEGIN
		
				UPDATE  Unit
				SET status = IIF(status = 0, 1, 0) 
				WHERE id = @id
				SET @output = @@ROWCOUNT
			END
		ELSE
			BEGIN
				SET @output = 0
			END
	END
	GO
	
		-- PROCEDURE DELETE SUPLIER
create procedure sp_delete_suplier
 (
	@output int output,
	@id int
 )
 AS
	BEGIN 
		IF  EXISTS(SELECT * FROM suplier  WHERE id= @id)
			BEGIN	
				UPDATE  Suplier
				SET status = IIF(status = 0, 1, 0) 
				WHERE id = @id
				SET @output = @@ROWCOUNT
			END
		ELSE
			BEGIN
				SET @output = 0
			END
	END
	GO
		-- PROCEDURE DELETE Category
create procedure sp_delete_category
 (
	@output int output,
	@id int
 )
 AS
	BEGIN 
		IF  EXISTS(SELECT * FROM Category  WHERE id= @id)
			BEGIN	
				UPDATE  Category
				SET status = IIF(status = 0, 1, 0) 
				WHERE id = @id
				SET @output = @@ROWCOUNT
			END
		ELSE
			BEGIN
				SET @output = 0
			END
	END
	GO
	-- GET TOTAl row in product table
	create procedure sp_count_products (
	@output int output
	)

 AS			
		BEGIN
		SET @output	=(select count(*)FROM  Products	)
			
		END
		GO
	/* Procedure insert to invoiceImportDetail with transaction
	*	@Param @errOutput error output 0 = not error 1 = errors 
	*	@param @dateImport: Date import data to database
	*	@param @idProduct: Id Product need import
	*	@param @number: number of products import
	*	@param @inputPrice: input price of product
	*	@param @outPrice: out price of product
	*	@param @status: status of product
	*/
alter procedure sp_add_invoice_import_Detail(
	@errOutput int output,	
	@dateImport datetime,
	@idProduct nvarchar(100),
	@idImportInput varchar(20),
	@number int,
	@inputPrice float		
)

	AS
	declare	 @idInvoiceImport varchar(20),
			 @newIdInvoiceImport varchar(20),
			 @countInvoiceImport int,
			 @idInvoiceimportDetail varchar(100),
			 @countInvoiceImportDetail int
		BEGIN TRANSACTION
			BEGIN TRY
			-- get count from imvoiceimport table
			set @countInvoiceImport = ((SELECT count(id) from invoiceimport)+1)	
			-- set id for new record insert to invoiceimport table
			SET @newIdInvoiceImport = 'I'+ REPLICATE('0',6 - LEN(CAST(@countInvoiceImport as varchar(20)))) +CAST(@countInvoiceImport as varchar(20))
					
			SET @idInvoiceImport =IIF(LEN(@idImportInput)>3,@idImportInput,@newIdInvoiceImport)
			-- get count from imvoiceimportDetail table
			set @countInvoiceImportDetail= ((SELECT count(id) from InvoiceImportDetail)+1)		
			-- set id for new record insert to invoiceimportDetail table
			SET @idInvoiceimportDetail = 'ID'+ REPLICATE('0',6 - LEN(CAST(@countInvoiceImportDetail as varchar(20))))+CAST(@countInvoiceImportDetail as varchar(20))
				IF NOT EXISTS(SELECT id from InvoiceImport where id = @idInvoiceImport)
					BEGIN
						INSERT INTO InvoiceImport (id,DateInput)VALUES(@idInvoiceImport,@dateImport)
					END
				
				INSERT INTO InvoiceImportDetail(Id,IdProduct,IdInvoiceImport,Number,InputPrice,Status)
							VALUES(@idinvoiceimportDetail,@idProduct,@idInvoiceImport,@number,@inputPrice,'1')
				SET @errOutput =0;
				COMMIT TRANSACTION
			END TRY
			BEGIN CATCH
			SET @errOutput =1;
			ROLLBACK TRANSACTION
			 RETURN ERROR_MESSAGE()
			END CATCH
			GO
			

-- THủ tục lấy về ngày đầu tiên trong bảng Invoice import
CREATE PROCEDURE sp_get_firt_date_Invoice_Import 
AS
	BEGIN
		SELECT convert (datetime,(SELECT  TOP 1  DateInput from InvoiceImport ORDER BY  DateInput)) 
	
	END
	GO
	-- lấy ngày này sang năm 

	/*
	*	Procedure sp_create_temp_get_all_reports_invoiceimportdetail lấy về toàn bộ thông tin nhập hàng từ truóc tới nay
	*/

alter PROCEDURE sp_create_temp_get_all_reports_invoiceimportdetail

AS
	BEGIN		
		IF OBJECT_ID('tempdb..##reports_invoiceimportdetail','U') IS NOT NULL
		BEGIN
			DROP TABLE ##reports_invoiceimportdetail
		END
			BEGIN
			SELECT iid.Id as 'IdInvoiceimportDetail',iid.IdProduct as'ProductId', p.name as 'Productname' ,iid.InputPrice,iid.Number,id.DateInput INTO ##reports_invoiceimportdetail			
				from InvoiceImportDetail iid
				join Products p
				ON iid.IdProduct =p.Id
				JoIN InvoiceImport id
				ON iid.IdInvoiceImport = id.Id
				
			END		
	END
	GO
	/*
	*	Procedure sp_create_temp_get_all_reports_invoiceimportdetail lấy về toàn bộ thông tin xuất hàng từ trước tới nay
	*/


	exec sp_create_temp_get_all_reports_invoiceexportdetail
ALTER PROCEDURE sp_create_temp_get_all_reports_invoiceexportdetail

AS
	BEGIN		
		IF OBJECT_ID('tempdb..##reports_invoiceexportdetail','U') IS NOT NULL
		BEGIN
			DROP TABLE ##reports_invoiceexportdetail
		END
			BEGIN
				SELECT ied.Id ,p.Id as 'ProductId',p.name as 'ProductName',ied.Counts,iid.InputPrice,p.price as 'OutputPrice',ie.DateOutput  INTO ##reports_invoiceexportdetail
				FROM  InvoiceExportDetail ied
				JOIN InvoiceImportDetail iid
				ON ied.IdInvoiceImportDetail = iid.Id	
				JOIN InvoiceExport ie
				ON ie.Id = ied.IdInvoiceExport
				JOIN Products p
				ON p.Id = iid.IdProduct
			END	
			
	END
	GO

	

	/*
	*	Procedure sp_create_temp_reports_invoiceimportdetail lấy về toàn bộ thông tin nhập hàng trong 7 ngày gần nhất
	*/
create  PROCEDURE sp_create_temp_get_reports_invoiceimportdetail_nearest_week
	AS
		declare @today date,
				@thesamedaylastweek date
		BEGIN
			SET @today =  CAST(getdate() AS date);
			SET @thesamedaylastweek = DATEADD(day ,-7,@today )
			BEGIN				
				IF OBJECT_ID('tempdb..##reports_invoiceimportdetail','U') IS   NULL
				BEGIN
					exec sp_create_temp_get_all_reports_invoiceimportdetail
				END
				IF OBJECT_ID('tempdb..##reports_invoiceimportdetail_nearest_week','U') IS NOT  NULL
				BEGIN
					DROP TABLE    ##reports_invoiceimportdetail_nearest_week
				END
				
				SELECT * INTO ##reports_invoiceimportdetail_nearest_week			
					from ##reports_invoiceimportdetail
					where DateInput >=@thesamedaylastweek AND DateInput <=@today								
			END
END
GO


	/*
	*	Procedure sp_create_temp_reports_invoiceimportdetail lấy về toàn bộ thông tin xuat hàng trong 7 ngày gần nhất
	*/
alter  PROCEDURE sp_create_temp_get_reports_invoiceexportdetail_nearest_week
	AS
		declare @today date,
				@thesamedaylastweek date
		BEGIN
			SET @today =  CAST(getdate() AS date);
			SET @thesamedaylastweek = DATEADD(day ,-7,@today )
			BEGIN				
				IF OBJECT_ID('tempdb..##reports_invoiceexportdetail','U') IS   NULL
				BEGIN
					exec sp_create_temp_get_all_reports_invoiceexportdetail
				END
				IF OBJECT_ID('tempdb..##reports_invoiceexportdetail_nearest_week','U') IS NOT  NULL
				BEGIN
					DROP TABLE     ##reports_invoiceexportdetail_nearest_week	
				END
				
				SELECT * INTO ##reports_invoiceexportdetail_nearest_week			
					from ##reports_invoiceexportdetail
					where DateOutput >=@thesamedaylastweek AND DateOutput <=@today								
			END
END
GO
exec  sp_create_temp_get_reports_invoiceexportdetail_nearest_week
-- test procedure exec sp_create_temp_get_reports_invoiceimportdetail_nearest_week

/*
*	Procedure get all record in a year
*/


/*
*	Procedure get records invoiceimportdetail from atmost 5 year  to current year
*/
select * from customer
alter PROCEDURE sp_get_total_reports_from_atmost_5year_to_now
AS
 SET NOCOUNT ON
	declare  @firstyear  datetime, @currentyear datetime ,@startyear datetime ;
	BEGIN
		IF OBJECT_ID('tempdb..##reports_invoiceimportdetail','U') IS  NULL
			BEGIN
				exec sp_create_temp_get_all_reports_invoiceimportdetail
			END
		IF OBJECT_ID('tempdb..##reports_invoiceexportdetail','U') IS  NULL
			BEGIN
				exec sp_create_temp_get_all_reports_invoiceexportdetail
			END
		set @currentyear = dateadd(year,0,getdate());--2021
		set @firstyear =( SELECT  TOP 1 CONVERT(varchar(10),DateInput,101)  from InvoiceImport ORDER BY DateInput ASC)	 -- 2017 2021- 2017 =4
		
		set @startyear = IIF(year(@currentyear) -year(@firstyear)>5,dateadd(year,-5,getdate()), @firstyear ); --8 2021 -5 2017
		
		IF OBJECT_ID('tempdb..##tmpimportsyear','U') IS NOT NULL
		BEGIN
			DROP TABLE ##tmpimportsyear;
		END
		CREATE  TABLE ##tmpimportsyear(
			TimeToGet int,
			Totalimport  bigint,
			Totalexport bigint default 0
		)	
		WHILE(@startyear <=@currentyear)
			BEGIN		
				declare @sum int;
				SET @sum =0;		
					BEGIN
						IF EXISTS(SELECT 1 from ##reports_invoiceimportdetail  where year(Dateinput)=  year(@startyear ))	
						INSERT INTO ##tmpimportsyear(TimeToGet,Totalimport,Totalexport)		
						SELECT year(DateInput) , sum(Number*InputPrice),
						 (CASE WHEN EXISTS(SELECT 1 from ##reports_invoiceexportdetail  where year(Dateoutput) = year(@startyear ))
								THEN (select sum(outputprice*Counts) from ##reports_invoiceexportdetail  where year(Dateoutput) =  year(@startyear ) GROUP BY year(Dateoutput)) ELSE '0' END)
							FROM ##reports_invoiceimportdetail	
							WHERE  year(DateInput)=year(@startyear)
							GROUP by year(DateInput)								
					END
				SET  @startyear = dateadd(year,1, @startyear);
			END
		select * from ##tmpimportsyear
	END
	-- update 25/01	
	-- Thủ tục báo cáo  tổng hợp hàng xuất và nhập 6 tháng gần nhất
	alter PROCEDURE sp_get_total_reports_from_6_most_recent_months
AS
 SET NOCOUNT ON
	declare  @firsttime  datetime, @currenttime datetime ,@strstartmonth varchar(20),@strdatamonth varchar(20) ;
	BEGIN
		IF OBJECT_ID('tempdb..##reports_invoiceimportdetail','U') IS  NULL
			BEGIN
				exec sp_create_temp_get_all_reports_invoiceimportdetail
			END
		IF OBJECT_ID('tempdb..##reports_invoiceexportdetail','U') IS  NULL
			BEGIN
				exec sp_create_temp_get_all_reports_invoiceexportdetail
			END
		IF OBJECT_ID('tempdb..##tmpreports6mostrecentmonth','U') IS NOT NULL
		BEGIN
			DROP TABLE ##tmpreports6mostrecentmonth;
		END
		-- get time now
		set @currenttime = dateadd(month,0,getdate());
		-- get the first day of last 6 month
		set @firsttime = DATEADD(MONTH, DATEDIFF(MONTH, 0,dateadd(month,-5,@currenttime)), 0)
								
		CREATE  TABLE ##tmpreports6mostrecentmonth(
			TimeToGet varchar(20),
			Totalimport bigint default 0,
			Totalexport bigint default 0
		)	
		WHILE(@firsttime<=@currenttime)	
			BEGIN		-- begin while
				SET @strstartmonth = convert(varchar(7),@firsttime,111) 
				declare @sum int;
				SET @sum =0;		
					BEGIN	
						IF EXISTS(SELECT 1 from ##reports_invoiceimportdetail  where @strstartmonth = convert(varchar(7),Dateinput,111) )						
							BEGIN  -- begin IF
								INSERT INTO ##tmpreports6mostrecentmonth(TimeToGet,Totalimport,Totalexport)		
								SELECT @strstartmonth ,
								 sum(Number*Inputprice),
								 (CASE WHEN EXISTS(SELECT 1 from ##reports_invoiceexportdetail where @strstartmonth =convert(varchar(7),Dateoutput,111))
										THEN (select sum(Outputprice*Counts) from ##reports_invoiceexportdetail  where @strstartmonth = convert(varchar(7),DateOutput,111) 
										GROUP BY convert(varchar(7),DateOutput,111)) ELSE '0' END)
									FROM ##reports_invoiceimportdetail	
								 where @strstartmonth = convert(varchar(7),dateinput,111)  GROUP BY  CONVERT(VARCHAR(7),Dateinput,111)	
					
							END -- end if
						ELSE
							BEGIN -- begin else
								INSERT INTO ##tmpreports6mostrecentmonth(TimeToGet,Totalimport,Totalexport)		
								SELECT TOP 1 @strstartmonth ,
								0,
								 (CASE WHEN EXISTS(SELECT 1 from ##reports_invoiceexportdetail where @strstartmonth =convert(varchar(7),dateoutput,111))
										THEN (select sum(Outputprice*Counts) from ##reports_invoiceexportdetail  where @strstartmonth = convert(varchar(7),DateOutput,111) 
										GROUP BY convert(varchar(7),DateOutput,111)) ELSE '0' END)
									FROM ##reports_invoiceimportdetail												
							END -- end else
					END
				SET  @firsttime = dateadd(month,1, @firsttime);
				
			END -- end while
			select * from ##tmpreports6mostrecentmonth
	END
	exec sp_get_total_reports_from_6_most_recent_months


	/*
	* Thủ tục lấy ra báo cáo số lượng hàng xuất và nhậptrong 7 ngày liên tiếp
	* 
	*/
	select * from ##reports_invoiceexportdetail_nearest_week
ALTER PROCEDURE sp_get_total_reports_from_nearest_week
AS
 SET NOCOUNT ON
	declare  @firstday  datetime, @currentday datetime  ;
	BEGIN				
			-- b1: Ta Tạo temp tổng  báo cáo lượng  nhập
			BEGIN
				exec sp_create_temp_get_reports_invoiceimportdetail_nearest_week;
			END
			-- b2: Ta Tạo temp tổng  báo cáo lượng  xuất
			BEGIN
				exec sp_create_temp_get_reports_invoiceexportdetail_nearest_week;
			END	
		IF OBJECT_ID('tempdb..##tmpimport','U') IS NOT NULL
			BEGIN
				DROP TABLE  ##tmpimport;
			END		
		set @currentday = dateadd(day,0,getdate());	
		set @firstday = dateadd(day,-6,@currentday);	
		CREATE  TABLE ##tmpimport(
			TimeToGet varchar(20),
			Totalimport  bigint,
			Totalexport bigint default 0
		)		;
		WHILE(@firstday <=@currentday)
		BEGIN
		declare @sum int;
		SET @sum =0;
		BEGIN
			IF EXISTS(SELECT 1 from ##reports_invoiceimportdetail_nearest_week  where day(Dateinput)=  day(@firstday ))		
				BEGIN
					INSERT  INTO  ##tmpimport(TimeToGet,Totalimport,Totalexport)		
					SELECT  CONVERT(VARCHAR(5),Dateinput,103) ,
						 sum(Number*Inputprice),
						 (CASE WHEN EXISTS(SELECT 1 from ##reports_invoiceexportdetail_nearest_week
											where day(Dateoutput)=  day(@firstday ))
						 THEN (select sum(Outputprice*Counts) from ##reports_invoiceexportdetail_nearest_week  where day(Dateoutput)=  day(@firstday ) GROUP BY day(Dateoutput))
						 ELSE '0'
						 END) 
					FROM ##reports_invoiceimportdetail_nearest_week
					where day(Dateinput)=  day(@firstday)
					GROUP BY  CONVERT(VARCHAR(5),Dateinput,103)		;			
				END	
			ELSE
				BEGIN
					INSERT  INTO  ##tmpimport(TimeToGet,Totalimport,Totalexport)		
				SELECT  TOP 1 CONVERT(VARCHAR(5),@firstday,103) ,
						0,
						 (CASE WHEN EXISTS(SELECT 1 from ##reports_invoiceexportdetail_nearest_week
											where day(Dateoutput)=  day(@firstday ))
						 THEN (select sum(Outputprice*Counts) from ##reports_invoiceexportdetail_nearest_week
								where day(Dateoutput)=  day(@firstday )
								 GROUP BY day(Dateoutput))
						 ELSE '0'
						 END) 
					FROM ##reports_invoiceimportdetail_nearest_week  		;	
				END
		END				
			SET  @firstday = dateadd(day,1, @firstday);	
		END
		
		select * from ##tmpimport;
		
	END

	/*
	end procedure
	*/
	exec sp_get_total_reports_from_nearest_week



	select * from InvoiceExportDetail

	select * from InvoiceExport
	
	--tổng tiền hóa đơn.
	select sum(ied.Counts*p.price) as 'tien hoa don',ied.IdInvoiceExport as 'ma hoa don' from InvoiceexportDetail ied join InvoiceImportDetail iid on ied.IdInvoiceImportDetail = iid.Id join Products p on p.Id = iid.IdProduct group by ied.IdInvoiceExport 
	
	--stored procedure, try catch : ERROR_LINE(), ERROR_MESSAGE()
	--demo:
	BEGIN TRY
		BEGIN TRAN INSERT_TRAN
		INSERT INTO ...
		INSERT INTO ...
		COMMIT INSERT_TRAN
	END TRY
	BEGIN CATCH
		PRINT 'INSERT THAT BAT TAI DONG:' +  ERROR_LINE()
		ROLLBACK TRANSACTION INSERT_TRAN
	END CATCH
	--demo


	--demo 2:
	create proc usp_recored
	as
	begin
		declare @result int
		select * from InvoiceExportDetail
		set @result = @@ROWCOUNT
		PRINT(@result)
	end

	create proc usp_recored2
		@result int out
	as
	begin
		select * from InvoiceExportDetail
		set @result = @@ROWCOUNT
	end

	declare @result int
	exec @result out
	--demo 2:






	
	-- update 25/01	
	-- Thủ tục lấy lãi suất 10 sản phẩm cao nhất trong tuần
ALTER PROCEDURE sp_get_top_10_profits_from_nearest_week
AS
	SET NOCOUNT ON
	declare @nowdate datetime, @lastweekdate datetime
	BEGIN
	set @nowdate = getdate();
	set @lastweekdate = dateadd(day,-6,convert(date,@nowdate));	
	IF OBJECT_ID('tempdb..##tmpouputreportsnearweek','U') IS NOT NULL
			BEGIN
				DROP TABLE  ##tmpouputreportsnearweek;
			END
	IF OBJECT_ID('tempdb..##reports_invoiceexportdetail','U') IS  NULL
			BEGIN
				exec sp_create_temp_get_all_reports_invoiceexportdetail
			END
			CREATE  TABLE ##tmpouputreportsnearweek(
				ProductName nvarchar(100),
				InputPrice  bigint,
				OutputPrice bigint,
				Counts int,
				DateOutput datetime
				);
			INSERT  INTO ##tmpouputreportsnearweek(ProductName,InputPrice,OutputPrice,Counts,DateOutput)
			select ProductName,InputPrice,outputPrice,Counts,DateOutput
			from ##reports_invoiceexportdetail	
			where DateOutput >=@lastweekdate AND DateOutput<=@nowdate
			select TOP 10 productName,sum((p.outputPrice-p.inputPrice)*p.counts) as 'totalProfits' from ##tmpouputreportsnearweek p GROUP BY productName ORDER BY  sum((p.outputPrice-p.inputPrice)*p.counts)DESC
	END	
	 
	exec sp_get_top_10_profits_from_nearest_week 
	-- update 25/01	
	-- -- Thủ tục lấy lãi suất 10 sản phẩm cao nhất trong  3 tháng gần nhất
	ALTER PROCEDURE sp_get_top_10_profits_from_3_most_recent_months
AS
 SET NOCOUNT ON
	declare  @firsttime  datetime, @currenttime datetime ,@strstartmonth varchar(20),@strdatamonth varchar(20) ;
	BEGIN
		
		IF OBJECT_ID('tempdb..##reports_invoiceexportdetail','U') IS  NULL
			BEGIN
				exec sp_create_temp_get_all_reports_invoiceexportdetail
			END
		-- get time now
		set @currenttime = dateadd(month,0,getdate());
		-- get the first day of last 3 month
		set @firsttime = DATEADD(MONTH, DATEDIFF(MONTH, 0,dateadd(month,-2,@currenttime)), 0)	
		IF OBJECT_ID('tempdb..##tmpgettop10output3mostrecentmonth','U') IS NOT NULL
		BEGIN
			DROP TABLE ##tmpgettop10output3mostrecentmonth;
		END
		CREATE  TABLE ##tmpgettop10output3mostrecentmonth(
				ProductName nvarchar(100),
				InputPrice  bigint,
				OutputPrice bigint,
				Counts int,
				DateOutput datetime
				);		
			INSERT  INTO ##tmpgettop10output3mostrecentmonth(ProductName,InputPrice,OutputPrice,Counts,DateOutput)
			select Productname,InputPrice,outputPrice,Counts,DateOutput
			from ##reports_invoiceexportdetail	
			where DateOutput >=@firsttime AND DateOutput<=@currenttime
			select TOP 10 productName,sum((p.outputPrice-p.inputPrice)*p.counts) as 'totalProfits' from ##tmpgettop10output3mostrecentmonth p GROUP BY productName ORDER BY  sum((p.outputPrice-p.inputPrice)*p.counts)DESC	
			
	END
	exec sp_get_top_10_profits_from_3_most_recent_months
	--update 25/1
	-- Thủ tục tính lượng hàng tồn kho theo số lượng sản phẩm trong kho giảm dần
	ALTER PROCEDURE sp_get_inventories_at_current
AS
 SET NOCOUNT ON
	BEGIN				
			IF OBJECT_ID('tempdb..##reports_invoiceimportdetail','U') IS  NULL
			BEGIN
				exec sp_create_temp_get_all_reports_invoiceimportdetail
			END
		IF OBJECT_ID('tempdb..##reports_invoiceexportdetail','U') IS  NULL
			BEGIN
				exec sp_create_temp_get_all_reports_invoiceexportdetail
			END
		IF OBJECT_ID('tempdb..##productInInventory','U') IS NOT NULL
		BEGIN
			DROP TABLE ##productInInventory;
		END
		BEGIN
			CREATE  TABLE ##productInInventory(
				ProductId varchar(100) ,
				ProductName nvarchar(100),
					total bigint
				);
		END
		BEGIN
			INSERT INTO  ##productInInventory(ProductId,ProductName,total)
			select ProductId,ProductName,
					(sum(Number) - (CASE WHEN EXISTS (select 1 from ##reports_invoiceexportdetail ied WHERE ied.ProductId = iid.ProductId)
									THEN (select sum(counts) from ##reports_invoiceexportdetail ied WHERE ied.ProductId = iid.ProductId GROUP BY ProductID)
									ELSE '0' END)) as 'total'
			from ##reports_invoiceimportdetail iid
			GROUP BY ProductId,ProductName	
		END
		
	END

	exec sp_get_inventories_at_current
	-- update 25/1
-- Thủ tục tính lượng hàng tồn kho theo danh mục sản phẩm
	ALTER PROCEDURE sp_get_inventories_at_current_by_category
AS
 SET NOCOUNT ON

	BEGIN				
			IF OBJECT_ID('tempdb..##productInInventory','U') IS  NULL
			BEGIN
				exec sp_get_inventories_at_current
			END
		
		IF OBJECT_ID('tempdb..##productsInInventoryByCategories','U') IS NOT NULL
		BEGIN
			DROP TABLE ##productsInInventoryByCategories;
		END
		BEGIN
			CREATE  TABLE ##productsInInventoryByCategories(
				CateId varchar(100) ,
				CateName nvarchar(100),
					total bigint
				);
		END
		BEGIN
			INSERT INTO  ##productsInInventoryByCategories(CateId,CateName,total)				
			select ca.Id,ca.name,sum(total) from  ##productInInventory pin
			join products p
			on  pin.ProductId = p.Id
			join category ca
			on p.IdCate = ca.Id
			GROUP BY ca.Id,ca.name
		END
		BEGIN
			SELECT * FROM ##productsInInventoryByCategories ORDER BY total DESC
		END
	END

	exec  sp_get_top_10_profits_from_3_most_recent_months