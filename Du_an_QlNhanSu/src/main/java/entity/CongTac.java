/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class CongTac {

    private String maCT;
    private int soQuyetDinh;
    private Date ngayCoHieuLuc;
    private String nhiemVuCu, nhiemVuMoi, maNV;

    public CongTac() {
    }

    public CongTac(String maCT, int soQuyetDinh, Date ngayCoHieuLuc, String nhiemVuCu, String nhiemVuMoi, String maNV) {
        this.maCT = maCT;
        this.soQuyetDinh = soQuyetDinh;
        this.ngayCoHieuLuc = ngayCoHieuLuc;
        this.nhiemVuCu = nhiemVuCu;
        this.nhiemVuMoi = nhiemVuMoi;
        this.maNV = maNV;
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }

    public int getSoQuyetDinh() {
        return soQuyetDinh;
    }

    public void setSoQuyetDinh(int soQuyetDinh) {
        this.soQuyetDinh = soQuyetDinh;
    }

    public Date getNgayCoHieuLuc() {
        return ngayCoHieuLuc;
    }

    public void setNgayCoHieuLuc(Date ngayCoHieuLuc) {
        this.ngayCoHieuLuc = ngayCoHieuLuc;
    }

    public String getNhiemVuCu() {
        return nhiemVuCu;
    }

    public void setNhiemVuCu(String nhiemVuCu) {
        this.nhiemVuCu = nhiemVuCu;
    }

    public String getNhiemVuMoi() {
        return nhiemVuMoi;
    }

    public void setNhiemVuMoi(String nhiemVuMoi) {
        this.nhiemVuMoi = nhiemVuMoi;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

}
