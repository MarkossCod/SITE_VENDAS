package com.example.ambiente_vendas.DAO;

import com.example.ambiente_vendas.Model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Produto produto) throws SQLException {

        String sql = "INSERT INTO produtos (nome, preco, marca, descricao) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getMarca());
            stmt.setString(4, produto.getDescricao());
            stmt.execute();
        }
    }

    public List<Produto> listarTodos() throws SQLException {

        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setMarca(rs.getString("marca"));
                p.setDescricao(rs.getString("descricao"));

                produtos.add(p);
            }
        }

        return produtos;
    }

    public void atualizar(Produto produto) throws SQLException {

        String sql = "UPDATE produtos SET nome = ?, preco = ?, marca = ?, descricao = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getMarca());
            stmt.setString(4, produto.getDescricao());
            stmt.setInt(5, produto.getId());

            stmt.execute();
        }
    }

    public void deletar(int id) throws SQLException {

        String sql = "DELETE FROM produtos WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}
