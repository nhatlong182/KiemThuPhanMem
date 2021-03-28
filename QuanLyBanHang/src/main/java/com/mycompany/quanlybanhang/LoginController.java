/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlybanhang;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author pc
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane pane_login;

    @FXML
    private Button btn_login;

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_password;

    @FXML
    private ComboBox type;

    @FXML
    private AnchorPane pane_signup;

    @FXML
    private ComboBox type_up;

    @FXML
    private Button btn_signup;

    @FXML
    private TextField txt_username_up;

    @FXML
    private TextField txt_password_up;

    @FXML
    private TextField email_up;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public void LoginPaneShow(){
        pane_login.setVisible(true);
        pane_signup.setVisible(false);
    }
    
    public void SignUpPaneShow(){
        pane_signup.setVisible(true);
        pane_login.setVisible(false);
    }
    
    public void Login (ActionEvent event) throws Exception {
        conn = MySQLConnect.getConn();
        String sql = "";
        String home = "";
        if(type.getValue() == null) {
            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Xin lỗi:");
                alert.setContentText("Xin hãy chọn nhân viên hoặc khách hàng!!!");
                alert.showAndWait();
        }
        
        if (type.getValue().toString() == "Nhân viên")
        {
            sql = "select * from taikhoannv where TenTaiKhoan = ? and MatKhau = ?";
            home = "HomeEmployee.fxml";
        }
        else 
        {
            sql = "select * from taikhoankh where TenTaiKhoan = ? and MatKhau = ?";
            home = "HomeCustomers.fxml";
        }
        
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.setString(2, txt_password.getText());
            rs = pst.executeQuery();
            
            if(rs.next()){ 
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Chúc mừng:");
                alert.setContentText("Bạn đã đăng nhập thành công!!!");
                alert.showAndWait();
                
                btn_login.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource(home));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();  
            }
            else
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Xin lỗi:");
                alert.setContentText("Tài khoản hoặc mật khẩu không chính xác!!!");               
                alert.showAndWait();
            }                             
        } catch(Exception e) {
                e.printStackTrace();
          }
        rs.close();
        conn.close();
    }
    
    public void add_users(ActionEvent event) throws SQLException{    
        conn = MySQLConnect.getConn();        
        String sql = "";
        if(type_up.getValue().toString() == "Nhân viên")
            sql = "insert into nhanvien (HoNV,TenNV) values (?,?)";
        else
            sql = "insert into khachhang (HoKH,TenKH) values (?,?)";
        
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_username_up.getText());
            pst.setString(2, txt_password_up.getText());
            pst.execute();
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Chúc mừng:");
            alert.setContentText("Bạn đã đăng ký tài khoản thành công");
            alert.showAndWait();
            txt_username_up.setText("");
            txt_password_up.setText("");
            
                         
        } catch (Exception e) {
           e.printStackTrace();
        }  
       pst.close();
       conn.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type_up.getItems().addAll("Nhân viên", "Khách hàng");
        type.getItems().addAll("Nhân viên", "Khách hàng"); 
        
    }
}
