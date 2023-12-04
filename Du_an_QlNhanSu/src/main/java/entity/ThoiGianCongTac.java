/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entity;

import java.sql.Date;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ThoiGianCongTac {
    private String maNV, maCV;
    private Date ngayNhapChuc;

    public ThoiGianCongTac(String maNV, String maCV, Date ngayNhapChuc) {
        this.maNV = maNV;
        this.maCV = maCV;
        this.ngayNhapChuc = ngayNhapChuc;
    }

    public ThoiGianCongTac() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public Date getNgayNhapChuc() {
        return ngayNhapChuc;
    }

    public void setNgayNhapChuc(Date ngayNhapChuc) {
        this.ngayNhapChuc = ngayNhapChuc;
    }
    
}
