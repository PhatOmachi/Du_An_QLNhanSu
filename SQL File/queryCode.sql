use QuanLyNS
go

select * from ThoiGianCongTac
select * from NhanVien
select * from ChucVu
select * from TaiKhoan
select * from TrinhDoHocVan
select * from PhongBan
select * from Luong

go
create or alter procedure searchNV @val nvarchar(30)
as
begin
	select * from NhanVien nv
	join PhongBan pb on pb.maPB = nv.maPB
	join ChucVu cv on nv.maCV = cv.maCV
	where	hoTen like '%' + @val + '%'
			or soDienThoai like '%' + @val + '%'
			or tenCV like '%' + @val + '%'
			or tenPB like '%' + @val + '%'
end
go