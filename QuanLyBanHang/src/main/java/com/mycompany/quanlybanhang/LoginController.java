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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
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
    private PasswordField txt_password;

    @FXML
    private TextField txt_address_up;

    @FXML
    private ComboBox type_up;

    @FXML
    private TextField txt_password_up;

    @FXML
    private AnchorPane pane_signup;

    @FXML
    private ComboBox type_sex_up;

    @FXML
    private Button btn_login;

    @FXML
    private ComboBox type;

    @FXML
    private TextField txt_lastname_up;

    @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_firstname_up;

    @FXML
    private TextField txt_phonenumber_up;

    @FXML
    private TextField txt_username_up;

    @FXML
    private AnchorPane pane_login;

    @FXML
    private Button btn_signup;

    @FXML
    private TextField txt_dayofbirth_up;

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy"); 
    
    Connection conn = null;
    Statement stm = null;
    ResultSet rs = null;
    PreparedStatement pst1 = null, pst2 = null;
    
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
                alert.setContentText("Xin hãy chọn chức vụ!!!");
                alert.showAndWait();
        } else if(txt_username.getText() == "")
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Xin lỗi:");
            alert.setContentText("Tên tài khoản không được bỏ trống");
            alert.showAndWait();
        } else if(txt_username.getText().contains(" "))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Xin lỗi:");
            alert.setContentText("Tên tài khoản không được chứa khoảng trắng");
            alert.showAndWait();
        
        } else if(!txt_username.getText().matches("\\w+"))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Xin lỗi:");
            alert.setContentText("Tên tài khoản không được chứa kí tự đặc biệt");
            alert.showAndWait();
        }
        else 
        {
            if (type.getValue().toString() == "Nhân viên")
            {
                sql = "select * from taikhoannv where TenTaiKhoan = ? and MatKhau = ?";
                home = "HomeEmployee.fxml";
            }
            else 
            {
                sql = "select * from taikhoankh where TenTaiKhoan = ? and MatKhau = ?";
                home = "HomeKhachhang.fxml";
            }
        
            try {
                pst1 = conn.prepareStatement(sql);
                pst1.setString(1, txt_username.getText());
                pst1.setString(2, txt_password.getText());
                rs = pst1.executeQuery();

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
        
        
    }
    
    public void add_users(ActionEvent event) throws SQLException{    
        conn = MySQLConnect.getConn();        
        String sql1 = "", sql2 = "", sql3 = "";
        
        if(type_up.getValue() == null) {
            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Xin lỗi:");
                alert.setContentText("Xin hãy chọn chức vụ!!!");
                alert.showAndWait();
        } else if(txt_username_up.getText().contains(" "))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Xin lỗi:");
            alert.setContentText("Tên tài khoản không được chứa khoảng trắng");
            alert.showAndWait();
        
        } else if(txt_username_up.getText() == "" || txt_password_up.getText() == "")
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Xin lỗi:");
            alert.setContentText("Tên tài khoản và mật khẩu không được bỏ trống");
            alert.showAndWait();
        }  else if(!txt_username_up.getText().matches("\\w+"))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Xin lỗi:");
            alert.setContentText("Tên tài khoản không được chứa kí tự đặc biệt");
            alert.showAndWait();
        }
        else 
        {
            if(type_up.getValue().toString() == "Nhân viên")
            {
                sql1 = "insert into nhanvien (HoNV,TenNV,GioiTinh,NgaySinh,DiaChi,DienThoai) values (?,?,?,?,?,?)";
                sql2 = "insert into taikhoannv (TenTaiKhoan,MatKhau,MaNV) values (?,?,?)";
                sql3 = "select * from nhanvien order by MaNV desc limit 1;";
            }
            else
            {
                sql1 = "insert into nhanvien (HoNV,TenNV,GioiTinh,NgaySinh,DiaChi,DienThoai) values (?,?,?,?,?,?)";
                sql2 = "insert into taikhoannv (TenTaiKhoan,MatKhau,MaNV) values (?,?,?)";
                sql3 = "select * from khachhang order by MaKH desc limit 1;";
            }


            try {
                stm = conn.createStatement();
                rs = stm.executeQuery(sql3);
                int id = 0;
                while (rs.next())
                {
                    id = rs.getInt(1);
                }
                
                //them du lieu vao bang nhan vien hoac khach hang
                pst1 = conn.prepareStatement(sql1);
                pst1.setString(1, txt_firstname_up.getText());
                pst1.setString(2, txt_lastname_up.getText());
                pst1.setString(3, type_sex_up.getValue().toString());
//                Date date = formatter.parse(txt_dayofbirth_up.getText());
//                pst1.setDate(4, (java.sql.Date) date);
                pst1.setString(5, txt_address_up.getText());
                
                pst1.setString(6, txt_phonenumber_up.getText());
                pst1.execute();
                //them du lieu vao bang tai khoan
                pst2 = conn.prepareStatement(sql2);
                pst2.setString(1, txt_username_up.getText());
                pst2.setString(1, txt_password_up.getText());
                pst2.setString(3, (id+1));
                pst2.execute();
                
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
                pst1.close();
                pst2.close();
                conn.close();
        }
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type_up.getItems().addAll("Nhân viên", "Khách hàng");
        type.getItems().addAll("Nhân viên", "Khách hàng"); 
        type_sex_up.getItems().addAll("Nam", "Nữ");
    }
}
