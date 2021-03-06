/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlybanhang;

import Services.Utils;
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
import javafx.application.Platform;
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
import javafx.stage.StageStyle;


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
    private PasswordField txt_password_up;

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

        String tendangnhap = txt_username.getText();
        String matkhau = txt_password.getText();
        
        if(type.getValue() == null) {
            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Th??ng b??o");
                alert.setHeaderText("Xin l???i:");
                alert.setContentText("Xin h??y ch???n ch???c v???!!!");
                alert.showAndWait();
        } else if(txt_username.getText() == "")
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText("Xin l???i:");
            alert.setContentText("T??n t??i kho???n kh??ng ???????c b??? tr???ng");
            alert.showAndWait();
        } else if(txt_username.getText().contains(" "))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText("Xin l???i:");
            alert.setContentText("T??n t??i kho???n kh??ng ???????c ch???a kho???ng tr???ng");
            alert.showAndWait();
        
        } else if(!txt_username.getText().matches("\\w+"))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText("Xin l???i:");
            alert.setContentText("T??n t??i kho???n kh??ng ???????c ch???a k?? t??? ?????c bi???t");
            alert.showAndWait();
        }
        else if(Utils.kiemTraDangNhap(tendangnhap,matkhau)){
           
             btn_login.getScene().getWindow().hide();
           
            if (type.getValue().toString() == "Kh??ch h??ng")
            {
                sql = "select * from taikhoankh where TenTaiKhoan = ? and MatKhau = ?";
                home = "HomeKhachHang.fxml";
                
            }
            else 
            {
                sql = "select * from taikhoannv where TenTaiKhoan = ? and MatKhau = ?";
                home = "HomeNhanVien.fxml";
            }
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
                    alert.setTitle("Th??ng b??o");
                    alert.setHeaderText("Xin l???i:");
                    alert.setContentText("T??i kho???n ho???c m???t kh???u kh??ng ch??nh x??c!!!");               
                    alert.showAndWait();
                }                             
                    
              
        }

        
    public void add_users(ActionEvent event) throws SQLException{    
        conn = MySQLConnect.getConn();        
        String sql1 = "", sql2 = "", sql3 = "";
        
        if(type_up.getValue() == null) {
            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Th??ng b??o");
                alert.setHeaderText("Xin l???i:");
                alert.setContentText("Xin h??y ch???n ch???c v???!!!");
                alert.showAndWait();
        } else if(txt_username_up.getText().contains(" "))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText("Xin l???i:");
            alert.setContentText("T??n t??i kho???n kh??ng ???????c ch???a kho???ng tr???ng");
            alert.showAndWait();
        
        } else if(txt_username_up.getText() == "" || txt_password_up.getText() == "")
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText("Xin l???i:");
            alert.setContentText("T??n t??i kho???n v?? m???t kh???u kh??ng ???????c b??? tr???ng");
            alert.showAndWait();
        }  else if(!txt_username_up.getText().matches("\\w+"))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText("Xin l???i:");
            alert.setContentText("T??n t??i kho???n kh??ng ???????c ch???a k?? t??? ?????c bi???t");
            alert.showAndWait();
        }   else if(type_sex_up.getValue() == null)
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText("Xin l???i:");
            alert.setContentText("Xin h??y ch???n gi???i t??nh");
            alert.showAndWait();
        }   else if(txt_firstname_up.getText() == "" || txt_lastname_up.getText() == "")
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText("Xin l???i:");
            alert.setContentText("Xin h??y ??i???n ?????y ????? th??ng tin h??? t??n");
            alert.showAndWait();
        }   
        else 
        {
            if(type_up.getValue().toString() == "Nh??n vi??n")
            {
                sql1 = "insert into nhanvien (HoNV,TenNV,GioiTinh,DiaChi,DienThoai) values (?,?,?,?,?)";
                sql2 = "insert into taikhoannv (TenTaiKhoan,MatKhau,MaNV) values (?,?,?)";
                sql3 = "select * from nhanvien order by MaNV desc limit 1;";
            }
            else
            {
                sql1 = "insert into khachhang (HoKH,TenKH,GioiTinh,DiaChi,DienThoai) values (?,?,?,?,?)";
                sql2 = "insert into taikhoankh (TenTaiKhoan,MatKhau,MaKH) values (?,?,?)";
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
                pst1.setString(4, txt_address_up.getText());
                pst1.setString(5, txt_phonenumber_up.getText());
                pst1.execute();
                
                //them du lieu vao bang tai khoan
                pst2 = conn.prepareStatement(sql2);
                pst2.setString(1, txt_username_up.getText());
                pst2.setString(2, txt_password_up.getText());
                pst2.setInt(3, id+1);
                pst2.execute();
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Th??ng b??o");
                alert.setHeaderText("Ch??c m???ng:");
                alert.setContentText("B???n ???? ????ng k?? t??i kho???n th??nh c??ng");
                alert.showAndWait();
                txt_username_up.setText("");
                txt_password_up.setText("");
                txt_address_up.setText("");
                txt_dayofbirth_up.setText("");
                txt_firstname_up.setText("");
                txt_lastname_up.setText("");
                txt_phonenumber_up.setText("");

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
        type_up.getItems().addAll("Nh??n vi??n", "Kh??ch h??ng");
        type.getItems().addAll("Nh??n vi??n", "Kh??ch h??ng"); 
        type_sex_up.getItems().addAll("Nam", "N???", "Kh??c");
    }
}
