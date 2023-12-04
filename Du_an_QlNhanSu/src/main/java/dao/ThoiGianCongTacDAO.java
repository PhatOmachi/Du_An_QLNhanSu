/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import entity.ThoiGianCongTac;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import library.Jdbc;

public class ThoiGianCongTacDAO {

    public void insert(ThoiGianCongTac thoiGianCongTac) {
        String insertQuery = "INSERT INTO ThoiGianCongTac (maNV, maCV, ngayNhapChuc) VALUES (?, ?, ?)";
        Jdbc.executeUpdate(insertQuery, thoiGianCongTac.getMaNV(), thoiGianCongTac.getMaCV(), thoiGianCongTac.getNgayNhapChuc());
    }

    public void delete(ThoiGianCongTac thoiGianCongTac) {
        String deleteQuery = "DELETE FROM ThoiGianCongTac WHERE maNV = ? AND maCV = ?";
        Jdbc.executeUpdate(deleteQuery, thoiGianCongTac.getMaNV(), thoiGianCongTac.getMaCV());
    }

    public void update(ThoiGianCongTac thoiGianCongTac) {
        String updateQuery = "UPDATE ThoiGianCongTac SET ngayNhapChuc = ? WHERE maNV = ? AND maCV = ?";
        Jdbc.executeUpdate(updateQuery, thoiGianCongTac.getNgayNhapChuc(), thoiGianCongTac.getMaNV(), thoiGianCongTac.getMaCV());
    }

    public ArrayList<ThoiGianCongTac> select() {
        String selectQuery = "SELECT * FROM ThoiGianCongTac";
        return select(selectQuery);
    }

    public ThoiGianCongTac selectByMaNVAndMaCV(String maNV, String maCV) {
        String selectQuery = "SELECT * FROM ThoiGianCongTac WHERE maNV = ? AND maCV = ?";
        ArrayList<ThoiGianCongTac> thoiGianCongTacList = select(selectQuery, maNV, maCV);
        return !thoiGianCongTacList.isEmpty() ? thoiGianCongTacList.get(0) : null;
    }

    private ArrayList<ThoiGianCongTac> select(String sql, Object... args) {
        ArrayList<ThoiGianCongTac> thoiGianCongTacList = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    ThoiGianCongTac thoiGianCongTac = readFromRS(rs);
                    thoiGianCongTacList.add(thoiGianCongTac);
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
        return thoiGianCongTacList;
    }

    private ThoiGianCongTac readFromRS(ResultSet resultSet) throws SQLException {
        ThoiGianCongTac thoiGianCongTac = new ThoiGianCongTac(
                resultSet.getString("maNV"),
                resultSet.getString("maCV"),
                resultSet.getDate("ngayNhapChuc")
        );
        return thoiGianCongTac;
    }
}
