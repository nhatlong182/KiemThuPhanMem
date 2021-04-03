/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.pojo.sanpham;
import com.mycompany.quanlybanhang.MySQLConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    
//    public boolean AddNew(sanpham sp) throws SQLException {
//        Statement stm = this.conn.createStatement();
//        
//        String sql = "insert into sanpham (TenSP,SoLuongTon,DonGia,DonviTinh,MoTa,HinhAnh,MaLoaiSP,MaNSX) values("
//                    + "'" + sp.getTenSP()
//                    + "'," + sp.getSoLuongTon()
//                    + "," + sp.getDonGia()
//                    + "," + sp.getDonviTinh()
//                    + ",'" + sp.getMoTa()
//                    + "','" + sp.getHinhAnh()
//                    + "'," + sp.getMaLoaiSP()
//                    + "," + sp.getMaNSX() + ")";
//        try {
//            stm.executeUpdate(sql);
//            
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
    
    public ObservableList<sanpham> getObserSP() throws SQLException {
        Connection conn = MySQLConnect.getConn();
        Statement stm = conn.createStatement();
        ResultSet r = stm.executeQuery("SELECT * FROM sanpham");
        
        ObservableList<sanpham> ls = FXCollections.observableArrayList();
        while(r.next()) {
            sanpham s = new sanpham();
            s.setMaSP(r.getInt("MaSP"));
            s.setTenSP(r.getString("TenSP"));
            s.setSoLuongTon(r.getInt("SoLuongTon"));
            s.setDonGia(r.getBigDecimal("DonGia"));
            s.setDonviTinh(r.getString("DonviTinh"));
            s.setMoTa(r.getString("MoTa"));
            s.setMaLoaiSP(r.getInt("MaLoaiSP"));
            s.setMaNSX(r.getInt("MaNSX"));

            ls.add(s);
        }
        return ls;
    }
}
