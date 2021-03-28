/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlybanhang;

import com.mycompany.pojo.sanpham;
import com.mycompany.service.sanphamModel;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author NhatLong
 */
public class HomeKhachhangController implements Initializable {
    

    @FXML
    private HBox sanphamLayout;
    @FXML
    private ScrollPane test;
    @FXML
    private GridPane sanphamContainer;
    private List<sanpham> DSSP;
    
    Connection conn;
    
    private List<sanpham> DSSP() throws SQLException {
        conn = MySQLConnect.getConn();
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
        conn.close();
        return ls;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int cot = 0, dong = 1;
        try {
            DSSP = new ArrayList<>(DSSP());
            
            for (sanpham sp : DSSP)
            {
                System.out.println(sp.getTenSP());
                
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("sanpham.fxml"));
                AnchorPane box = fxmlloader.load();
                SanphamController sanphamController = fxmlloader.getController();
                sanphamController.setData(sp);
                
                
                if(cot == 3)
                {
                    cot = 0;
                    dong++;
                }
                
                sanphamContainer.add(box, cot++, dong);
                GridPane.setMargin(box, new Insets(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeKhachhangController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomeKhachhangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
