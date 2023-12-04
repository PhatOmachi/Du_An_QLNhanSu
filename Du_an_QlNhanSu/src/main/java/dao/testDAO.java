/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.*;
import java.sql.Date;
import java.util.ArrayList;

public class testDAO {

    public static void main(String[] args) {
        
        
// =================================================================================================================================================================================================        

//// Create an instance of ThoiGianCongTacDAO
//        ThoiGianCongTacDAO thoiGianCongTacDAO = new ThoiGianCongTacDAO();
//
//        // Test Insert
//        ThoiGianCongTac newThoiGianCongTac = new ThoiGianCongTac("NV001", "CV001", Date.valueOf("2023-01-01"));
//        thoiGianCongTacDAO.insert(newThoiGianCongTac);
//        System.out.println("Insertion successful.");
//
//        // Test Select
//        System.out.println("All ThoiGianCongTac records:");
//        ArrayList<ThoiGianCongTac> thoiGianCongTacList = thoiGianCongTacDAO.select();
//        for (ThoiGianCongTac thoiGianCongTac : thoiGianCongTacList) {
//            System.out.println(thoiGianCongTac);
//        }
//
//        // Test Update
//        newThoiGianCongTac.setNgayNhapChuc(Date.valueOf("2023-02-01"));
//        thoiGianCongTacDAO.update(newThoiGianCongTac);
//        System.out.println("Update successful.");
//
//        // Test Select by maNV and maCV
//        String maNVToSearch = "NV001";
//        String maCVToSearch = "CV001";
//        ThoiGianCongTac selectedThoiGianCongTac = thoiGianCongTacDAO.selectByMaNVAndMaCV(maNVToSearch, maCVToSearch);
//        if (selectedThoiGianCongTac != null) {
//            System.out.println("Selected ThoiGianCongTac by maNV and maCV: " + selectedThoiGianCongTac);
//        } else {
//            System.out.println("ThoiGianCongTac with maNV " + maNVToSearch + " and maCV " + maCVToSearch + " not found.");
//        }
//
//        // Test Delete
//        thoiGianCongTacDAO.delete(newThoiGianCongTac);
//        System.out.println("Deletion successful.");

// =================================================================================================================================================================================================        
// Create an instance of TrinhDoHocVanDAO
//        TrinhDoHocVanDAO trinhDoHocVanDAO = new TrinhDoHocVanDAO();
//
//        // Test Insert
//        TrinhDoHocVan newTrinhDoHocVan = new TrinhDoHocVan("TDHV007", "Bachelor", "Computer Science");
//        trinhDoHocVanDAO.insert(newTrinhDoHocVan);
//        System.out.println("Insertion successful.");
//
//        // Test Select
//        System.out.println("All TrinhDoHocVan records:");
//        ArrayList<TrinhDoHocVan> trinhDoHocVanList = trinhDoHocVanDAO.select();
//        for (TrinhDoHocVan trinhDoHocVan : trinhDoHocVanList) {
//            System.out.println(trinhDoHocVan);
//        }
//
//        // Test Update
//        newTrinhDoHocVan.setChuyenNganh("Information Technology");
//        trinhDoHocVanDAO.update(newTrinhDoHocVan);
//        System.out.println("Update successful.");
//
//        // Test Select by maTDHV
//        String maTDHVToSearch = "TDHV001";
//        TrinhDoHocVan selectedTrinhDoHocVan = trinhDoHocVanDAO.selectByMaTDHV(maTDHVToSearch);
//        if (selectedTrinhDoHocVan != null) {
//            System.out.println("Selected TrinhDoHocVan by maTDHV: " + selectedTrinhDoHocVan);
//        } else {
//            System.out.println("TrinhDoHocVan with maTDHV " + maTDHVToSearch + " not found.");
//        }
//
//        // Test Delete
//        trinhDoHocVanDAO.delete(newTrinhDoHocVan);
//        System.out.println("Deletion successful.");
// =================================================================================================================================================================================================        
// Create an instance of NhanVienDAO
//        NhanVienDAO nhanVienDAO = new NhanVienDAO();
//
//        // Test Insert
//        NhanVien newNhanVien = new NhanVien("NV007", "John Doe", Date.valueOf("1990-01-01"),
//                "Hanoi", true, "Kinh", "123-456-789", "PB001", "CV001", "TDHV001", 1.0);
//        nhanVienDAO.insert(newNhanVien);
//        System.out.println("Insertion successful.");
//
//        // Test Select
//        System.out.println("All NhanVien records:");
//        ArrayList<NhanVien> nhanVienList = nhanVienDAO.select();
//        for (NhanVien nhanVien : nhanVienList) {
//            System.out.println(nhanVien);
//        }
//
//        // Test Update
//        newNhanVien.setSoDienThoai("987-654-321");
//        nhanVienDAO.update(newNhanVien);
//        System.out.println("Update successful.");
//
//        // Test Select by maNV
//        String maNVToSearch = "NV001";
//        NhanVien selectedNhanVien = nhanVienDAO.selectByMaNV(maNVToSearch);
//        if (selectedNhanVien != null) {
//            System.out.println("Selected NhanVien by maNV: " + selectedNhanVien);
//        } else {
//            System.out.println("NhanVien with maNV " + maNVToSearch + " not found.");
//        }
//
//        // Test Delete
//        nhanVienDAO.delete(newNhanVien);
//        System.out.println("Deletion successful.");
// =================================================================================================================================================================================================        
        // Create an instance of PhongBanDAO
//        PhongBanDAO phongBanDAO = new PhongBanDAO();
//
//        // Test Insert
//        PhongBan newPhongBan = new PhongBan("PB007", "IT Department", "123 Main St", "123-456-789");
//        phongBanDAO.insert(newPhongBan);
//        System.out.println("Insertion successful.");
//
//        // Test Select
//        System.out.println("All PhongBan records:");
//        ArrayList<PhongBan> phongBanList = phongBanDAO.select();
//        for (PhongBan phongBan : phongBanList) {
//            System.out.println(phongBan);
//        }
//
//        // Test Update
//        newPhongBan.setSoDienThoaiPB("987-654-321");
//        phongBanDAO.update(newPhongBan);
//        System.out.println("Update successful.");
//
//        // Test Select by maPB
//        String maPBToSearch = "PB001";
//        PhongBan selectedPhongBan = phongBanDAO.selectByMaPB(maPBToSearch);
//        if (selectedPhongBan != null) {
//            System.out.println("Selected PhongBan by maPB: " + selectedPhongBan);
//        } else {
//            System.out.println("PhongBan with maPB " + maPBToSearch + " not found.");
//        }
//
//        // Test Delete
//        phongBanDAO.delete(newPhongBan);
//        System.out.println("Deletion successful.");
// =================================================================================================================================================================================================
// Create an instance of LuongDAO
//        LuongDAO luongDAO = new LuongDAO();
//
//        // Test Insert
//        Luong newLuong = new Luong(1.1, 5000.0, 1.2, 0.1);
//        luongDAO.insert(newLuong);
//        System.out.println("Insertion successful.");
//
//        // Test Select
//        System.out.println("All Luong records:");
//        ArrayList<Luong> luongList = luongDAO.select();
//        for (Luong luong : luongList) {
//            System.out.println(luong);
//        }
//
//        // Test Update
//        newLuong.setLuongCoBan(6000.0);
//        luongDAO.update(newLuong);
//        System.out.println("Update successful.");
//
//        // Test Select by bacLuong
//        Double bacLuongToSearch = 1.0;
//        Luong selectedLuong = luongDAO.selectByBacLuong(bacLuongToSearch);
//        if (selectedLuong != null) {
//            System.out.println("Selected Luong by bacLuong: " + selectedLuong);
//        } else {
//            System.out.println("Luong with bacLuong " + bacLuongToSearch + " not found.");
//        }
//
//        // Test Delete
//        luongDAO.delete(newLuong);
//        System.out.println("Deletion successful.");
// =================================================================================================================================================================================================
//        // Create an instance of ChucVuDAO -- PASSED
//        ChucVuDAO chucVuDAO = new ChucVuDAO();
//
//        // Test Insert
//        ChucVu newChucVu = new ChucVu("CV007", "Manager");
//        chucVuDAO.insert(newChucVu);
//        System.out.println("Insertion successful.");
//
//        // Test Select
//        System.out.println("All ChucVu records:");
//        ArrayList<ChucVu> chucVuList = chucVuDAO.select();
//        for (ChucVu chucVu : chucVuList) {
//            System.out.println(chucVu);
//        }
//
//        // Test Update
//        newChucVu.setTenCV("Team Lead");
//        chucVuDAO.update(newChucVu);
//        System.out.println("Update successful.");
//
//        // Test Select by maCV
//        String maCVToSearch = "CV001";
//        ChucVu selectedChucVu = chucVuDAO.selectByMaCV(maCVToSearch);
//        if (selectedChucVu != null) {
//            System.out.println("Selected ChucVu by maCV: " + selectedChucVu);
//        } else {
//            System.out.println("ChucVu with maCV " + maCVToSearch + " not found.");
//        }
//
//        // Test Delete
//        chucVuDAO.delete(newChucVu);
//        System.out.println("Deletion successful.");
// =================================================================================================================================================================================================
//        // Create an instance of TaiKhoanDAO
//        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
//
//        // Test Insert
//        TaiKhoan newTaiKhoan = new TaiKhoan("testUser", "testPassword");
//        taiKhoanDAO.insert(newTaiKhoan);
//        System.out.println("Insertion successful.");
//
//        // Test Select
//        System.out.println("All TaiKhoan records:");
//        ArrayList<TaiKhoan> taiKhoanList = taiKhoanDAO.select();
//        for (TaiKhoan taiKhoan : taiKhoanList) {
//            System.out.println(taiKhoan);
//        }
//
//        // Test Update
//        newTaiKhoan.setMatKhau("newPassword");
//        taiKhoanDAO.update(newTaiKhoan);
//        System.out.println("Update successful.");
//
//        // Test Select by tenDangNhap
//        String tenDangNhapToSearch = "testUser";
//        TaiKhoan selectedTaiKhoan = taiKhoanDAO.selectByTenDangNhap(tenDangNhapToSearch);
//        if (selectedTaiKhoan != null) {
//            System.out.println("Selected TaiKhoan by tenDangNhap: " + selectedTaiKhoan);
//        } else {
//            System.out.println("TaiKhoan with tenDangNhap " + tenDangNhapToSearch + " not found.");
//        }
//
//        // Test Delete
//        taiKhoanDAO.delete(newTaiKhoan);
//        System.out.println("Deletion successful.");
    }
}
