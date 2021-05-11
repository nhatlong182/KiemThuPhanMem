/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlybanhang;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

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
    private AnchorPane ap;
    private int idSP;
  
    @FXML
    void addToCart(ActionEvent event) throws IOException {
        if (Integer.parseInt(SL.getText()) == 0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Xin lỗi:");
            alert.setContentText("Vui lòng nhập số lượng ít nhất là 1");
            alert.showAndWait();
        }
        else if (Integer.parseInt(SLton.getText()) < Integer.parseInt(SL.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Xin lỗi:");
            alert.setContentText("Hàng trong kho không đủ số lượng để cung cấp");
            alert.showAndWait();
        }
        else
        {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("giohang.fxml"));
            Parent root = fxmlloader.load();

            GiohangController giohang = fxmlloader.getController();
            giohang.addToCart(idSP, TenSP.getText(), donGia.getText(), SL.getText());

            ap.getScene().getWindow().hide();
        }
    }

    @FXML
    void goBack(ActionEvent event) {
        goBackBtn.getScene().getWindow().hide();

    }
    
    public void setInf(int idSP, String TenSP, String donGia, String SLton, String img)
    {
        this.idSP = idSP;
        this.TenSP.setText(TenSP);
        this.donGia.setText(donGia);
        this.SLton.setText(SLton);
        this.img.setImage(new Image(img));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SL.setText("1");
        
        SL.setOnKeyPressed(new EventHandler<KeyEvent>() {
            
            @Override
            public void handle(KeyEvent t) {
               if(!t.getCode().isDigitKey()){
                    SL.setEditable(false);
                    SL.setText("");
               
               }
               
               else{
                   System.out.println(t.getCode());
                   SL.setEditable(true);
                   SL.setFocusTraversable(false);
               }
            }
        });
        
    }    
    
}
