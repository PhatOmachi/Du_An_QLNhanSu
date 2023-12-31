use QuanLyNS
go
-- example records for demo
-- Insert into TaiKhoan table
INSERT INTO TaiKhoan (tenDangNhap, matKhau) VALUES
  ('nguyenvananh', N'password123'),
  ('lethithao', N'securepass'),
  ('phamquangminh', N'strongpassword'),
  ('tranthithuy', N'pass123'),
  ('vuhoanglong', N'secret@123');

-- Insert into PhongBan table
INSERT INTO PhongBan (maPB, tenPB, diaChi, soDienThoaiPB) VALUES
  ('PB001', N'Phòng Nhân Sự', N'123 Đường ABC, Thành phố HCM', N'0123 456 789'),
  ('PB002', N'Phòng Kế Toán', N'456 Đường XYZ, Thành phố Hà Nội', N'0987 654 321'),
  ('PB003', N'Phòng Kinh Doanh', N'789 Đường MNO, Thành phố Đà Nẵng', N'0345 678 912'),
  ('PB004', N'Phòng IT', N'101 Đường PQR, Thành phố Cần Thơ', N'0765 432 109'),
  ('PB005', N'Phòng Quản lý', N'202 Đường DEF, Thành phố Hải Phòng', N'0234 567 890');

-- Insert into Luong table
INSERT INTO Luong (bacLuong, luongCoBan, heSoLuong, heSoPhuCap) VALUES
  (1.0, 10000000, 1.2, 0.1),
  (2.0, 12000000, 1.5, 0.15),
  (3.0, 15000000, 1.8, 0.2),
  (4.0, 18000000, 2.0, 0.25),
  (5.0, 20000000, 2.2, 0.3);

-- Insert into ChucVu table
INSERT INTO ChucVu (maCV, tenCV) VALUES
  ('CV001', N'Nhân Viên'),
  ('CV002', N'Quản lý'),
  ('CV003', N'Trưởng Phòng'),
  ('CV004', N'Giám Đốc'),
  ('CV005', N'Chuyên Viên');

-- Insert into TrinhDoHocVan table
INSERT INTO TrinhDoHocVan (maTDHV, tenTrinhDo, chuyenNganh) VALUES
  ('TDHV001', N'Đại học', N'Kế Toán'),
  ('TDHV002', N'Thạc sĩ', N'Quản trị nhân sự'),
  ('TDHV003', N'Tiến sĩ', N'Công nghệ thông tin'),
  ('TDHV004', N'Cao đẳng', N'Marketing'),
  ('TDHV005', N'Khác', NULL);

-- Insert into NhanVien table
INSERT INTO NhanVien (maNV, hoTen, ngaySinh, queQuan, gioiTinh, danToc, soDienThoai, maPB, maCV, maTDHV, bacLuong) VALUES
  ('NV001', N'Nguyễn Văn Anh', N'1990-05-15', N'Hà Nội', 1, N'Kinh', N'0901234567', N'PB001', N'CV003', N'TDHV002', 3.0),
  ('NV002', N'Lê Thị Thảo', N'1985-12-10', N'Đà Nẵng', 0, N'Kinh', N'0987654321', N'PB002', N'CV004', N'TDHV003', 4.0),
  ('NV003', N'Phạm Quang Minh', N'1993-08-25', N'Hồ Chí Minh', 1, N'Kinh', N'0123456789', N'PB003', N'CV001', N'TDHV001', 1.0),
  ('NV004', N'Trần Thị Thúy', N'1988-04-20', N'Cần Thơ', 0, N'Kinh', N'0345678912', N'PB004', N'CV002', N'TDHV004', 2.0),
  ('NV005', N'Vũ Hoàng Long', N'1995-11-30', N'Hải Phòng', 1, N'Kinh', N'0765432109', N'PB005', N'CV005', N'TDHV005', 5.0);

-- Insert into ThoiGianCongTac table
INSERT INTO ThoiGianCongTac (maNV, maCV, ngayNhapChuc) VALUES
  ('NV001', N'CV003', N'2015-06-01'),
  ('NV002', N'CV004', N'2010-03-15'),
  ('NV003', N'CV001', N'2018-09-20'),
  ('NV004', N'CV002', N'2013-12-05'),
  ('NV005', N'CV005', N'2017-02-10');

-- Insert into CongTac table
insert into CongTac(maCT, soQuyetDinh, ngayCoHieuLuc, nhiemVuCu, nhiemVuMoi, maNV)
values
    ('CT001', 123, N'2023-01-01', N'Nhiệm vụ cũ 001', N'Nhiệm vụ mới 001', N'NV001'),
    ('CT002', 124, N'2023-02-01', N'Nhiệm vụ cũ 002', N'Nhiệm vụ mới 002', N'NV002'),
    ('CT003', 125, N'2023-03-01', N'Nhiệm vụ cũ 003', N'Nhiệm vụ mới 003', N'NV003'),
    ('CT004', 126, N'2023-04-01', N'Nhiệm vụ cũ 004', N'Nhiệm vụ mới 004', N'NV004'),
    ('CT005', 127, N'2023-05-01', N'Nhiệm vụ cũ 005', N'Nhiệm vụ mới 005', N'NV005');
   
