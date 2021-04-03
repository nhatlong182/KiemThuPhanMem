/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlybanhang;

import com.mycompany.pojo.sanpham;
import com.mycompany.service.sanphamModel;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author NhatLong
 */
public class HomeNhanVienController implements Initializable {
    @FXML
    private TableView<sanpham> tableSP;
    
    @FXML
    private TableColumn<sanpham, Integer> MaSP;

    @FXML
    private TableColumn<sanpham, String> TenSP;
    
    @FXML
    private TableColumn<sanpham, BigDecimal> DonGia;

    ObservableList<sanpham> list;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            sanphamModel s = new sanphamModel(MySQLConnect.getConn());
            list = s.getObserSP();    
            MaSP.setCellValueFactory(new PropertyValueFactory<sanpham, Integer>("MaSP"));
            TenSP.setCellValueFactory(new PropertyValueFactory<sanpham, String>("TenSP"));
            DonGia.setCellValueFactory(new PropertyValueFactory<sanpham, BigDecimal>("DonGia"));
            tableSP.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(HomeNhanVienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
   
    
}
