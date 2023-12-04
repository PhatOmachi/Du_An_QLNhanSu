/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class PhongBan {
    private String maPB;
    private String tenPB;
    private String diaChi;
    private String soDienThoaiPB;

    // Constructors, getters, and setters

    public PhongBan() {
    }

    public PhongBan(String maPB, String tenPB, String diaChi, String soDienThoaiPB) {
        this.maPB = maPB;
        this.tenPB = tenPB;
        this.diaChi = diaChi;
        this.soDienThoaiPB = soDienThoaiPB;
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoaiPB() {
        return soDienThoaiPB;
    }

    public void setSoDienThoaiPB(String soDienThoaiPB) {
        this.soDienThoaiPB = soDienThoaiPB;
    }
}

