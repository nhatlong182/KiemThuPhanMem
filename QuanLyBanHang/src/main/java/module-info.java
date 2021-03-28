module com.mycompany.quanlybanhang {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    

    opens com.mycompany.quanlybanhang to javafx.fxml;
    exports com.mycompany.quanlybanhang;
}
