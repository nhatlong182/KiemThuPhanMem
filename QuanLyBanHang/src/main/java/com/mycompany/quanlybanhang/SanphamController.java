/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlybanhang;


import com.mycompany.pojo.sanpham;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
    
    private String [] color = {"BDB2FE", "F3F3F3", "FF5056", "B9E5FF"};
    
    public void setData(sanpham s) {       
//        Image image = new Image(getClass().getResourceAsStream("../../../../resources" + s.getHinhAnh()));
//        img.setImage(image);
        tensp.setText("Tên sản phẩm: " + s.getTenSP());
        dongiasp.setText("Đơn giá: " + s.getDonGia().toString());       
        mota.setText("Mô tả: " + s.getMoTa());
//        anchorPane.setStyle("-fx-background-color: " + Color.web(color[(int)(Math.random()*colors.length)]));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
