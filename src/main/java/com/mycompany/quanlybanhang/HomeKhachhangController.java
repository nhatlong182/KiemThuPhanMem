/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlybanhang;

import com.mycompany.pojo.giohang;
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
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author NhatLong
 */
public class HomeKhachhangController implements Initializable {
    
    @FXML
    private Button btnLogout;
    @FXML
    private HBox sanphamLayout;
    @FXML
    private ScrollPane test;
    @FXML
    private GridPane sanphamContainer;
    @FXML
    private Button btn_goToCart;
    private List<sanpham> DSSP;
    static ObservableList<giohang> giohang  = null;
    Connection conn;
    
    @FXML
    void goToCart(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("giohang.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Giỏ hàng");
        stage.setScene(new Scene(root));
        stage.show();
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (giohang != null)
        {}
        else
        {
            giohang = FXCollections.observableArrayList();
        }
        
        init();
        
    }   
    
    private void init()
    {
        int cot = 0, dong = 1;
        try {
            sanphamModel dssp = new sanphamModel(MySQLConnect.getConn());
            List<sanpham> ls = new ArrayList<>(dssp.getSP());
            DSSP = ls;
            
            for (sanpham sp : DSSP)
            {                             
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
    
     @FXML
    void Logout(ActionEvent event) throws IOException {

        giohang.clear();
        
        //btnLogout.getScene().getWindow().setOnCloseRequest(e -> Platform.exit());
        btnLogout.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage mainStage = new Stage();
        mainStage.setTitle("Quản lý bán hàng");
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
  
}
