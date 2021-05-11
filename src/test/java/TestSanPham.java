

import com.mycompany.quanlybanhang.MySQLConnect;
import com.mycompany.pojo.sanpham;
import Services.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author HuynhVi
 */
public class TestSanPham {
    
    private static Connection conn;
    public TestSanPham(){
    }
    
    @BeforeEach
    public static void setUpClass() {
     
    }
    
    @AfterEach
    public static void tearDownClass() throws SQLException {
        
    }
    
    @BeforeAll
    public void setUp() throws SQLException {
        conn = MySQLConnect.getConn();
    }
    
    @AfterAll
    public void tearDown() throws SQLException {
        conn.close();
    }
    
   //Test xoa san pham co ton tai
    @Test
    public void TestXoaSanPham1() throws SQLException{ 
       sanpham p = new sanpham();
       p.setMaSP(31);       
       Utils.xoaSanPham(p);   
       assertTrue(Utils.xoaSanPhamTest(31));
       
   }
    //Test xoa san pham co ton tai
   @Test
   public void TestXoaSanPham2() throws SQLException{ 
        sanpham p = new sanpham();
       p.setMaSP(32);       
       Utils.xoaSanPham(p);   
        assertTrue(Utils.xoaSanPhamTest(32));
        
    }
    //Test xoa san pham khong ton tai
    @Test
    public void TestXoaSanPham3() throws SQLException{ 
       sanpham p = new sanpham();
       p.setMaSP(34);       
        Utils.xoaSanPham(p);   
        assertFalse(Utils.xoaSanPhamTest(34));      
   }
    
    
    //Test xoa san pham failed
    @Test
    public void TestXoaSanPham4() throws SQLException{ 
       sanpham p = new sanpham();
       p.setMaSP(35);       
        Utils.xoaSanPham(p);   
        assertFalse(Utils.xoaSanPhamTest(35));      
   }
    
    
    //Test xoa san pham failed
    @Test
    public void TestXoaSanPham5() throws SQLException{ 
       sanpham p = new sanpham();
       p.setMaSP(36);       
        Utils.xoaSanPham(p);   
        assertFalse(Utils.xoaSanPhamTest(36));      
   }
    
    
    //Test them san pham hop le
    @Test
    public void TestAddSanPham1() throws SQLException 
    {   
        sanpham p = new sanpham(21,"21",1,1.0,"1","1",1,1);
        Utils.addSanPhamTest(p);
        assertTrue(Utils.themSanPhamTest(21));

    }
    
    //Test them san pham hop le
    @Test
    public void TestAddSanPham2() throws SQLException 
    {   
        sanpham p = new sanpham(22,"22",1,1.0,"1","1",1,1);
        Utils.addSanPhamTest(p);
        assertTrue(Utils.themSanPhamTest(22));

    }
    
    
    //Test them san pham da ton tai
    @Test
    public void TestAddSanPham3() throws SQLException 
    {   
        sanpham p = new sanpham(14,"1",1,1.0,"1","1",1,1);
        Utils.addSanPhamTest(p);
        assertTrue(Utils.themSanPhamTest(14));

    }
    
    
    //Test them san pham da ton tai
    @Test
    public void TestAddSanPham4() throws SQLException 
    {   
        sanpham p = new sanpham(13,"13",1,1.0,"1","1",1,1);
        Utils.addSanPhamTest(p);
        assertTrue(Utils.themSanPhamTest(13));

    }
    
    
    //Test them san pham failed
      @Test
    public void TestAddSanPham5() throws SQLException 
    {   
        sanpham p = new sanpham(12,"1",1,1.0,"1","1",1,1);
        Utils.addSanPhamTest(p);
        assertTrue(Utils.themSanPhamTest(12));

    }
    
   
    
}
