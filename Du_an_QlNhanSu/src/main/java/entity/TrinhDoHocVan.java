/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entity;

public class TrinhDoHocVan {
    private String maTDHV;
    private String tenTrinhDo;
    private String chuyenNganh;

    // Constructors, getters, and setters

    public TrinhDoHocVan() {
    }

    public TrinhDoHocVan(String maTDHV, String tenTrinhDo, String chuyenNganh) {
        this.maTDHV = maTDHV;
        this.tenTrinhDo = tenTrinhDo;
        this.chuyenNganh = chuyenNganh;
    }

    public String getMaTDHV() {
        return maTDHV;
    }

    public void setMaTDHV(String maTDHV) {
        this.maTDHV = maTDHV;
    }

    public String getTenTrinhDo() {
        return tenTrinhDo;
    }

    public void setTenTrinhDo(String tenTrinhDo) {
        this.tenTrinhDo = tenTrinhDo;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }
}
