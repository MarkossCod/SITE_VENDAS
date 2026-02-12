package com.example.ambiente_vendas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.example.ambiente_vendas.DAO.ProdutoDAO;
import com.example.ambiente_vendas.Model.Produto;
import javafx.scene.control.Alert;


public class ProdutosController {

    private MainController mainController;
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    @FXML
    private TextField nomeField;
    @FXML
    private TextField codigoField;
    @FXML
    private TextField valorField;
    @FXML
    private TextField marcaField;
    @FXML
    private TextField descricaoField;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;

        if (this.mainController != null) {
            this.mainController.getMenuBar().setVisible(false);
            this.mainController.getMenuBar().setManaged(false);
        }
    }

    @FXML
    private void abrirNovo() {
        limparCampos();
    }

    @FXML
    private void especificarProduto() {
        System.out.println("Produto especificado.");
    }

    @FXML
    private void limparCampos() {
        nomeField.clear();
        codigoField.clear();
        valorField.clear();
        marcaField.clear();
        descricaoField.clear();
    }

    @FXML
    private void limparTabela() {
        System.out.println("Tabela limpa.");
    }

    @FXML
    private void salvarAlteracoes() {

        try {

            String nome = nomeField.getText();
            double preco = Double.parseDouble(valorField.getText());
            String marca = marcaField.getText();
            String descricao = descricaoField.getText();

            Produto produto = new Produto(nome, preco, marca, descricao);

            produtoDAO.salvar(produto);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Produto salvo com sucesso!");
            alert.showAndWait();

            limparCampos();

        } catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Valor inválido");
            alert.setContentText("Digite um número válido para o preço.");
            alert.showAndWait();

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao salvar");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

            e.printStackTrace();
        }
    }

    @FXML
    private void btnsair() {
        if (mainController != null) {
            mainController.abrirTelaInicial();
            mainController.getMenuBar().setVisible(true);
            mainController.getMenuBar().setManaged(true);
        }
    }
}

