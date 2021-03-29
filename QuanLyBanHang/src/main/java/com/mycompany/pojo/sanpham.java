/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.math.BigDecimal;

/**
 *
 * @author NhatLong
 */
public class sanpham {
    private int MaSP;
    private String TenSP;
    private int SoLuongTon;
    private BigDecimal DonGia;
    private String DonviTinh;
    private String MoTa;
    private String HinhAnh;
    private int MaLoaiSP;
    private int MaNSX;
    

    /**
     * @return the MaSP
     */
    public int getMaSP() {
        return MaSP;
    }

    
    /**
     * @return the TenSP
     */
    public String getTenSP() {
        return TenSP;
    }

    /**
     * @param TenSP the TenSP to set
     */
    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    /**
     * @return the SoLuongTon
     */
    public int getSoLuongTon() {
        return SoLuongTon;
    }

    /**
     * @param SoLuongTon the SoLuongTon to set
     */
    public void setSoLuongTon(int SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }

    /**
     * @return the DonGia
     */
    public BigDecimal getDonGia() {
        return DonGia;
    }

    /**
     * @param DonGia the DonGia to set
     */
    public void setDonGia(BigDecimal DonGia) {
        this.DonGia = DonGia;
    }

    /**
     * @return the DonviTinh
     */
    public String getDonviTinh() {
        return DonviTinh;
    }

    /**
     * @param DonviTinh the DonviTinh to set
     */
    public void setDonviTinh(String DonviTinh) {
        this.DonviTinh = DonviTinh;
    }

    /**
     * @return the MoTa
     */
    public String getMoTa() {
        return MoTa;
    }

    /**
     * @param MoTa the MoTa to set
     */
    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    /**
     * @return the HinhAnh
     */
    public String getHinhAnh() {
        return HinhAnh;
    }

    /**
     * @param HinhAnh the HinhAnh to set
     */
    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    /**
     * @return the MaLoaiSP
     */
    public int getMaLoaiSP() {
        return MaLoaiSP;
    }

    /**
     * @param MaLoaiSP the MaLoaiSP to set
     */
    public void setMaLoaiSP(int MaLoaiSP) {
        this.MaLoaiSP = MaLoaiSP;
    }

    /**
     * @return the MaNSX
     */
    public int getMaNSX() {
        return MaNSX;
    }

    /**
     * @param MaNSX the MaNSX to set
     */
    public void setMaNSX(int MaNSX) {
        this.MaNSX = MaNSX;
    }
    
}
