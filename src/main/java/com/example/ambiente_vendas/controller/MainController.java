package com.example.ambiente_vendas.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private AnchorPane content;

    @FXML
    public void abrirHome() {
        carregarTela("Home.fxml");
    }

    @FXML
    public void abrirClientes() {
        carregarTela("Cadastrar_clientes.fxml");
    }

    @FXML
    public void abrirVendas() {
        carregarTela("Nova_venda.fxml");
    }

    @FXML
    public void abrirRelatorio() {
        System.out.println("Relatório ainda não implementado");
    }

    @FXML
    public void sobrenos() {
        System.out.println("Sistema de vendas - versão 1.0");
    }

    @FXML
    public void fecharPrograma() {
        Platform.exit();
    }

    private void carregarTela(String fxml) {
        try {
            Node tela = FXMLLoader.load(
                    getClass().getResource("/fxml/" + fxml)
            );

            content.getChildren().clear();
            content.getChildren().add(tela);

            AnchorPane.setTopAnchor(tela, 0.0);
            AnchorPane.setBottomAnchor(tela, 0.0);
            AnchorPane.setLeftAnchor(tela, 0.0);
            AnchorPane.setRightAnchor(tela, 0.0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
