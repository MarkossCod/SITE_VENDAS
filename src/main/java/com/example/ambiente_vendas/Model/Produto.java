package com.example.ambiente_vendas.Model;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private String marca;
    private String descricao;

    public Produto() {}

    public Produto(String nome, double preco, String marca, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
        this.descricao = descricao;
    }

    // GETTERS E SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
