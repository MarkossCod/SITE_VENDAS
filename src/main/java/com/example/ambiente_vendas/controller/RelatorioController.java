package com.example.ambiente_vendas.controller;

import javafx.fxml.FXML;

public class RelatorioController {

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void sair() {
        if (mainController != null) {
            mainController.abrirTelaInicial();
        }
    }
}
