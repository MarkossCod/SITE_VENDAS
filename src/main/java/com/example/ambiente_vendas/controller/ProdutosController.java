package com.example.ambiente_vendas.controller;

import javafx.fxml.FXML;

public class ProdutosController {

    // ===== TEXTFIELDS (opcional se quiser usar depois) =====

    @FXML
    private void nomeproduto() {
        System.out.println("Nome do produto digitado");
    }

    @FXML
    private void marca() {
        System.out.println("Marca digitada");
    }

    @FXML
    private void valor() {
        System.out.println("Valor digitado");
    }

    @FXML
    private void idproduto() {
        System.out.println("ID do produto digitado");
    }

    @FXML
    private void descricao() {
        System.out.println("Descrição digitada");
    }

    // ===== BOTÕES =====

    @FXML
    private void abrirnovo() {
        System.out.println("Novo produto");
    }

    @FXML
    private void limparcampos() {
        System.out.println("Campos limpos");
    }

    @FXML
    private void limparprodutos() {
        System.out.println("Especificar produto");
    }

    @FXML
    private void limpartabela() {
        System.out.println("Tabela limpa");
    }

    @FXML
    private void salvaralteracoes() {
        System.out.println("Alterações salvas");
    }

    @FXML
    private void btnsair() {
        System.out.println("Saindo da tela de produtos");
    }
}
