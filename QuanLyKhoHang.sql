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
	IdCate int
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
	DateInput DateTime
	
)
go
--tạo bảng InvoiceImportDetail
create table InvoiceImportDetail(
	Id nvarchar(100) primary key,
	IdProduct nvarchar(100) not null,
	IdInvoiceImport nvarchar(100) not null,
	Number int,
	InputPrice float default(0),
	OutputPrice float default(0),
	Status nvarchar(100)
)
go

--tạo bảng InvoiceExport
create table InvoiceExport(
	Id nvarchar(100) primary key,
	DateOutput DateTime,
	IdCustomer int not null
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

--tạo khóa ngoại InvoiceExportDetail và products
ALTER TABLE InvoiceExportDetail
ADD CONSTRAINT FK_08 FOREIGN KEY (idProduct) REFERENCES products(Id);
--tạo khóa ngoại InvoiceExportDetail và InvoiceImportDetail
ALTER TABLE InvoiceExportDetail
ADD CONSTRAINT FK_09 FOREIGN KEY (IdInvoiceImportDetail) REFERENCES InvoiceImportDetail(Id);
--tạo khóa ngoại InvoiceExportDetail và invoiceExport
ALTER TABLE InvoiceExportDetail
ADD CONSTRAINT FK_10 FOREIGN KEY (idinvoiceExport) REFERENCES invoiceExport(Id)
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
	CREATE procedure sp_count_products (
	@output int output
	)

 AS			
		BEGIN
		SET @output	=(select count(*)FROM  Products		)
			
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
	@number int,
	@inputPrice float,
	@outputPrice float,
	@status nvarchar(100)	
)

	AS
	declare  @idInvoiceImport varchar(20),
			 @countInvoiceImport int,
			 @idInvoiceimportDetail varchar(100),
			 @countInvoiceImportDetail int
		BEGIN TRANSACTION
			BEGIN TRY
			-- get count from imvoiceimport table
			set @countInvoiceImport = ((SELECT count(id) from invoiceimport)+1)	
			-- set id for new record insert to invoiceimport table
			SET @idInvoiceImport = 'I'+ REPLICATE('0',6 - LEN(CAST(@countInvoiceImport as varchar(20)))) +CAST(@countInvoiceImport as varchar(20))
				-- get count from imvoiceimportDetail table
			set @countInvoiceImportDetail= ((SELECT count(id) from InvoiceImportDetail)+1)		
			-- set id for new record insert to invoiceimportDetail table
			SET @idInvoiceimportDetail = 'ID'+ REPLICATE('0',6 - LEN(CAST(@countInvoiceImportDetail as varchar(20))))+CAST(@countInvoiceImportDetail as varchar(20))
				INSERT INTO InvoiceImport (id,DateInput)VALUES(@idInvoiceImport,@dateImport)

				INSERT INTO InvoiceImportDetail(Id,IdProduct,IdInvoiceImport,Number,InputPrice,OutputPrice,Status)
							VALUES(@idinvoiceimportDetail,@idProduct,@idInvoiceImport,@number,@inputPrice,@outputPrice,@status)
				SET @errOutput =0;
				COMMIT TRANSACTION
			END TRY
			BEGIN CATCH
			SET @errOutput =1;
			ROLLBACK TRANSACTION
			 RETURN ERROR_MESSAGE()
			END CATCH
			GO
/*	 Test sql insert into 2 table InvoiceImportDetail va InvoiceImport

	select * from Products
declare @output1 int	
exec sp_add_invoice_import_Detail @output1 output,'02/10/2021','SP002',200,20000,80000,'1'
select @output1
select * from InvoiceImportDetail
select * from InvoiceImport
*/

select * from products