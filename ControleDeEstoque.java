package projeto.src.main.java.com.mycompany.projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControleDeEstoque {

    private Connection conexao;

    public ControleDeEstoque() {
        String url = "jdbc:mysql://aws.connect.psdb.cloud/projeto_java?sslMode=VERIFY_IDENTITY";
        String usuario = "fiiorhfk3qpx5rt30phd";
        String senha = "pscale_pw_PP8E1mLRvxpZsv6Qgk3K6SsEGSIupogeD12veoBRSbr";

        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
        }
    }

    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produtos (nome, descricao, quantidade, preco) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setInt(3, produto.getQuantidade());
            preparedStatement.setDouble(4, produto.getValor());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void removerProduto(String nome) {
        String sql = "DELETE FROM produtos WHERE nome = ?";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Produto> listarProdutos() {
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String descricao = resultSet.getString("descricao");
                int quantidade = resultSet.getInt("quantidade");
                double valor = resultSet.getDouble("preco");

                Produto produto = new Produto(nome, descricao, quantidade, valor);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return produtos;
    }
}
