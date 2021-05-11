/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

/**
 *
 * @author NhatLong
 */
public class giohang {

    /**
     * @param ThanhTien the ThanhTien to set
     */
    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    private int idSP;
    private String TenSP;
    private int SL = 0;
    private double DonGia = 0;
    private double ThanhTien = 0;
    
    public giohang(int idSP, String TenSP, double DonGia, int SL)
    {
        this.idSP = idSP;
        this.TenSP = TenSP;
        this.SL = SL;
        this.DonGia = DonGia;
        this.ThanhTien = (Double)(SL * DonGia);
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
     * @return the SL
     */
    public int getSL() {
        return SL;
    }

    /**
     * @param SL the SL to set
     */
    public void setSL(int SL) {
        this.SL = SL;
    }

    /**
     * @return the DonGia
     */
    public double getDonGia() {
        return DonGia;
    }

    /**
     * @param DonGia the DonGia to set
     */
    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    /**
     * @return the ThanhTien
     */
    public double getThanhTien() {
        return ThanhTien;
    }

    /**
     * @return the idSP
     */
    public int getIdSP() {
        return idSP;
    }

    /**
     * @param idSP the idSP to set
     */
    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

   
}
