/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class Luong {
    private Double bacLuong;
    private Double luongCoBan;
    private Double heSoLuong;
    private Double heSoPhuCap;

    // Constructors, getters, and setters

    public Luong() {
    }

    public Luong(Double bacLuong, Double luongCoBan, Double heSoLuong, Double heSoPhuCap) {
        this.bacLuong = bacLuong;
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
        this.heSoPhuCap = heSoPhuCap;
    }

    public Double getBacLuong() {
        return bacLuong;
    }

    public void setBacLuong(Double bacLuong) {
        this.bacLuong = bacLuong;
    }

    public Double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(Double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public Double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(Double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public Double getHeSoPhuCap() {
        return heSoPhuCap;
    }

    public void setHeSoPhuCap(Double heSoPhuCap) {
        this.heSoPhuCap = heSoPhuCap;
    }
}

