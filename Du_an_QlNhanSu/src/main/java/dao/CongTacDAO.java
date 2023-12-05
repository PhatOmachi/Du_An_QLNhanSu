/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.CongTac;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.Jdbc;

public class CongTacDAO {

    public void insert(CongTac ct) {
        String insertQuery = "INSERT INTO CongTac VALUES (?,?,?,?,?,?)";
        Jdbc.executeUpdate(insertQuery, ct.getMaCT(), ct.getSoQuyetDinh(), ct.getNgayCoHieuLuc(),
                ct.getNhiemVuCu(), ct.getNhiemVuMoi(), ct.getMaNV()
        );
    }

    public void delete(CongTac ct) {
        String deleteQuery = "DELETE FROM CongTac WHERE maCT = ?";
        Jdbc.executeUpdate(deleteQuery, ct.getMaCT());
    }

    public void update(CongTac ct) {
        String updateQuery = "UPDATE CongTac SET soQuyetDinh = ?, ngayCoHieuLuc = ?, nhiemVuCu = ?"
                + "nhiemVuMoi = ?, manv = ?"
                + " WHERE maCT = ?";
        Jdbc.executeUpdate(updateQuery,
                ct.getSoQuyetDinh(), ct.getNgayCoHieuLuc(),
                ct.getNhiemVuCu(), ct.getNhiemVuMoi(), ct.getMaNV(), ct.getMaCT()
        );
    }

    public ArrayList<CongTac> select() {
        String selectQuery = "SELECT * FROM CongTac";
        return select(selectQuery);
    }

    public ArrayList<CongTac> selectSearch(String key) {
        String select = "select * from congtac where "
                + "maCT like ? or "
                + "soQuyetDinh like ? or "
                + "ngayCoHieuLuc like ? or "
                + "nhiemVuCu like ? or "
                + "nhiemVuMoi like ? or "
                + "manv like ?";
        return select(select, "%" + key + "%", "%" + key + "%", "%" + key + "%", "%" + key + "%", "%" + key + "%", "%" + key + "%");
    }

    public CongTac selectByMaCT(String maCT) {
        String selectQuery = "SELECT * FROM CongTac WHERE maCT = ?";
        ArrayList<CongTac> congTacList = select(selectQuery, maCT);
        return !congTacList.isEmpty() ? congTacList.get(0) : null;
    }

    private ArrayList<CongTac> select(String sql, Object... args) {
        ArrayList<CongTac> congTacList = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    CongTac ct = readFromRS(rs);
                    congTacList.add(ct);
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
        return congTacList;
    }

    private CongTac readFromRS(ResultSet rs) throws SQLException {
        CongTac ct = new CongTac(
                rs.getString("maCT"),
                rs.getInt("soQuyetDinh"),
                rs.getDate("ngayCoHieuLuc"),
                rs.getString("nhiemVuCu"),
                rs.getString("nhiemVuMoi"),
                rs.getString("maNV")
        );
        return ct;
    }
}
