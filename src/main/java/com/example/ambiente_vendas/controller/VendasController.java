package com.example.ambiente_vendas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class VendasController {

    private MainController mainController;

    @FXML private ComboBox<String> comboClientes;
    @FXML private ComboBox<String> comboProdutos;
    @FXML private TextField quantidadeField;
    @FXML private TextField valorUnitarioField;
    @FXML private TextField valorTotalField;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;

        // 🔹 Esconde o MenuBar quando abrir a tela de vendas
        if (this.mainController != null) {
            this.mainController.getMenuBar().setVisible(false);
            this.mainController.getMenuBar().setManaged(false);
        }
    }

    @FXML
    public void initialize() {
        // Futuramente pode carregar clientes e produtos aqui
    }

    @FXML
    private void btnNovo() {
        limparCampos();
    }

    @FXML
    private void btnLimparCampos() {
        limparCampos();
    }

    @FXML
    private void btnSalvar() {
        calcularTotal();
        System.out.println("Venda salva com sucesso!");
    }

    @FXML
    private void btnSair() {
        if (mainController != null) {

            // 🔹 Volta para tela inicial
            mainController.abrirTelaInicial();

            // 🔹 Mostra novamente o MenuBar
            mainController.getMenuBar().setVisible(true);
            mainController.getMenuBar().setManaged(true);
        }
    }

    private void limparCampos() {
        quantidadeField.clear();
        valorUnitarioField.clear();
        valorTotalField.clear();
        comboClientes.getSelectionModel().clearSelection();
        comboProdutos.getSelectionModel().clearSelection();
    }

    private void calcularTotal() {
        try {
            double quantidade = Double.parseDouble(quantidadeField.getText());
            double valorUnitario = Double.parseDouble(valorUnitarioField.getText());
            double total = quantidade * valorUnitario;

            valorTotalField.setText(String.format("%.2f", total));

        } catch (NumberFormatException e) {
            valorTotalField.setText("0.00");
        }
    }

    public void btnLimparTabela(ActionEvent actionEvent) {

    }
}
