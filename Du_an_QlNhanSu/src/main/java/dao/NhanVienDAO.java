/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import entity.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import library.Jdbc;

public class NhanVienDAO {

    public void insert(NhanVien nhanVien) {
        String insertQuery = "INSERT INTO NhanVien (maNV, hoTen, ngaySinh, queQuan, gioiTinh, danToc, soDienThoai, maPB, maCV, maTDHV, bacLuong) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Jdbc.executeUpdate(insertQuery, nhanVien.getMaNV(), nhanVien.getHoTen(), nhanVien.getNgaySinh(), nhanVien.getQueQuan(),
                nhanVien.getGioiTinh(), nhanVien.getDanToc(), nhanVien.getSoDienThoai(), nhanVien.getMaPB(), nhanVien.getMaCV(),
                nhanVien.getMaTDHV(), nhanVien.getBacLuong());
    }

    public void delete(NhanVien nhanVien) {
        String deleteQuery = "DELETE FROM NhanVien WHERE maNV = ?";
        Jdbc.executeUpdate(deleteQuery, nhanVien.getMaNV());
    }

    public void update(NhanVien nhanVien) {
        String updateQuery = "UPDATE NhanVien SET hoTen = ?, ngaySinh = ?, queQuan = ?, gioiTinh = ?, danToc = ?, soDienThoai = ?, maPB = ?, maCV = ?, maTDHV = ?, bacLuong = ? WHERE maNV = ?";
        Jdbc.executeUpdate(updateQuery, nhanVien.getHoTen(), nhanVien.getNgaySinh(), nhanVien.getQueQuan(),
                nhanVien.getGioiTinh(), nhanVien.getDanToc(), nhanVien.getSoDienThoai(), nhanVien.getMaPB(), nhanVien.getMaCV(),
                nhanVien.getMaTDHV(), nhanVien.getBacLuong(), nhanVien.getMaNV());
    }

    public ArrayList<NhanVien> select() {
        String selectQuery = "SELECT * FROM NhanVien";
        return select(selectQuery);
    }

    public NhanVien selectByMaNV(String maNV) {
        String selectQuery = "SELECT * FROM NhanVien WHERE maNV = ?";
        ArrayList<NhanVien> nhanVienList = select(selectQuery, maNV);
        return !nhanVienList.isEmpty() ? nhanVienList.get(0) : null;
    }

    private ArrayList<NhanVien> select(String sql, Object... args) {
        ArrayList<NhanVien> nhanVienList = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien nhanVien = readFromRS(rs);
                    nhanVienList.add(nhanVien);
                }
            } finally {
                if (rs != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
        return nhanVienList;
    }

    private NhanVien readFromRS(ResultSet resultSet) throws SQLException {
        NhanVien nhanVien = new NhanVien(
                resultSet.getString("maNV"),
                resultSet.getString("hoTen"),
                resultSet.getDate("ngaySinh"),
                resultSet.getString("queQuan"),
                resultSet.getBoolean("gioiTinh"),
                resultSet.getString("danToc"),
                resultSet.getString("soDienThoai"),
                resultSet.getString("maPB"),
                resultSet.getString("maCV"),
                resultSet.getString("maTDHV"),
                resultSet.getDouble("bacLuong")
        );
        return nhanVien;
    }
}

