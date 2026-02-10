package com.example.ambiente_vendas.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

public class MainController {

    @FXML
    private AnchorPane root;

    @FXML
    private MenuBar menuBar;

    @FXML
    public void abrirTelaInicial() {
        root.getChildren().remove(menuBar); // remove o menu
        carregarTela("Tela_login.fxml");
    }

    @FXML
    public void abrirClientes() {
        adicionarMenuSeNecessario();
        carregarTela("Cadastrar_clientes.fxml");
    }

    @FXML
    public void abrirVendas() {
        adicionarMenuSeNecessario();
        carregarTela("Nova_venda.fxml");
    }

    @FXML
    public void abrirRelatorio() {
        adicionarMenuSeNecessario();
        carregarTela("Relatorio.fxml");
    }

    @FXML
    public void sobrenos() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sobre o sistema");
        alert.setHeaderText("Sistema de vendas");
        alert.setContentText(
                "Desenvolvedor: Markos Samuell\n" +
                        "Ano de lançamento: 2026\n" +
                        "Status do sistema: em processo de construção"
        );
        alert.showAndWait();
    }

    @FXML
    public void fecharPrograma() {
        Platform.exit();
    }

    @FXML
    private void sair() {
        abrirTelaInicial();
    }

    private void adicionarMenuSeNecessario() {
        if (!root.getChildren().contains(menuBar)) {
            root.getChildren().add(0, menuBar); // menu sempre no topo
        }
    }

    private void carregarTela(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(
                            getClass().getResource("/fxml/" + fxml),
                            "FXML não encontrado: " + fxml
                    )
            );

            Node tela = loader.load();

            // remove tudo que NÃO é menu
            root.getChildren().removeIf(node -> node != menuBar);

            root.getChildren().add(tela);

            AnchorPane.setTopAnchor(
                    tela,
                    root.getChildren().contains(menuBar) ? 25.0 : 0.0
            );
            AnchorPane.setBottomAnchor(tela, 0.0);
            AnchorPane.setLeftAnchor(tela, 0.0);
            AnchorPane.setRightAnchor(tela, 0.0);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao abrir a tela");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        }
    }
}
