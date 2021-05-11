/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlybanhang;

import Services.Utils;
import com.mycompany.pojo.sanpham;
import com.mycompany.pojo.hoadon;
import com.mycompany.service.sanphamModel;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private TableColumn<sanpham, Integer> SoLuongTon;

    @FXML
    private TableColumn<sanpham, Double> DonGia;

    @FXML
    private TableColumn<sanpham, String> DonViTinh;

    @FXML
    private TableColumn<sanpham, String> MoTa;

    @FXML
    private TableColumn<sanpham, Integer> MaLoaiSP;

    @FXML
    private TableColumn<sanpham, Integer> MaNSX;
    
     @FXML
    private TextField txtMaSP;

    @FXML
    private TextField txtTenSP;

    @FXML
    private TextField txtSoLuongTon;

    @FXML
    private TextField txtDonGia;

    @FXML
    private TextField txtDonViTinh;

    @FXML
    private TextField txtMoTa;

    @FXML
    private TextField txtMaLoaiSP;

    @FXML
    private TextField txtMaNSX;
    
    @FXML
    private Button btnThem;
      
    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnXoa;
    
    @FXML
    private Button btnQLSP;

    @FXML
    private Button btnQLDH;
    
    @FXML
    private TableView<hoadon> tableDH;

    @FXML
    private TableColumn<hoadon, Integer> MaHD;

    @FXML
    private TableColumn<hoadon, Date> NgayDatHang;

     @FXML
    private AnchorPane pane;

    @FXML
    private TableColumn<hoadon, Integer> MaKH;

    @FXML
    private TableColumn<hoadon, Integer> MaNV;
    
    @FXML
    private Button btnLogout;
    
    int index = -1;
    ObservableList<sanpham> list;
    ObservableList<hoadon> listHD;
    PreparedStatement pst;
    Connection conn = null;
    public void Add_SanPham() throws SQLException{
        
        int soluongton = Integer.parseInt(txtSoLuongTon.getText());
        double dongia = Double.parseDouble(txtDonGia.getText());
        int maLoaiSP = Integer.parseInt(txtMaLoaiSP.getText());
        int maNSX = Integer.parseInt(txtMaNSX.getText());
            if(txtMaSP.getText() == "")
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Xin lỗi:");
                alert.setContentText("Mã sản phẩm không được bỏ trống");
                alert.showAndWait();
            }else if(txtTenSP.getText() == "")
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Xin lỗi:");
                alert.setContentText("Tên sản phẩm không được bỏ trống");
                alert.showAndWait();
            }else if(txtSoLuongTon.getText() == "")
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Xin lỗi:");
                alert.setContentText("Tên tài khoản không được bỏ trống");
                alert.showAndWait();
            }else if(txtDonGia.getText() == "")
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Xin lỗi:");
                alert.setContentText("Đơn giá không được bỏ trống");
                alert.showAndWait();
            }else if(txtDonViTinh.getText() == "")
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Xin lỗi:");
                alert.setContentText("Đơn vị tính không được bỏ trống");
                alert.showAndWait();
            }else if(txtMaLoaiSP.getText() == null)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Xin lỗi:");
                alert.setContentText("Mã loại sản phẩm không được bỏ trống");
                alert.showAndWait();
            }else if(dongia <= 0)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Xin lỗi:");
                alert.setContentText("Đơn giá phải lớn hơn 0");
                alert.showAndWait();
            }else if(soluongton <= 0)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Xin lỗi:");
                alert.setContentText("Số lượng tồn phải lớn hơn 0");
                alert.showAndWait();
            }else if(maLoaiSP <= 0 || maLoaiSP >6)
                {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Xin lỗi:");
                alert.setContentText("Mã loại sản phẩm phải từ 1 đến 6");
                alert.showAndWait(); 
            }else if(maNSX < 0 || maNSX >3)
                {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Xin lỗi:");
                alert.setContentText("Mã nhà sản xuất phải từ 0 đến 3");
                alert.showAndWait(); 
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Chúc mừng:");
                alert.setContentText("Bạn đã thêm sản phẩm thành công!!!");
                alert.show();
                
                sanpham s = new sanpham(Integer.parseInt(txtMaSP.getText()),txtTenSP.getText(),Integer.parseInt(txtSoLuongTon.getText())
                        ,Double.parseDouble(txtDonGia.getText()),txtDonViTinh.getText(),txtMoTa.getText()
                        ,Integer.parseInt(txtMaLoaiSP.getText()),Integer.parseInt(txtMaNSX.getText()));
                Utils.addSanPham(s);
                UpdateTable(); 
                UpdateTable();
            }
    }
    
    public void UpdateTable() throws SQLException{
            sanphamModel s = new sanphamModel(MySQLConnect.getConn());
            list = s.getObserSP();    
            MaSP.setCellValueFactory(new PropertyValueFactory<sanpham, Integer>("MaSP"));
            TenSP.setCellValueFactory(new PropertyValueFactory<sanpham, String>("TenSP"));
            SoLuongTon.setCellValueFactory(new PropertyValueFactory<sanpham, Integer>("SoLuongTon"));
            DonGia.setCellValueFactory(new PropertyValueFactory<sanpham, Double>("DonGia"));
            DonViTinh.setCellValueFactory(new PropertyValueFactory<sanpham, String>("DonviTinh"));
            MoTa.setCellValueFactory(new PropertyValueFactory<sanpham, String>("MoTa"));
            MaLoaiSP.setCellValueFactory(new PropertyValueFactory<sanpham, Integer>("MaLoaiSP"));
            MaNSX.setCellValueFactory(new PropertyValueFactory<sanpham, Integer>("MaNSX"));
            tableSP.setItems(list);
    }
    public void Delete() throws SQLException{
        
        sanpham s = new sanpham(Integer.parseInt(txtMaSP.getText()),txtTenSP.getText(),Integer.parseInt(txtSoLuongTon.getText())
                        ,Double.parseDouble(txtDonGia.getText()),txtDonViTinh.getText(),txtMoTa.getText()
                        ,Integer.parseInt(txtMaLoaiSP.getText()),Integer.parseInt(txtMaNSX.getText()));
        Utils.xoaSanPham(s);
        UpdateTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Chúc mừng:");
                alert.setContentText("Bạn đã xóa sản phẩm thành công!!!");
                alert.show();
//        conn = MySQLConnect.getConn();
//        String sql = "delete from sanpham where MaSP= ?";
//        try{
//            pst = conn.prepareStatement(sql);
//            pst.setString(1, txtMaSP.getText());
//            pst.execute();
//            UpdateTable();
//            
//        }catch(Exception e){}
    } 

    @FXML
    void getSelect(MouseEvent event){
        index = tableSP.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        txtMaSP.setText(MaSP.getCellData(index).toString());
        txtTenSP.setText(TenSP.getCellData(index).toString());
        txtSoLuongTon.setText(SoLuongTon.getCellData(index).toString());
        txtDonGia.setText(DonGia.getCellData(index).toString());
        txtDonViTinh.setText(DonViTinh.getCellData(index).toString());
        txtMoTa.setText(MoTa.getCellData(index).toString());
        txtMaLoaiSP.setText(MaLoaiSP.getCellData(index).toString());
        txtMaNSX.setText(MaNSX.getCellData(index).toString());
    }
    public void SanPhamShow(){
        tableSP.setVisible(true);
        tableDH.setVisible(false);
        pane.setVisible(true);
    }
    
    public void HoaDonShow(){
        tableSP.setVisible(false);
        tableDH.setVisible(true);
        pane.setVisible(false);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            UpdateTable();
            try {
                sanphamModel s = new sanphamModel(MySQLConnect.getConn());
                list = s.getObserSP();
                MaSP.setCellValueFactory(new PropertyValueFactory<sanpham, Integer>("MaSP"));
                TenSP.setCellValueFactory(new PropertyValueFactory<sanpham, String>("TenSP"));
                SoLuongTon.setCellValueFactory(new PropertyValueFactory<sanpham, Integer>("SoLuongTon"));
                DonGia.setCellValueFactory(new PropertyValueFactory<sanpham, Double>("DonGia"));
                DonViTinh.setCellValueFactory(new PropertyValueFactory<sanpham, String>("DonviTinh"));
                MoTa.setCellValueFactory(new PropertyValueFactory<sanpham, String>("MoTa"));
                MaLoaiSP.setCellValueFactory(new PropertyValueFactory<sanpham, Integer>("MaLoaiSP"));
                MaNSX.setCellValueFactory(new PropertyValueFactory<sanpham, Integer>("MaNSX"));
                tableSP.setItems(list);
            } catch (SQLException ex) {
                Logger.getLogger(HomeNhanVienController.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        } catch (SQLException ex) {
            Logger.getLogger(HomeNhanVienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            UpdateTable();
            try {
                sanphamModel sp = new sanphamModel(MySQLConnect.getConn());
                listHD = sp.getObserDH();
                MaHD.setCellValueFactory(new PropertyValueFactory<hoadon, Integer>("MaHD"));
                NgayDatHang.setCellValueFactory(new PropertyValueFactory<hoadon, Date>("NgayDatHang"));               
                MaKH.setCellValueFactory(new PropertyValueFactory<hoadon, Integer>("MaKH"));
                MaNV.setCellValueFactory(new PropertyValueFactory<hoadon, Integer>("MaNV"));
                tableDH.setItems(listHD);
            } catch (SQLException ex) {
                Logger.getLogger(HomeNhanVienController.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        } catch (SQLException ex) {
            Logger.getLogger(HomeNhanVienController.class.getName()).log(Level.SEVERE, null, ex);
        }

                
        
        tableSP.setEditable(true);
        
    }    
    
     @FXML
    void Logout(ActionEvent event) throws IOException {
        
        
        btnLogout.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
       
    }
    
    
   
    
}
