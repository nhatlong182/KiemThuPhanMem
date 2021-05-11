/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlybanhang;

import com.mycompany.pojo.giohang;
import com.mycompany.pojo.sanpham;
import com.mycompany.quanlybanhang.HomeKhachhangController;
import static com.mycompany.quanlybanhang.HomeKhachhangController.giohang;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author NhatLong
 */
public class GiohangController implements Initializable {

    @FXML
    private TableView<giohang> giohang;

    @FXML
    private TableColumn<giohang, Double> DonGia;

    @FXML
    private TableColumn<giohang, String> TenSP;

    @FXML
    private TableColumn<giohang, Integer> SL;

    @FXML
    private TableColumn<giohang, Double> ThanhTien;
    
    @FXML
    private Label TongTien;
    
    @FXML
    private Button btnThanhToan;
    @FXML
    private Button btnTroLai;
    
    private double tongtien;

    
    private static ObservableList<giohang> list = HomeKhachhangController.giohang;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        TenSP.setCellValueFactory(new PropertyValueFactory<giohang, String>("TenSP"));
        DonGia.setCellValueFactory(new PropertyValueFactory<giohang, Double>("DonGia"));
        SL.setCellValueFactory(new PropertyValueFactory<giohang, Integer>("SL"));
        ThanhTien.setCellValueFactory(new PropertyValueFactory<giohang, Double>("ThanhTien"));
        giohang.setItems(list);
        
        for (giohang item : list)
        {
            tongtien += item.getThanhTien();
        }
        
        TongTien.setText(String.valueOf(tongtien));
        
    }    
    
    public void addToCart(int idSP, String TenSP,String DonGia, String SL)
    {
        int SoLuong = Integer.parseInt(SL);
        boolean exists = false;
        if (list.size() > 0)
        {
            
            for (giohang item : list)
            {
                if(item.getIdSP() == idSP)
                {
                    item.setSL(SoLuong + item.getSL());
                    item.setThanhTien((SoLuong + item.getSL() * item.getDonGia()));
                    
                    exists = true ;
                }
            }
            if (exists == false)
            {
                giohang s = new giohang(idSP, TenSP, Double.parseDouble(DonGia), Integer.parseInt(SL));
                this.list.add(s);
            }
        }
        else
        {
            giohang s = new giohang(idSP, TenSP, Double.parseDouble(DonGia), Integer.parseInt(SL));
            this.list.add(s);
        }
    }
    
    @FXML
    void goBack(ActionEvent event) {
        btnTroLai.getScene().getWindow().hide();
    }
    
    @FXML
    void delete(ActionEvent event) {
        giohang selected = giohang.getSelectionModel().getSelectedItem();
        
        tongtien = tongtien - selected.getThanhTien();
        TongTien.setText(String.valueOf(tongtien));
        
        list.remove(selected);

        
    }

  
}
