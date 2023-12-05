use master 
go
drop database if exists QuanLyNS;
go
create database QuanLyNS;
go
use QuanLyNS
go
create table TaiKhoan(
	tenDangNhap nvarchar(200) not null,
	matKhau nvarchar(200) not null,
	primary key (tenDangNhap)
)

create table PhongBan (
	maPB nvarchar(10) primary key,
	tenPB nvarchar(30) not null,
	diaChi nvarchar(50),
	soDienThoaiPB nvarchar(20)
)

create table Luong (
	bacLuong float primary key,
	luongCoBan float not null,
	heSoLuong float not null,
	heSoPhuCap float
)

create table ChucVu (
	maCV nvarchar(10) primary key,
	tenCV nvarchar(30) not null
)

create table TrinhDoHocVan (
	maTDHV nvarchar(10) primary key,
	tenTrinhDo nvarchar(30) not null,
	chuyenNganh nvarchar(30)
)

create table NhanVien(
	maNV nvarchar(10) not null,
	hoTen nvarchar(30) not null,
	ngaySinh date,
	queQuan nvarchar(max),
	gioiTinh bit,
	danToc nvarchar(20),
	soDienThoai nvarchar(40),
	maPB nvarchar(10),
	maCV nvarchar(10),
	maTDHV nvarchar(10),
	bacLuong float,
	constraint pk_nv primary key (maNV),
	foreign key (maPB) references PhongBan(maPB),
	foreign key (maTDHV) references TrinhDoHocVan(maTDHV),
	foreign key (bacLuong) references Luong(bacLuong),
)

create table ThoiGianCongTac (
	maNV nvarchar(10) not null,
	maCV nvarchar(10) not null,
	ngayNhapChuc date not null,
	constraint fk_tgct_nv foreign key (maNV) references nhanVien(maNV),
	constraint fk_tgct_cv foreign key (maCV) references ChucVu(maCV)
)

create table CongTac(
	maCT nvarchar(10) primary key,
	soQuyetDinh int not null,
	ngayCoHieuLuc date not null,
	nhiemVuCu nvarchar(250) not null,
	nhiemVuMoi nvarchar(250) not null,
	maNV nvarchar(10) not null,
	constraint fk_ct_nv foreign key (maNV) references nhanvien(maNV)
)