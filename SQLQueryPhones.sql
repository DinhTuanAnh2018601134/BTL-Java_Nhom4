use master 
go

create database Phones

use Phones 
go

create table Kho(
	MaKho char(10) not null primary key,
	TenKho nvarchar(30),
	DiaChi nvarchar(30)
)
create table HangSanXuat(
	MaHangSX char(10) not null primary key,
	TenHangSX Nvarchar(30)
)
create table DienThoai(
	MaDT char(10) not null primary key,
	MaHangSX char(10),
	TenDT varchar(30),
	SoLuong int,
	GiaBan int,
	RAM int,
	ROM int,
	MaKho char(10),
	constraint Fk_Kho foreign key(MaKho) references Kho(MaKho),
	constraint Fk_HangSX foreign key(MaHangSX) references HangSanXuat(MaHangSX)
)
create table ChucVu(
	MaCV char(10) not null primary key,
	TenCV nvarchar(30)
)
create table NhanVien(
	MaNV char(10) not null primary key,
	TenNV nvarchar(50),
	Luong int,
	GioiTinh nvarchar(10),
	DiaChi nvarchar(50),
	SDT char(20),
	Email nvarchar(30),
	MaCV char(10)
	constraint Fk_ChucVu foreign key(MaCV) references ChucVu(MaCV)
)
create table KhachHang(
	MaKH char(10) not null primary key,
	TenKH nvarchar(50),
	GioiTinh nvarchar(10),
	DiaChi nvarchar(50),
	SDT char(20),
	Email nvarchar(30)
)
create table HoaDon(
	MaHD char(10) not null primary key,
	NgayLap date,
	MaNV char(10),
	MaKH char(10),
	constraint FK_NV_HD foreign key(MaNV) references NhanVien(MaNV),
	constraint FK_KH_HD foreign key(MaKH) references KhachHang(MaKH)
)

create table ChiTietHoaDon(
	MaHD char(10),
	MaDT char(10),
	GiaBan int,
	SoLuongBan int,
	TongTien int,
	constraint PK_CTHD primary key(MaHD,MaDT),
	constraint FK_HD foreign key(MaHD) references HoaDon(MaHD),
	constraint FK_DT foreign key(MaDT) references DienThoai(MaDT)
)

create table TaiKhoanAdmin(
	AdminName nvarchar(30) not null primary key,
	AdminPassWord char(20) not null,
	MaNV char(10),
	constraint FK_NV_QL foreign key(MaNV) references NhanVien(MaNV)
)
create table TaiKhoanNV(
	UserName nvarchar(30) not null primary key,
	UserPassword char(20) not null,
	MaNV char(10),
	constraint FK_NV_TH foreign key(MaNV) references NhanVien(MaNV)
)

insert into Kho values('KHO_001',N'kho Số 1','Hà Nội')
insert into Kho values('KHO_002',N'kho Số 2','Hà Nội')

insert into HangSanXuat values('AP','Apple')
insert into HangSanXuat values('SS','SamSung')
insert into HangSanXuat values('OP','Oppo')
insert into HangSanXuat values('XI','Xiaomi')

insert into DienThoai values('IP001','AP','Iphone 9',100,12000000,4,64,'KHO_001')
insert into DienThoai values('IP002','AP','Iphone 11',100,2000000,6,128,'KHO_001')
insert into DienThoai values('SS001','SS','SamSung Galaxy S100',100,12000000,7,128,'KHO_001')
insert into DienThoai values('XI001','XI','Xiaomi Mi 9',50,15000000,4,64,'KHO_002')
insert into DienThoai values('OP001','OP','Oppo A93',70,9000000,6,64,'KHO_002')

insert into ChucVu values('QL',N'Quản Lý')
insert into ChucVu values('KT',N'kế Toán')
insert into ChucVu values('BH',N'Bán Hàng')
insert into ChucVu values('BV',N'Bảo Vệ')

insert into NhanVien values('QL001',N'Tuấn Anh',50000000,'Nam',N'Hà Nội','0987654321','tuananh@gmail.com','QL')
insert into NhanVien values('KT001',N'Anh Tuấn',10000000,'Nam',N'Hà Nội','0987654321','anhtuan@gmail.com','KT')
insert into NhanVien values('BH001',N'Quang Thức',7000000,'Nam',N'Hà Nội','0987654321','quangthuc@gmail.com','BH')
insert into NhanVien values('BV001',N'Thức Quang',5000000,'Nam',N'Hà Nội','0987654321','thucquang@gmail.com','BV')

insert into KhachHang values('KH001',N'Thanh Huyền',N'Nữ',N'Hà Nội','0123456789','thanhhuyen@gmail.com')
insert into KhachHang values('KH002',N'Thanh Thư',N'Nữ',N'Hà Nội','0123456789','thanhthu@gmail.com')

insert into HoaDon values('HD001','09-05-2021','NV001','KH001')
insert into HoaDon values('HD002','09-05-2021','NV002','KH001')

insert into ChiTietHoaDon values('HD001','IP001',1,12000000)
insert into ChiTietHoaDon values('HD001','IP002',2,40000000)
insert into ChiTietHoaDon values('HD001','SS001',2,40000000)

insert into TaiKhoanAdmin values('chickenhero','05092000','QL001')
insert into TaiKhoanAdmin values('1','1','QL001')

insert into TaiKhoanNV values('2','2','KT001')
insert into TaiKhoanNV values('3','3','KT002')
insert into TaiKhoanNV values('4','4','KT003')
select * from ChiTietHoaDon