/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

public class NhanVien {

    private String maNV;
    private String hoTen, avatar;
    private Date ngaySinh;
    private String queQuan;
    private Boolean gioiTinh;
    private String danToc;
    private String soDienThoai, maPB, maCV, maTDHV;
    private Double bacLuong;

    // Constructors, getters, and setters
    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, Date ngaySinh, String queQuan, Boolean gioiTinh, String danToc, String soDienThoai, String maPB, String maCV, String maTDHV, Double bacLuong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.gioiTinh = gioiTinh;
        this.danToc = danToc;
        this.soDienThoai = soDienThoai;
        this.maPB = maPB;
        this.maCV = maCV;
        this.maTDHV = maTDHV;
        this.bacLuong = bacLuong;
    }

    public NhanVien(String maNV, String hoTen, String avatar, Date ngaySinh, String queQuan, Boolean gioiTinh, String danToc, String soDienThoai, String maPB, String maCV, String maTDHV, Double bacLuong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.avatar = avatar;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.gioiTinh = gioiTinh;
        this.danToc = danToc;
        this.soDienThoai = soDienThoai;
        this.maPB = maPB;
        this.maCV = maCV;
        this.maTDHV = maTDHV;
        this.bacLuong = bacLuong;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getMaTDHV() {
        return maTDHV;
    }

    public void setMaTDHV(String maTDHV) {
        this.maTDHV = maTDHV;
    }

    public Double getBacLuong() {
        return bacLuong;
    }

    public void setBacLuong(Double bacLuong) {
        this.bacLuong = bacLuong;
    }
}
