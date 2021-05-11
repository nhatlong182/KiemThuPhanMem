/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.mycompany.quanlybanhang.MySQLConnect;
import com.mycompany.pojo.sanpham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author pc
 */
public class Utils {
    PreparedStatement pst;
    public static boolean kiemTraDangNhap(String tenDangNhap,String matKhau) throws SQLException{
        boolean ketqua = false ;
        
        String sql = "select * from taikhoannv where TenTaiKhoan = '"+tenDangNhap+"' "
                + "and MatKhau = '"+matKhau+"'" ;
        String sql2 = "select * from taikhoankh where TenTaiKhoan = '"+tenDangNhap+"' "
                + "and MatKhau = '"+matKhau+"'" ;
        Connection conn = MySQLConnect.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        Connection conn2 = MySQLConnect.getConn();
        Statement stmt2 = conn2.createStatement();
        ResultSet rs2 = stmt2.executeQuery(sql2);
        
        
        
        if(rs.next()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Chúc mừng:");
            alert.setContentText("Bạn đã đăng nhập thành công!!!");
            alert.showAndWait();

            ketqua = true;
        }else if(rs2.next())
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Chúc mừng:");
            alert.setContentText("Bạn đã đăng nhập thành công!!!");
            alert.showAndWait();

            ketqua = true;
        }
            return ketqua;
        
    }
    
    public static boolean kiemTraDangNhapTest(String tenDangNhap,String matKhau) throws SQLException{
        boolean ketqua = false ;
        
        String sql = "select * from taikhoannv where TenTaiKhoan = '"+tenDangNhap+"' "
                + "and MatKhau = '"+matKhau+"'" ;
        String sql2 = "select * from taikhoankh where TenTaiKhoan = '"+tenDangNhap+"' "
                + "and MatKhau = '"+matKhau+"'" ;
        Connection conn = MySQLConnect.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        Connection conn2 = MySQLConnect.getConn();
        Statement stmt2 = conn2.createStatement();
        ResultSet rs2 = stmt2.executeQuery(sql2);
        
        
        
        if(rs.next()){
          

            ketqua = true;
        }else if(rs2.next())
        {
          

            ketqua = true;
        }
            return ketqua;
        
    }
    
    public static void addSanPham(sanpham k) throws SQLException{
        Connection conn = MySQLConnect.getConn();
        String sql = "insert into sanpham(MaSP,TenSP,SoLuongTon,DonGia,DonViTinh,MoTa,MaLoaiSP,MaNSX) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        
        
        stm.setInt(1,k.getMaSP());
        stm.setString(2, k.getTenSP());
        stm.setInt(3, k.getSoLuongTon());
        stm.setDouble(4, k.getDonGia());
        stm.setString(5, k.getDonviTinh());
        stm.setString(6,k.getMoTa());
        stm.setInt(7, k.getMaLoaiSP());
        stm.setInt(8, k.getMaNSX());
        
        stm.executeUpdate();
        conn.commit();
       
       
    }
    
    
     public static void addSanPhamTest(sanpham k) throws SQLException{
        Connection conn = MySQLConnect.getConn();
        String sql = "insert into sanpham(MaSP,TenSP,SoLuongTon,DonGia,DonViTinh,MoTa,MaLoaiSP,MaNSX) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        
        
        stm.setInt(1,k.getMaSP());
        stm.setString(2, k.getTenSP());
        stm.setInt(3, k.getSoLuongTon());
        stm.setDouble(4, k.getDonGia());
        stm.setString(5, k.getDonviTinh());
        stm.setString(6,k.getMoTa());
        stm.setInt(7, k.getMaLoaiSP());
        stm.setInt(8, k.getMaNSX());
        
        stm.executeUpdate();
        //conn.commit();
       
       
    }
    
      public static boolean themSanPhamTest(int masp) throws SQLException{
        boolean kq = false;
        Connection conn = MySQLConnect.getConn();
        String sql = "select * from sanpham where MaSP= ?";
        PreparedStatement stm = conn.prepareStatement(sql); 
        stm.setInt(1, masp);
        ResultSet rs = stm.executeQuery();
        while (rs.next())
        {
            kq = true;
        }    
        return kq;
     

    }
    
    public static void xoaSanPham(sanpham s) throws SQLException{
        
        
        Connection conn = MySQLConnect.getConn();
        String sql = "delete from sanpham where MaSP= ?";
        PreparedStatement stm = conn.prepareStatement(sql); 
        stm.setInt(1,s.getMaSP()); 
        stm.executeUpdate();
        
        

    }
     public static boolean xoaSanPhamTest(int masp) throws SQLException{
        boolean kq = true;
        Connection conn = MySQLConnect.getConn();
        String sql = "select * from sanpham where MaSP= ?";
        PreparedStatement stm = conn.prepareStatement(sql); 
        stm.setInt(1, masp);
        ResultSet rs = stm.executeQuery();
        while (rs.next())
        {
            kq = false;
        }    
        return kq;
     

    }
     
     
   
    
}
