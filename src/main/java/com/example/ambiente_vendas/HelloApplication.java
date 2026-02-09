package com.example.ambiente_vendas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                HelloApplication.class.getResource("/fxml/Main.fxml")
        );

        Scene scene = new Scene(loader.load(), 800, 600);

        stage.setTitle("Sistema com menu fixo!");
        stage.setScene(scene);

        // garante 800x600
        stage.setWidth(800);
        stage.setHeight(600);

        // trava o redimensionamento
        stage.setResizable(false);

        // centraliza na tela (opcional, mas recomendado)
        stage.centerOnScreen();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
