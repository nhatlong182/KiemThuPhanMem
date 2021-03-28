/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.pojo.sanpham;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NhatLong
 */
public class sanphamModel {
    private Connection conn;
    
    public sanphamModel(Connection conn) {
        this.conn = conn;
    }
    public List<sanpham> getSP() throws SQLException {
        Statement stm = this.conn.createStatement();
        ResultSet r = stm.executeQuery("SELECT * FROM sanpham");
        
        List<sanpham> ls = new ArrayList<>();
        while(r.next()) {
            sanpham s = new sanpham();
            s.setTenSP(r.getString("TenSP"));
            s.setSoLuongTon(r.getInt("SoLuongTon"));
            s.setDonGia(r.getBigDecimal("DonGia"));
            s.setDonviTinh(r.getString("DonviTinh"));
            s.setMoTa(r.getString("MoTa"));
            s.setHinhAnh(r.getString("HinhAnh"));
            s.setMaLoaiSP(r.getInt("MaLoaiSP"));
            s.setMaNSX(r.getInt("MaNSX"));
         
            ls.add(s);
        }
        return ls;
    }
}
