package dao;

import model.livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LivroDAO {
    private Connection connection;

    public LivroDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirLivro(livro livro) {
        String sql = "INSERT INTO livro (fornecedor_id, editora_id, nome, quantidade, dataCadastro, descricao) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, livro.getfornecedorId());
            stmt.setInt(2, livro.geteditoraId());
            stmt.setString(3, livro.getnome());
            stmt.setInt(4, livro.getquantidade());
            stmt.setTimestamp(5, Timestamp.valueOf(livro.getdataCadastro()));
            stmt.setString(6, livro.getdescricao());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        livro.setid(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Método para Ler todos os livros
    public List<livro> listarTodosLivros() {
        List<livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livro";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                livros.add(new livro(
                    rs.getInt("id"),
                    rs.getInt("fornecedor_id"),
                    rs.getInt("editora_id"),
                    rs.getString("nome"),
                    rs.getInt("quantidade"),
                    rs.getTimestamp("dataCadastro").toLocalDateTime(),
                    rs.getString("descricao")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }

    //Metodo para atualizar os dados 
    public void atualizarLivro(livro livro) {
        String sql = "UPDATE livro SET fornecedor_id = ?, editora_id = ?, nome = ?, quantidade = ?, dataCadastro = ?, descricao = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, livro.getfornecedorId());
            stmt.setInt(2, livro.geteditoraId());
            stmt.setString(3, livro.getnome());
            stmt.setInt(4, livro.getquantidade());
            stmt.setTimestamp(5, Timestamp.valueOf(livro.getdataCadastro()));
            stmt.setString(6, livro.getdescricao());
            stmt.setInt(7, livro.getid());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Excluir um livro pelo ID
    public void excluirLivro(int id) {
        String sql = "DELETE FROM livro WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public livro buscarLivros(String nome) {
        String sql = "SELECT * FROM livro WHERE id = ?";
        try (Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Busca na tabela de clientes
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Se o cliente existir, cria o objeto Cliente
                livro livros = new livro(
                        rs.getInt("id"),
                        rs.getInt("fornecedor_id"),
                        rs.getInt("editora_id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getDate("dataCadastro").toLocalDate().atStartOfDay(),
                        rs.getString("descricao")
                );
                return livros;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
