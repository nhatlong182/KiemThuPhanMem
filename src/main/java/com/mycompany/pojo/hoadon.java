/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.util.Date;

/**
 *
 * @author NhatLong
 */
public class hoadon {
    private int MaHD;
    private Date NgayDatHang;
    private int MaKH;
    private int MaNV;

    /**
     * @return the MaHD
     */
    public int getMaHD() {
        return MaHD;
    }

    /**
     * @return the NgayDatHang
     */
    public Date getNgayDatHang() {
        return NgayDatHang;
    }

    /**
     * @param NgayDatHang the NgayDatHang to set
     */
    public void setNgayDatHang(Date NgayDatHang) {
        this.NgayDatHang = NgayDatHang;
    }


    /**
     * @return the MaKH
     */
    public int getMaKH() {
        return MaKH;
    }

    /**
     * @param MaKH the MaKH to set
     */
    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    /**
     * @return the MaNV
     */
    public int getMaNV() {
        return MaNV;
    }

    /**
     * @param MaNV the MaNV to set
     */
    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    /**
     * @param MaHD the MaHD to set
     */
    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }
}
