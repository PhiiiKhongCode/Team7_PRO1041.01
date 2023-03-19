CREATE DATABASE nhom_7_ban_giay
USE nhom_7_ban_giay

CREATE TABLE LoaiGiay(
	IdLoaiGiay varchar(10) PRIMARY KEY,
	MaLoai varchar(10),
	TenLoai nvarchar(30),
	TrangThai nvarchar(30)
);
CREATE TABLE MauSac(
	IdMau varchar(10) PRIMARY KEY,
	MaMau varchar(10),
	TenMau nvarchar(30),
	TrangThai nvarchar(30)
);
CREATE TABLE Size(
	IdSize varchar(10) PRIMARY KEY,
	MaSize varchar(10),
	Size nvarchar(30),
	TrangThai nvarchar(30)
);
CREATE TABLE NhanHieu(
	IdNhanHieu varchar(10) PRIMARY KEY,
	MaNhanHieu varchar(10),
	TenNhanHieu nvarchar(30),
	TrangThai nvarchar(30)
);
CREATE TABLE KieuDang(
	IdKieuDang varchar(10) PRIMARY KEY,
	MaKieuDang varchar(10),
	TenKieuDang nvarchar(30),
	TrangThai nvarchar(30)
);
CREATE TABLE DeGiay(
	IdDeGiay varchar(10) PRIMARY KEY,
	MaDeGiay varchar(10),
	ChatLieu nvarchar(30),
	TrangThai nvarchar(30),
	KieuDangDe nvarchar(30),
	ChieuCaoDe varchar(10)
);
CREATE TABLE GiayCT(
	IdGiayCT varchar(10) PRIMARY KEY,
	MaGiayCT varchar(10),
	TenGiay nvarchar(30),
	GiaNhap decimal,
	GiaBan decimal,
	SoLuongTon int,
	Anh varchar(30),
	MoTa nvarchar(40),
	TrangThai nvarchar(30),
	IdLoaiGiay varchar(10),
	IdMau varchar(10),
	IdSize varchar(10),
	IdNhanHieu varchar(10),
	IdKieuDang varchar(10),
	IdDeGiay varchar(10)
);
CREATE TABLE NhanVien(
	IdNhanVien varchar(10) PRIMARY KEY,
	MaNhanVien varchar(10),
	HoVaTenNhanVien nvarchar(50),
	GioiTinh nvarchar(5),
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
	IdKhachHang varchar(10) PRIMARY KEY,
	MaKhachHang varchar(10),
	Hoten nvarchar(50),
	GioiTinh nvarchar(5),
	NgaySinh Date,
	DiaChi nvarchar(50),
	SDT nvarchar(13),
	Emai nvarchar(30),
	TrangThai nvarchar(50),
	cccd varchar(13),
	GhiChu nvarchar(50)
);
CREATE TABLE HoaDon(
	Id varchar(10) PRIMARY KEY,
	MaHoaDon varchar(10),
	IdNhanVien varchar(10),
	IdKhachHang varchar(10),
	TenKhachHang nvarchar(50),
	NgayTao date,
	TongTien decimal,
	NgayThanhToan date,
	TrangThai nvarchar(50),
	GhiChu nvarchar(50),
	NgayShip date,
	TienShip decimal,
	TienCoc decimal,
	NgayNhan date,
	DiaChi nvarchar(50),
	TenNguoiShip nvarchar(50),
	CCCDNguoiShip varchar(13),
	SDTNguoiShip nvarchar(13),
	SDRNguoiNhan nvarchar(13)
);
CREATE TABLE HoaDonChiTiet(
	IdGiayCT varchar(10),
	IdHoaDon varchar(10),
	Soluong int,
	GiaBan decimal
	PRIMARY KEY(IdGiayCT,IdHoaDon)
);
CREATE TABLE KhuyenMaiGiay(
	IdGiayCT varchar(10),
	IdKhuyenMai varchar(10),
	GiaBan decimal,
	GiaKhuyenMai decimal,
	TrangThai nvarchar(30)
	Primary key (IdGiayCT, IdKhuyenMai)
);
CREATE TABLE KhuyenMai(
	IdKhuyenMai varchar(10) PRIMARY KEY,
	MaKhuyenMai varchar(10),
	TenKhuyenMai nvarchar(50),
	NgayBatDau date,
	NgayKetThuc date,
	PhanTramGiam int,
	DieuKien nvarchar(30),
	TrangThai nvarchar(40)
);
CREATE TABLE DonDoiTra(
	IdDon varchar(10) PRIMARY KEY,
	NgayDoiTra date,
	NgayMua date,
	HinhThuc nvarchar(30),
	IdNhanVien varchar(10),
	IdHoaDon varchar(10),
	IdKhachHang varchar(10)
);
CREATE TABLE DoiTra(
	IdDoiTra varchar(10) PRIMARY KEY,
	IdGiay varchar(10),
	IdDon varchar(10),
	TenGiay nvarchar(50),
	SoLuong int,
	TrangThaiGiay nvarchar(40),
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