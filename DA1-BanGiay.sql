CREATE DATABASE nhom_7_ban_giay
USE nhom_7_ban_giay

CREATE TABLE LoaiGiay(
	IdLoaiGiay int identity(1,1) PRIMARY KEY,
	MaLoai varchar(10),
	TenLoai nvarchar(30),
	TrangThai bit
);
CREATE TABLE MauSac(
	IdMau int identity(1,1) PRIMARY KEY,
	MaMau varchar(10),
	TenMau nvarchar(30),
	TrangThai bit
);
CREATE TABLE Size(
	IdSize int identity(1,1) PRIMARY KEY,
	MaSize varchar(10),
	Size nvarchar(30),
	TrangThai bit
);
CREATE TABLE NhanHieu(
	IdNhanHieu int identity(1,1) PRIMARY KEY,
	MaNhanHieu varchar(10),
	TenNhanHieu nvarchar(30),
	TrangThai bit
);		
CREATE TABLE KieuDang(
	IdKieuDang int identity(1,1) PRIMARY KEY,
	MaKieuDang varchar(10),
	TenKieuDang nvarchar(30),
	TrangThai bit
);
CREATE TABLE DeGiay(
	IdDeGiay int identity(1,1) PRIMARY KEY,
	Ma varchar(10),
	ChatLieu nvarchar(30),
	ChieuCaoDe float,
	TrangThai bit
);
CREATE TABLE GiayCT(
	IdGiayCT int identity(1,1) PRIMARY KEY,
	MaGiayCT varchar(10),
	TenGiay nvarchar(30),
	GiaNhap decimal,
	GiaBan decimal,
	SoLuongTon int,
	Anh varchar(30),
	MoTa nvarchar(40),
	TrangThai bit,
	IdLoaiGiay int,
	IdMau int,
	IdSize int,
	IdNhanHieu int,
	IdKieuDang int,
	IdDeGiay int
);
CREATE TABLE NhanVien(
	IdNhanVien int identity(1,1) PRIMARY KEY,
	MaNhanVien varchar(10),
	HoVaTenNhanVien nvarchar(50),
	GioiTinh bit,
	DiaChi nvarchar(50),
	SDT nvarchar(12),
	Email nvarchar(20),
	cccd varchar(13),
	TenTaiKhoan varchar(20),
	MatKhau varchar(20),
	ChucVu nvarchar(20),
	GhiChu nvarchar(50)
);
CREATE TABLE KhachHang(
	IdKhachHang int identity(1,1) PRIMARY KEY,
	MaKhachHang varchar(10),
	Hoten nvarchar(50),
	GioiTinh bit,
	NgaySinh Date,
	DiaChi nvarchar(50),
	SDT nvarchar(13),
	Emai nvarchar(30),
	TrangThai bit,
	cccd varchar(13),
	GhiChu nvarchar(50)
);
CREATE TABLE HoaDon(
	Id int identity(1,1) PRIMARY KEY,
	MaHoaDon varchar(10),
	IdNhanVien int,
	IdKhachHang int,
	TenKhachHang nvarchar(50),
	NgayTao date,
	TongTien decimal,
	NgayThanhToan date,
	TrangThai bit,
	GhiChu nvarchar(50),
	NgayShip date,
	TienShip decimal,
	TienCoc decimal,
	NgayNhan date,
	DiaChi nvarchar(50),
	TenNguoiShip nvarchar(50),
	CCCDNguoiShip varchar(13),
	SDTNguoiShip nvarchar(13),
	SDTNguoiNhan nvarchar(13)
);
CREATE TABLE HoaDonChiTiet(
	IdGiayCT int,
	IdHoaDon int,
	Soluong int,
	GiaBan decimal
	PRIMARY KEY(IdGiayCT,IdHoaDon)
);
CREATE TABLE KhuyenMaiGiay(
	IdGiayCT int identity(1,1) PRIMARY KEY,
	IdKhuyenMai int,
	GiaBan decimal,
	GiaKhuyenMai decimal,
	TrangThai bit,
	Primary key (IdGiayCT, IdKhuyenMai)
);
CREATE TABLE KhuyenMai(
	IdKhuyenMai int identity(1,1) PRIMARY KEY,
	MaKhuyenMai varchar(10),
	TenKhuyenMai nvarchar(50),
	NgayBatDau date,
	NgayKetThuc date,
	PhanTramGiam int,
	DieuKien nvarchar(30),
	TrangThai bit
);
CREATE TABLE DonDoiHang(
	IdDon int identity(1,1) PRIMARY KEY,
	NgayDoiTra date,
	NgayMua date,
	IdNhanVien int,
	IdHoaDon int,
	IdKhachHang int
);
CREATE TABLE DoiHangCT(
	IdDoiTra int identity(1,1) PRIMARY KEY,
	IdGiay int,
	IdDon int,
	TenGiay nvarchar(50),
	SoLuong int,
	TrangThaiGiay bit,
	LyDoDoiTra nvarchar(50),
	MoTa nvarchar(50),
);

--Khóa ngoại Giày CT
ALTER TABLE GiayCT
ADD CONSTRAINT fk_GiayCT_id_LoaiGiay
 FOREIGN KEY (IdLoaiGiay)
 REFERENCES LoaiGiay (IdLoaiGiay);

ALTER TABLE GiayCT
ADD CONSTRAINT fk_GiayCT_id_MauSac
 FOREIGN KEY (IdMau)
 REFERENCES MauSac (IdMau);

ALTER TABLE GiayCT
ADD CONSTRAINT fk_GiayCT_id_Size
 FOREIGN KEY (IdSize)
 REFERENCES Size (IdSize);

ALTER TABLE GiayCT
ADD CONSTRAINT fk_GiayCT_id_NhanHieu
 FOREIGN KEY (IdNhanHieu)
 REFERENCES NhanHieu (IdNhanHieu);

ALTER TABLE GiayCT
ADD CONSTRAINT fk_GiayCT_id_KieuDang
 FOREIGN KEY (IdKieuDang)
 REFERENCES KieuDang (IdKieuDang);

ALTER TABLE GiayCT
ADD CONSTRAINT fk_GiayCT_id_DeGiay
 FOREIGN KEY (IdDeGiay)
 REFERENCES DeGiay (IdDeGiay);

--Khóa ngoại Khuyến mại giày

ALTER TABLE KhuyenMaiGiay
ADD CONSTRAINT fk_KhuyenMaiGiay_id_GiayCT
 FOREIGN KEY (IdGiayCT)
 REFERENCES GiayCT (IdGiayCT);

ALTER TABLE KhuyenMaiGiay
ADD CONSTRAINT fk_KhuyenMaiGiay_id_KhuyenMai
 FOREIGN KEY (IdKhuyenMai)
 REFERENCES KhuyenMai (IdKhuyenMai);

--Khóa ngoại Hóa Đơn Chi Tiết

ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT fk_HoaDonChiTiet_id_HoaDon
 FOREIGN KEY (IdHoaDon)
 REFERENCES HoaDon (Id);

ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT fk_HoaDonChiTiet_id_GiayCT
 FOREIGN KEY (IdGiayCT)
 REFERENCES GiayCT (IdGiayCT);

--Khóa ngoại Hóa Đơn

ALTER TABLE HoaDon
ADD CONSTRAINT fk_HoaDon_id_NhanVien
 FOREIGN KEY (IdNhanVien)
 REFERENCES NhanVien (IdNhanVien);

ALTER TABLE HoaDon
ADD CONSTRAINT fk_HoaDon_id_KhachHang
 FOREIGN KEY (IdKhachHang)
 REFERENCES KhachHang (IdKhachHang);

--Khóa ngoại Đơn Đổi Trả

ALTER TABLE DonDoiTra
ADD CONSTRAINT fk_DonDoiTra_id_HoaDon
 FOREIGN KEY (IdHoaDon)
 REFERENCES HoaDon (Id);

--Khóa ngoại Đổi Trả

ALTER TABLE DoiTra
ADD CONSTRAINT fk_DoiTra_id_DonDoiTra
 FOREIGN KEY (IdDon)
 REFERENCES DonDoiTra (IdDon);