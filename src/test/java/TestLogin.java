/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.quanlybanhang.MySQLConnect;
import Services.Utils;
import javafx.scene.control.Label;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import java.lang.ExceptionInInitializerError;
/**
 *
 * @author Admin
 */
public class TestLogin {
    private Connection conn;
    public TestLogin() {
    }
    
    @BeforeEach
    public static void setUpClass() {
    }
    
    @AfterEach
    public static void tearDownClass() {
    }
    
    @BeforeAll
    public void setUp() throws SQLException {
       conn = MySQLConnect.getConn();
    }
    
    @AfterAll
    public void tearDown() throws SQLException {
        conn.close();
    }
    
    @Test
    public void LoginTest1(){
        try {
            System.out.println("Test Login with Blank Username and Password");
            String tk = "";
            String mk = "";
            boolean kq = Utils.kiemTraDangNhapTest(tk, mk);
            assertFalse(kq);
    }   catch (SQLException ex) {
            Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void LoginTest2(){
        try {
            System.out.println("Test Login with Blank Username");
            String tk = "";
            String mk = "admin";
            boolean kq = Utils.kiemTraDangNhapTest(tk, mk);
            assertFalse(kq);
    }   catch (SQLException ex) {
            Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    @Test
    public void LoginTest3(){
        try {
            System.out.println("Test Login with Blank Password");
            String tk = "admin";
            String mk = "";
            boolean kq = Utils.kiemTraDangNhapTest(tk, mk);
            assertFalse(kq);
        } catch (SQLException ex) {
            Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     @Test
    public void LoginTest4(){
        try {
            System.out.println("Test Login with Correct Username and  Wrong Password");
            String tk = "admin";
            String mk = "132456";
            boolean kq = Utils.kiemTraDangNhapTest(tk,mk);
            assertFalse(kq);
    }   catch (SQLException ex) {
            Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Test
    public void LoginTest5(){
        try {
            System.out.println("Test Login with Wrong Username and Correct Password");
            String tk = "asdsa";
            String mk = "admin";
            boolean kq = Utils.kiemTraDangNhapTest(tk,mk);
            assertFalse(kq);
        } catch (SQLException ex) {
            Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Test
    public void LoginTest6(){
        try {
            System.out.println("Test Login with Correct Username and Password of User is EMPLOYEE ");
            String tk = "admin";
            String mk = "123";
            boolean kq = Utils.kiemTraDangNhapTest(tk,mk);
            assertTrue(kq);
        } catch (SQLException ex) {
            Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void LoginTest7(){
        try {
            System.out.println("Test Login with Correct Username and Password of user is CUSTOMER");
            String tk = "adc";
            String mk = "123";
            boolean kq = Utils.kiemTraDangNhapTest(tk,mk);
            assertTrue(kq);
        } catch (SQLException ex) {
           
            Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
