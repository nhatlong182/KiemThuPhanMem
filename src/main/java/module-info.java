module com.mycompany.quanlybanhang {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    

    opens com.mycompany.quanlybanhang to javafx.fxml;
    //opens com.mycompany.pojo to java.base;
    exports com.mycompany.quanlybanhang;
    exports com.mycompany.pojo;
    exports com.mycompany.service;
}
