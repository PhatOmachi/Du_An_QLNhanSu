/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

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
                while(rs.next()){
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
}
