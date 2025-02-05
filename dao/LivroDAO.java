package dao;
import java.sql.*;
import model.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    private Connection connection;

    public LivroDAO(Connection connection) {
        this.connection = connection;
    }

    // Inserir um novo livro
    public void inserirLivro(livro livro) {
        String sql = "INSERT INTO livro (fornecedor_id, editora_id, nome, quantidade, dataCadastro, descricao) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, livro.getFornecedorId());
            stmt.setInt(2, livro.getEditoraId());
            stmt.setString(3, livro.getNome());
            stmt.setInt(4, livro.getQuantidade());
            stmt.setTimestamp(5, Timestamp.valueOf(livro.getDataCadastro()));
            stmt.setString(6, livro.getDescricao());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        livro.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Atualizar um livro existente
    public void atualizarLivro(livro livro) {
        String sql = "UPDATE livro SET fornecedor_id = ?, editora_id = ?, nome = ?, quantidade = ?, dataCadastro = ?, descricao = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, livro.getFornecedorId());
            stmt.setInt(2, livro.getEditoraId());
            stmt.setString(3, livro.getNome());
            stmt.setInt(4, livro.getQuantidade());
            stmt.setTimestamp(5, Timestamp.valueOf(livro.getDataCadastro()));
            stmt.setString(6, livro.getDescricao());
            stmt.setInt(7, livro.getId());

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

    // Buscar um livro pelo ID
    public livro buscarLivroPorId(int id) {
        String sql = "SELECT * FROM livro WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new livro(
                    rs.getInt("id"),
                    rs.getInt("fornecedor_id"),
                    rs.getInt("editora_id"),
                    rs.getString("nome"),
                    rs.getInt("quantidade"),
                    rs.getTimestamp("dataCadastro").toLocalDateTime(),
                    rs.getString("descricao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Listar todos os livros
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
}
