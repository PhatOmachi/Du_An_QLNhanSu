/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.PhongBan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.Jdbc;

public class PhongBanDAO {

    public void insert(PhongBan phongBan) {
        String insertQuery = "INSERT INTO PhongBan (maPB, tenPB, diaChi, soDienThoaiPB) VALUES (?, ?, ?, ?)";
        Jdbc.executeUpdate(insertQuery, phongBan.getMaPB(), phongBan.getTenPB(), phongBan.getDiaChi(), phongBan.getSoDienThoaiPB());
    }

    public void delete(PhongBan phongBan) {
        String deleteQuery = "DELETE FROM PhongBan WHERE maPB = ?";
        Jdbc.executeUpdate(deleteQuery, phongBan.getMaPB());
    }

    public void update(PhongBan phongBan) {
        String updateQuery = "UPDATE PhongBan SET tenPB = ?, diaChi = ?, soDienThoaiPB = ? WHERE maPB = ?";
        Jdbc.executeUpdate(updateQuery, phongBan.getTenPB(), phongBan.getDiaChi(), phongBan.getSoDienThoaiPB(), phongBan.getMaPB());
    }

    public ArrayList<PhongBan> select() {
        String selectQuery = "SELECT * FROM PhongBan";
        return select(selectQuery);
    }

    public ArrayList<PhongBan> selectSearch(String key) {
        String select = "select * from phongban where mapb like ? or tenpb like ? or diachi like ? or soDienThoaiPB like ?";
        return select(select, "%" + key + "%", "%" + key + "%", "%" + key + "%", "%" + key + "%");
    }

    public PhongBan selectByMaPB(String maPB) {
        String selectQuery = "SELECT * FROM PhongBan WHERE maPB = ?";
        ArrayList<PhongBan> phongBanList = select(selectQuery, maPB);
        return !phongBanList.isEmpty() ? phongBanList.get(0) : null;
    }

    private ArrayList<PhongBan> select(String sql, Object... args) {
        ArrayList<PhongBan> phongBanList = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    PhongBan phongBan = readFromRS(rs);
                    phongBanList.add(phongBan);
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
        return phongBanList;
    }

    private PhongBan readFromRS(ResultSet resultSet) throws SQLException {
        PhongBan phongBan = new PhongBan(
                resultSet.getString("maPB"),
                resultSet.getString("tenPB"),
                resultSet.getString("diaChi"),
                resultSet.getString("soDienThoaiPB")
        );
        return phongBan;
    }
}
