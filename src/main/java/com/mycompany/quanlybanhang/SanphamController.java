/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlybanhang;


import com.mycompany.pojo.sanpham;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author NhatLong
 */
public class SanphamController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView img;

    @FXML
    private Label dongiasp;

    @FXML
    private Label tensp;
    @FXML
    private Label mota;

    @FXML
    private Button btn;
    private int SLton;
    private Image image;
    
//    private String [] color = {"BDB2FE", "F3F3F3", "FF5056", "B9E5FF"};
    
    public void setData(sanpham s) {    
        File file = new File("src/main/resources/Images/" + s.getHinhAnh());
        image = new Image(file.toURI().toString(),600, 500, false, true);
        img.setImage(image);       
        tensp.setText("Tên sản phẩm: " + s.getTenSP());
        dongiasp.setText("Đơn giá: " + s.getDonGia().toString());       
        mota.setText("Mô tả: " + s.getMoTa());
        SLton = s.getSoLuongTon();
    }
    
    public void sendinf(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("thongTinSP.fxml"));
        Parent root = loader.load();
        thongTinSPController thongTinSPController = loader.getController();
        thongTinSPController.setInf(tensp.getText(), dongiasp.getText(), String.valueOf(SLton), image.getUrl());
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
