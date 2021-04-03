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
public class CTHD {
    private int MaHD;
    private String MaSP;
    private BigDecimal GiaBan;
    private int SoLuong;
    private float GiamGia;
    private BigDecimal ThanhTien;

    /**
     * @return the MaHD
     */
    public int getMaHD() {
        return MaHD;
    }

    /**
     * @return the MaSP
     */
    public String getMaSP() {
        return MaSP;
    }

    /**
     * @param MaSP the MaSP to set
     */
    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    /**
     * @return the GiaBan
     */
    public BigDecimal getGiaBan() {
        return GiaBan;
    }

    /**
     * @param GiaBan the GiaBan to set
     */
    public void setGiaBan(BigDecimal GiaBan) {
        this.GiaBan = GiaBan;
    }

    /**
     * @return the SoLuong
     */
    public int getSoLuong() {
        return SoLuong;
    }

    /**
     * @param SoLuong the SoLuong to set
     */
    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    /**
     * @return the GiamGia
     */
    public float getGiamGia() {
        return GiamGia;
    }

    /**
     * @param GiamGia the GiamGia to set
     */
    public void setGiamGia(float GiamGia) {
        this.GiamGia = GiamGia;
    }

    /**
     * @return the ThanhTien
     */
    public BigDecimal getThanhTien() {
        return ThanhTien;
    }

    /**
     * @param ThanhTien the ThanhTien to set
     */
    public void setThanhTien(BigDecimal ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
}
