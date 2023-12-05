/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChucVu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.Jdbc;

public class ChucVuDAO {

    public void insert(ChucVu chucVu) {
        String insertQuery = "INSERT INTO ChucVu (maCV, tenCV) VALUES (?, ?)";
        Jdbc.executeUpdate(insertQuery, chucVu.getMaCV(), chucVu.getTenCV());
    }

    public void delete(ChucVu chucVu) {
        String deleteQuery = "DELETE FROM ChucVu WHERE maCV = ?";
        Jdbc.executeUpdate(deleteQuery, chucVu.getMaCV());
    }

    public void update(ChucVu chucVu) {
        String updateQuery = "UPDATE ChucVu SET tenCV = ? WHERE maCV = ?";
        Jdbc.executeUpdate(updateQuery, chucVu.getTenCV(), chucVu.getMaCV());
    }

    public ArrayList<ChucVu> select() {
        String selectQuery = "SELECT * FROM ChucVu";
        return select(selectQuery);
    }

    public ArrayList<ChucVu> selectSearch(String key) {
        String select = "select * from phongban where maCV like ? or tencv like ?";
        return select(select, "%" + key + "%", "%" + key + "%");
    }

    public ChucVu selectByMaCV(String maCV) {
        String selectQuery = "SELECT * FROM ChucVu WHERE maCV = ?";
        ArrayList<ChucVu> chucVuList = select(selectQuery, maCV);
        return !chucVuList.isEmpty() ? chucVuList.get(0) : null;
    }

    private ArrayList<ChucVu> select(String sql, Object... args) {
        ArrayList<ChucVu> chucVuList = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    ChucVu chucVu = readFromRS(rs);
                    chucVuList.add(chucVu);
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
        return chucVuList;
    }

    private ChucVu readFromRS(ResultSet resultSet) throws SQLException {
        ChucVu chucVu = new ChucVu(
                resultSet.getString("maCV"),
                resultSet.getString("tenCV")
        );
        return chucVu;
    }
}
