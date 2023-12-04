use QuanLyNS
go
-- example records for demo
-- Insert into TaiKhoan table
INSERT INTO TaiKhoan (tenDangNhap, matKhau) VALUES
  ('nguyenvananh', 'password123'),
  ('lethithao', 'securepass'),
  ('phamquangminh', 'strongpassword'),
  ('tranthithuy', 'pass123'),
  ('vuhoanglong', 'secret@123');

-- Insert into PhongBan table
INSERT INTO PhongBan (maPB, tenPB, diaChi, soDienThoaiPB) VALUES
  ('PB001', 'Phòng Nhân Sự', '123 Đường ABC, Thành phố HCM', '0123 456 789'),
  ('PB002', 'Phòng Kế Toán', '456 Đường XYZ, Thành phố Hà Nội', '0987 654 321'),
  ('PB003', 'Phòng Kinh Doanh', '789 Đường MNO, Thành phố Đà Nẵng', '0345 678 912'),
  ('PB004', 'Phòng IT', '101 Đường PQR, Thành phố Cần Thơ', '0765 432 109'),
  ('PB005', 'Phòng Quản lý', '202 Đường DEF, Thành phố Hải Phòng', '0234 567 890');

-- Insert into Luong table
INSERT INTO Luong (bacLuong, luongCoBan, heSoLuong, heSoPhuCap) VALUES
  (1.0, 10000000, 1.2, 0.1),
  (2.0, 12000000, 1.5, 0.15),
  (3.0, 15000000, 1.8, 0.2),
  (4.0, 18000000, 2.0, 0.25),
  (5.0, 20000000, 2.2, 0.3);

-- Insert into ChucVu table
INSERT INTO ChucVu (maCV, tenCV) VALUES
  ('CV001', 'Nhân Viên'),
  ('CV002', 'Quản lý'),
  ('CV003', 'Trưởng Phòng'),
  ('CV004', 'Giám Đốc'),
  ('CV005', 'Chuyên Viên');

-- Insert into TrinhDoHocVan table
INSERT INTO TrinhDoHocVan (maTDHV, tenTrinhDo, chuyenNganh) VALUES
  ('TDHV001', N'Đại học', N'Kế Toán'),
  ('TDHV002', N'Thạc sĩ', N'Quản trị nhân sự'),
  ('TDHV003', N'Tiến sĩ', N'Công nghệ thông tin'),
  ('TDHV004', N'Cao đẳng', N'Marketing'),
  ('TDHV005', N'Khác', NULL);

-- Insert into NhanVien table
INSERT INTO NhanVien (maNV, hoTen, ngaySinh, queQuan, gioiTinh, danToc, soDienThoai, maPB, maCV, maTDHV, bacLuong) VALUES
  ('NV001', 'Nguyễn Văn Anh', '1990-05-15', 'Hà Nội', 1, 'Kinh', '0901234567', 'PB001', 'CV003', 'TDHV002', 3.0),
  ('NV002', 'Lê Thị Thảo', '1985-12-10', 'Đà Nẵng', 0, 'Kinh', '0987654321', 'PB002', 'CV004', 'TDHV003', 4.0),
  ('NV003', 'Phạm Quang Minh', '1993-08-25', 'Hồ Chí Minh', 1, 'Kinh', '0123456789', 'PB003', 'CV001', 'TDHV001', 1.0),
  ('NV004', 'Trần Thị Thúy', '1988-04-20', 'Cần Thơ', 0, 'Kinh', '0345678912', 'PB004', 'CV002', 'TDHV004', 2.0),
  ('NV005', 'Vũ Hoàng Long', '1995-11-30', 'Hải Phòng', 1, 'Kinh', '0765432109', 'PB005', 'CV005', 'TDHV005', 5.0);

-- Insert into ThoiGianCongTac table
INSERT INTO ThoiGianCongTac (maNV, maCV, ngayNhapChuc) VALUES
  ('NV001', 'CV003', '2015-06-01'),
  ('NV002', 'CV004', '2010-03-15'),
  ('NV003', 'CV001', '2018-09-20'),
  ('NV004', 'CV002', '2013-12-05'),
  ('NV005', 'CV005', '2017-02-10');
