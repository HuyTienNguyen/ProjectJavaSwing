create database QuanLyKhoHang
go
use QuanLyKhoHang
go



--tạo bảng UserRole
create table UserRole(
	Id int identity(1,1) primary key,
	Name nvarchar(100) -- vai trò
)
go

Insert into users (name,Username,Password,IdRole,email,verifyCode)VALUES ('giang','truonggiang','123455',1,'abc@gmail.com',234567)
SELECT * FROM Users WHERE (Name='abc@gmail.com'  OR EMAIL ='abc@gmail.com') AND verifyCode =23456
DELETE FROM UserRole WHERE Name='giang';
--tạo bảng Users
create table Users(
	Id int identity(1,1) primary key,
	Name nvarchar(100),
	Username nvarchar(100),
	Password nvarchar(100),
	IdRole int not null 
)
go

--tạo bảng Unit
create table Unit(
	Id int identity(1,1) primary key,
	name nvarchar(100)
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
	ContractDate DateTime
)
go
--tạo bảng Objects
create table Objects(
	Id nvarchar(100) primary key,
	name nvarchar(100),
	IdUnit int not null,
	IdSuplier int not null
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

--tạo bảng Input
create table Input(
	Id nvarchar(100) primary key,
	DateInput DateTime
)
go
--tạo bảng InputInfo
create table InputInfo(
	Id nvarchar(100) primary key,
	IdObjects nvarchar(100) not null,
	IdInput nvarchar(100) not null,
	Counts int,
	InputPrice float default(0),
	OutputPrice float default(0),
	Status nvarchar(100)
)
go

--tạo bảng Output
create table Output(
	Id nvarchar(100) primary key,
	DateOutput DateTime
)
go
--tạo bảng OutputInfo
create table OutputInfo(
	Id nvarchar(100) primary key,
	IdObjects nvarchar(100) not null,
	IdInputInfo nvarchar(100) not null,
	IdOutput nvarchar(100) not null,
	IdCustomer int not null,
	Counts int,
	Status nvarchar(100)
)
go


 -- thêm trường email và verifyCode cho User
 ALTER TABLE Users
 ADD  email varchar(200) 
  ALTER TABLE Users
 ADD  verifyCode int NULL
 --thêm trường characters cho suplier
 ALTER TABLE Suplier
 ADD characters varchar(50)
 --thêm trường idCate cho objects
 ALTER TABLE Objects
 ADD IdCate int
 --thêm bảng category
 create table category(
	Id int identity(1,1) primary key,
	name nvarchar(100),
	characters nvarchar(20)
 )	
 go

--tạo khóa ngoại Users và UserRole
ALTER TABLE Users
ADD CONSTRAINT FK_01 FOREIGN KEY (IdRole) REFERENCES UserRole(Id);
--tạo khóa ngoại Suplier và Objects
ALTER TABLE Objects
ADD CONSTRAINT FK_02 FOREIGN KEY (IdSuplier) REFERENCES Suplier(Id);
--tạo khóa ngoại Unit và Objects
ALTER TABLE Objects
ADD CONSTRAINT FK_03 FOREIGN KEY (IdUnit) REFERENCES Unit(Id);
--tạo khóa ngoại Objects và InputInfo
ALTER TABLE InputInfo
ADD CONSTRAINT FK_04 FOREIGN KEY (IdObjects) REFERENCES Objects(Id);
--tạo khóa ngoại Input và InputInfo
ALTER TABLE InputInfo
ADD CONSTRAINT FK_05 FOREIGN KEY (IdInput) REFERENCES Input(Id);
--tạo khóa ngoại Objects và OutputInfo
ALTER TABLE OutputInfo
ADD CONSTRAINT FK_06 FOREIGN KEY (IdObjects) REFERENCES Objects(Id);
--tạo khóa ngoại InputInfo và OutputInfo
ALTER TABLE OutputInfo
ADD CONSTRAINT FK_07 FOREIGN KEY (IdInputInfo) REFERENCES InputInfo(Id);
--tạo khóa ngoại Customer và OutputInfo
ALTER TABLE OutputInfo
ADD CONSTRAINT FK_08 FOREIGN KEY (IdCustomer) REFERENCES Customer(Id);
--tạo khóa ngoại Output và OutputInfo
ALTER TABLE OutputInfo
ADD CONSTRAINT FK_09 FOREIGN KEY (IdOutput) REFERENCES Output(Id);
--tạo khóa ngoại category và objects
ALTER TABLE Objects
ADD CONSTRAINT FK_10 FOREIGN KEY (IdCate) REFERENCES Category(Id);

 
 -- them du lieu mau
 INSERT INTO UserRole(name) VALUES('admin')
 INSERT INTO UserRole(name) VALUES('manager')
 GO
 select* from UserRole
  INSERT INTO Unit(name) VALUES('admin')
 INSERT INTO Unit(name) VALUES('manager')
 select * from Unit

 INSERT INTO Suplier(name,address,phone,email,MoreInfo,ContractDate)
 values('truong giang','ha noi','035723722','giang@gmail.com','hksajdfkhasdf','2020-09-05 09:32:22')
 select * from Suplier