package com.example.ambiente_vendas.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ClientesController {

    // REFERÊNCIA DO MAIN
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    // CAMPOS TEXTO
    @FXML private TextField nomeField;
    @FXML private TextField cpfField;
    @FXML private TextField emailField;
    @FXML private TextField telefoneField;
    @FXML private TextField idadeField;
    @FXML private TextField cepField;
    @FXML private TextField estadoField;
    @FXML private TextField cidadeField;
    @FXML private TextField complementoField;

    // RADIO BUTTON
    @FXML private RadioButton radioMasculino;
    @FXML private RadioButton radioFeminino;

    // TABELA
    @FXML private TableView<String> tabelaClientes;

    private ObservableList<String> listaClientes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        tabelaClientes.setItems(listaClientes);
    }

    @FXML
    private void btnnovo() {
        limparCampos();
    }

    @FXML
    private void btncadastrar() {

        String sexo = "";

        if (radioMasculino.isSelected()) {
            sexo = "Masculino";
        } else if (radioFeminino.isSelected()) {
            sexo = "Feminino";
        }

        String cliente = nomeField.getText() + " - " +
                cpfField.getText() + " - " +
                telefoneField.getText() + " - " +
                idadeField.getText() + " - " +
                cidadeField.getText() + " - " +
                estadoField.getText() + " - " +
                cepField.getText() + " - " +
                emailField.getText() + " - " +
                sexo;

        listaClientes.add(cliente);

        limparCampos();
    }

    @FXML
    private void btnlimpar() {
        limparCampos();
    }

    @FXML
    private void btnlimpartab() {
        listaClientes.clear();
    }

    @FXML
    private void btnsalvar() {
        System.out.println("Alterações salvas!");
    }

    // ✅ AGORA VOLTA PARA TELA INICIAL
    @FXML
    private void btnsair() {
        if (mainController != null) {
            mainController.abrirTelaInicial();
        }
    }

    private void limparCampos() {
        nomeField.clear();
        cpfField.clear();
        emailField.clear();
        telefoneField.clear();
        idadeField.clear();
        cepField.clear();
        estadoField.clear();
        cidadeField.clear();
        complementoField.clear();
        radioMasculino.setSelected(false);
        radioFeminino.setSelected(false);
    }
}
