package dao;

import model.venda;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    // Inserir uma nova venda
    public void inserirVenda(venda venda) {
        String sql = "INSERT INTO venda (dataHora, cliente_id, funcionario_id) VALUES (?, ?, ?)";
        
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setTimestamp(1, Timestamp.valueOf(venda.getDataHora().atStartOfDay())); // Convertendo LocalDate para Timestamp
            stmt.setInt(2, venda.getIdCliente());
            stmt.setInt(3, venda.getIdFuncionario());
            stmt.executeUpdate();

            // Captura o ID gerado automaticamente
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    venda.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todas as vendas
    public List<venda> listarVendas() {
        List<venda> lista = new ArrayList<>();
        String sql = "SELECT * FROM venda";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                venda venda = new venda(
                        rs.getInt("id"),
                        rs.getTimestamp("dataHora").toLocalDateTime().toLocalDate(),
                        rs.getInt("cliente_id"),
                        rs.getInt("funcionario_id")
                );
                lista.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Atualizar uma venda existente
    public void atualizarVenda(venda venda) {
        String sql = "UPDATE venda SET dataHora = ?, cliente_id = ?, funcionario_id = ? WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setTimestamp(1, Timestamp.valueOf(venda.getDataHora().atStartOfDay()));
            stmt.setInt(2, venda.getIdCliente());
            stmt.setInt(3, venda.getIdFuncionario());
            stmt.setInt(4, venda.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar uma venda pelo ID
    public void deletarVenda(int id) {
        String sql = "DELETE FROM venda WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
