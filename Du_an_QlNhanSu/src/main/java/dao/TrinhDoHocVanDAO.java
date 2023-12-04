/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import entity.TrinhDoHocVan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.Jdbc;

public class TrinhDoHocVanDAO {

    public void insert(TrinhDoHocVan trinhDoHocVan) {
        String insertQuery = "INSERT INTO TrinhDoHocVan (maTDHV, tenTrinhDo, chuyenNganh) VALUES (?, ?, ?)";
        Jdbc.executeUpdate(insertQuery, trinhDoHocVan.getMaTDHV(), trinhDoHocVan.getTenTrinhDo(), trinhDoHocVan.getChuyenNganh());
    }

    public void delete(TrinhDoHocVan trinhDoHocVan) {
        String deleteQuery = "DELETE FROM TrinhDoHocVan WHERE maTDHV = ?";
        Jdbc.executeUpdate(deleteQuery, trinhDoHocVan.getMaTDHV());
    }

    public void update(TrinhDoHocVan trinhDoHocVan) {
        String updateQuery = "UPDATE TrinhDoHocVan SET tenTrinhDo = ?, chuyenNganh = ? WHERE maTDHV = ?";
        Jdbc.executeUpdate(updateQuery, trinhDoHocVan.getTenTrinhDo(), trinhDoHocVan.getChuyenNganh(), trinhDoHocVan.getMaTDHV());
    }

    public ArrayList<TrinhDoHocVan> select() {
        String selectQuery = "SELECT * FROM TrinhDoHocVan";
        return select(selectQuery);
    }

    public TrinhDoHocVan selectByMaTDHV(String maTDHV) {
        String selectQuery = "SELECT * FROM TrinhDoHocVan WHERE maTDHV = ?";
        ArrayList<TrinhDoHocVan> trinhDoHocVanList = select(selectQuery, maTDHV);
        return !trinhDoHocVanList.isEmpty() ? trinhDoHocVanList.get(0) : null;
    }

    private ArrayList<TrinhDoHocVan> select(String sql, Object... args) {
        ArrayList<TrinhDoHocVan> trinhDoHocVanList = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    TrinhDoHocVan trinhDoHocVan = readFromRS(rs);
                    trinhDoHocVanList.add(trinhDoHocVan);
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
        return trinhDoHocVanList;
    }

    private TrinhDoHocVan readFromRS(ResultSet resultSet) throws SQLException {
        TrinhDoHocVan trinhDoHocVan = new TrinhDoHocVan(
                resultSet.getString("maTDHV"),
                resultSet.getString("tenTrinhDo"),
                resultSet.getString("chuyenNganh")
        );
        return trinhDoHocVan;
    }
}
