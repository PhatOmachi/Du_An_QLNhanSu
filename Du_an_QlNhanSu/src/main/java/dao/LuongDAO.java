/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;
import entity.Luong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.Jdbc;

public class LuongDAO {

    public void insert(Luong luong) {
        String insertQuery = "INSERT INTO Luong (bacLuong, luongCoBan, heSoLuong, heSoPhuCap) VALUES (?, ?, ?, ?)";
        Jdbc.executeUpdate(insertQuery, luong.getBacLuong(), luong.getLuongCoBan(), luong.getHeSoLuong(), luong.getHeSoPhuCap());
    }

    public void delete(Luong luong) {
        String deleteQuery = "DELETE FROM Luong WHERE bacLuong = ?";
        Jdbc.executeUpdate(deleteQuery, luong.getBacLuong());
    }

    public void update(Luong luong) {
        String updateQuery = "UPDATE Luong SET luongCoBan = ?, heSoLuong = ?, heSoPhuCap = ? WHERE bacLuong = ?";
        Jdbc.executeUpdate(updateQuery, luong.getLuongCoBan(), luong.getHeSoLuong(), luong.getHeSoPhuCap(), luong.getBacLuong());
    }

    public ArrayList<Luong> select() {
        String selectQuery = "SELECT * FROM Luong";
        return select(selectQuery);
    }

    public Luong selectByBacLuong(Double bacLuong) {
        String selectQuery = "SELECT * FROM Luong WHERE bacLuong = ?";
        ArrayList<Luong> luongList = select(selectQuery, bacLuong);
        return !luongList.isEmpty() ? luongList.get(0) : null;
    }

    private ArrayList<Luong> select(String sql, Object... args) {
        ArrayList<Luong> luongList = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    Luong luong = readFromRS(rs);
                    luongList.add(luong);
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
        return luongList;
    }

    private Luong readFromRS(ResultSet resultSet) throws SQLException {
        Luong luong = new Luong(
                resultSet.getDouble("bacLuong"),
                resultSet.getDouble("luongCoBan"),
                resultSet.getDouble("heSoLuong"),
                resultSet.getDouble("heSoPhuCap")
        );
        return luong;
    }
}

