/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import entity.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.Jdbc;

public class TaiKhoanDAO {

    public void insert(TaiKhoan taiKhoan) {
        String insertQuery = "INSERT INTO TaiKhoan (tenDangNhap, matKhau) VALUES (?, ?)";
        Jdbc.executeUpdate(insertQuery, taiKhoan.getTenDangNhap(), taiKhoan.getMatKhau());
    }

    public void delete(TaiKhoan taiKhoan) {
        String deleteQuery = "DELETE FROM TaiKhoan WHERE tenDangNhap = ?";
        Jdbc.executeUpdate(deleteQuery, taiKhoan.getTenDangNhap());
    }

    public void update(TaiKhoan taiKhoan) {
        String updateQuery = "UPDATE TaiKhoan SET matKhau = ? WHERE tenDangNhap = ?";
        Jdbc.executeUpdate(updateQuery, taiKhoan.getMatKhau(), taiKhoan.getTenDangNhap());
    }
    
        public void updateCuaDoiMatKhau(String matKhau , String tenDangNhap) {
        String updateQuery = "UPDATE TaiKhoan SET matKhau = ? WHERE tenDangNhap = ?";
        Jdbc.executeUpdate(updateQuery, matKhau, tenDangNhap);
    }

    public ArrayList<TaiKhoan> select() {
        String selectQuery = "SELECT * FROM TaiKhoan";
        return select(selectQuery);
    }

    public TaiKhoan selectByTenDangNhap(String tenDangNhap) {
        String selectQuery = "SELECT * FROM TaiKhoan WHERE tenDangNhap = ?";
        ArrayList<TaiKhoan> taiKhoanList = select(selectQuery, tenDangNhap);
        return !taiKhoanList.isEmpty() ? taiKhoanList.get(0) : null;
    }

    private ArrayList<TaiKhoan> select(String sql, Object... args) {
        ArrayList<TaiKhoan> taiKhoanList = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    TaiKhoan taiKhoan = readFromRS(rs);
                    taiKhoanList.add(taiKhoan);
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
        return taiKhoanList;
    }

    private TaiKhoan readFromRS(ResultSet resultSet) throws SQLException {
        TaiKhoan taiKhoan = new TaiKhoan(
                resultSet.getString("tenDangNhap"),
                resultSet.getString("matKhau")
        );
        return taiKhoan;
    }
}

