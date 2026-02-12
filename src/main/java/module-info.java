module com.example.ambiente_vendas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ambiente_vendas to javafx.fxml;
    exports com.example.ambiente_vendas;
    exports com.example.ambiente_vendas.controller;
    opens com.example.ambiente_vendas.controller to javafx.fxml;
}