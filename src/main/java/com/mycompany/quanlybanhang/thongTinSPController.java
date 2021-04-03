/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlybanhang;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author NhatLong
 */
public class thongTinSPController implements Initializable {

     @FXML
    private ImageView img;

    @FXML
    private Label TenSP;

    @FXML
    private TextField SL;

    @FXML
    private Label donGia;

    @FXML
    private Label SLton;
    
    @FXML
    private Button goBackBtn;

  
    @FXML
    void addToCart(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) {
        goBackBtn.getScene().getWindow().hide();
    }
    
    public void setInf(String TenSP, String donGia, String SLton, String img)
    {
        this.TenSP.setText(TenSP);
        this.donGia.setText(donGia);
        this.SLton.setText("Còn trong kho: " + SLton);
        this.img.setImage(new Image(img));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SL.setText("1");
    }    
    
}
