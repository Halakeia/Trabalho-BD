package dao;

import model.fornecedores;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedoresDAO {

    // Cria um novo fornecedor
    public void criarFornecedores(fornecedores fornecedores) {
        String sql = "INSERT INTO fornecedor(razaoSocial, nomeFantasia, cnpj) VALUES (?, ?, ?)"; 

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, fornecedores.getRazaoSocial());
            stmt.setString(2, fornecedores.getNomeFantasia());
            stmt.setString(3, fornecedores.getCnpj());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir fornecedor", e);
        }
    }

    // Método para listar todos os fornecedores 
    public List<fornecedores> listarFornecedores() {
        List<fornecedores> lista = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                fornecedores fornecedor = new fornecedores(
                        rs.getInt("id"),
                        rs.getString("razaoSocial"),
                        rs.getString("nomeFantasia"),
                        rs.getString("cnpj")
                );
                lista.add(fornecedor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para atualizar os dados do fornecedor
    public void atualizarFornecedor(fornecedores fornecedores) {
        String sql = "UPDATE fornecedor SET razaoSocial = ?, nomeFantasia = ?, cnpj = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedores.getRazaoSocial());
            stmt.setString(2, fornecedores.getNomeFantasia());
            stmt.setString(3, fornecedores.getCnpj());
            stmt.setInt(4, fornecedores.getId());
            stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um fornecedor 
    public void deletarFornecedor(int id) {
        String sql = "DELETE FROM fornecedor WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
