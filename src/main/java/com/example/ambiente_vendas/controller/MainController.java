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

    /* ==============================
       GETTER DO MENU
       ============================== */
    public MenuBar getMenuBar() {
        return menuBar;
    }

    /* ==============================
       TELA INICIAL (COM MENU)
       ============================== */
    @FXML
    public void abrirTelaInicial() {

        try {

            // 🔹 Mostra novamente o MenuBar
            menuBar.setVisible(true);
            menuBar.setManaged(true);

            root.getChildren().clear();

            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(
                            getClass().getResource("/fxml/Main.fxml")
                    )
            );

            Node telaPrincipal = loader.load();

            root.getChildren().add(telaPrincipal);

            AnchorPane.setTopAnchor(telaPrincipal, 0.0);
            AnchorPane.setBottomAnchor(telaPrincipal, 0.0);
            AnchorPane.setLeftAnchor(telaPrincipal, 0.0);
            AnchorPane.setRightAnchor(telaPrincipal, 0.0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ==============================
       LOGIN (SEM MENU)
       ============================== */
    @FXML
    public void abrirLogin() {

        try {

            menuBar.setVisible(false);
            menuBar.setManaged(false);

            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(
                            getClass().getResource("/fxml/Tela_login.fxml"),
                            "Tela_login.fxml não encontrado"
                    )
            );

            Node tela = loader.load();

            root.getChildren().clear();
            root.getChildren().add(tela);

            AnchorPane.setTopAnchor(tela, 0.0);
            AnchorPane.setBottomAnchor(tela, 0.0);
            AnchorPane.setLeftAnchor(tela, 0.0);
            AnchorPane.setRightAnchor(tela, 0.0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ==============================
       CLIENTES (COM MENU)
       ============================== */
    @FXML
    public void abrirClientes() {

        menuBar.setVisible(true);
        menuBar.setManaged(true);

        root.getChildren().clear();
        carregarTela("Cadastrar_clientes.fxml");
    }

    @FXML
    public void abrirProdutos() {

        menuBar.setVisible(true);
        menuBar.setManaged(true);

        root.getChildren().clear();
        carregarTela("Cadastrar_produtos.fxml");
    }


    /* ==============================
       VENDAS (SEM MENU)
       ============================== */
    @FXML
    public void abrirVendas() {

        menuBar.setVisible(false);
        menuBar.setManaged(false);

        root.getChildren().clear();
        carregarTela("Nova_venda.fxml");
    }

    /* ==============================
       RELATÓRIO (COM MENU)
       ============================== */
    @FXML
    public void abrirRelatorio() {

        menuBar.setVisible(true);
        menuBar.setManaged(true);

        root.getChildren().clear();
        carregarTela("Relatorio.fxml");
    }

    /* ============================== */

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

    /* ============================== */

    private void carregarTela(String fxml) {
        try {

            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(
                            getClass().getResource("/fxml/" + fxml),
                            "FXML não encontrado: " + fxml
                    )
            );

            Node tela = loader.load();

            Object controller = loader.getController();

            if (controller instanceof RelatorioController) {
                ((RelatorioController) controller).setMainController(this);
            }

            if (controller instanceof ClientesController) {
                ((ClientesController) controller).setMainController(this);
            }

            if (controller instanceof VendasController) {
                ((VendasController) controller).setMainController(this);
            }

            // 🔥 ADICIONE ISSO AQUI
            if (controller instanceof ProdutosController) {
                ((ProdutosController) controller).setMainController(this);
            }

            root.getChildren().add(tela);

            AnchorPane.setTopAnchor(tela, 0.0);
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
