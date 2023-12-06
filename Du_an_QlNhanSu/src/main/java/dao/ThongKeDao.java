/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import library.Jdbc;

/**
 *
 * @author TAN LOC
 */
public class ThongKeDao {

    public ArrayList<Object[]> soLuongNhanVienPhongBan() {
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec soLuongNVPB";
                rs = Jdbc.executeQuery(sql);
                while (rs.next()) {
                    Object[] row = {
                        rs.getString("maPB"),
                        rs.getString("tenPB"),
                        rs.getString("diaChi"),
                        rs.getString("soDienThoaiPB"),
                        rs.getInt("slnv")
                    };
                    list.add(row);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Object[]> thongKeLuongTheoPB() {
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec thongKeLuongTheoPB";
                rs = Jdbc.executeQuery(sql);
                while (rs.next()) {
                    Object[] row = {
                        rs.getString("maPB"),
                        rs.getString("tenPB"),
                        rs.getString("diaChi"),
                        rs.getString("soDienThoaiPB"),
                        rs.getInt("tongLuong")
                    };
                    list.add(row);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Object[]> nhanVienDuocTangLuongTrongNam(int year, boolean more) {
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call nhanVienDuocTangLuongTrongNam (?, ?)}";
                rs = Jdbc.executeQuery(sql, year, more ? 1 : 0);
                while (rs.next()) {
                    Object[] row = {
                        rs.getString("maNV"),
                        rs.getString("hoTen"),
                        rs.getString("gioiTinh"),
                        rs.getDouble("bacLuongHienTai"),
                        rs.getDouble("bacLuongTruoc")
                    };
                    list.add(row);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Object[]> congTacTheoNV() {
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec congTacTheoNV";
                rs = Jdbc.executeQuery(sql);
                while (rs.next()) {
                    Object[] row = {
                        rs.getString("maNV"),
                        rs.getString("hoTen"),
                        rs.getString("soDienThoai"),
                        rs.getString("gioiTinh"),
                        rs.getDouble("bacLuong"),
                        rs.getDouble("luongCoBan"),
                        rs.getString("tenTrinhDo"),
                        rs.getString("chuyenNganh"),
                        rs.getInt("tongCT")
                    };
                    list.add(row);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
