module com.example.examen2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;


    opens com.example.examen2 to javafx.fxml;
    opens com.example.examen2.models;
    exports com.example.examen2;
    exports com.example.examen2.models;

}