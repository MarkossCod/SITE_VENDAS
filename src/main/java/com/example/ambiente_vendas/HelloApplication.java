package com.example.ambiente_vendas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(
                            getClass().getResource("/fxml/Main.fxml"),
                            "Main.fxml não encontrado em /fxml"
                    )
            );

            Scene scene = new Scene(loader.load(), 800, 600);

            stage.setTitle("Sistema com menu fixo!");
            stage.setScene(scene);

            stage.setResizable(false);
            stage.centerOnScreen();

            stage.show();

        } catch (Exception e) {
            System.err.println("Erro ao iniciar a aplicação:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
