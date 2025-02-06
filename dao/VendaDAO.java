package dao;

import model.cliente;
import model.venda;
import model.funcionario;
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

                // Obtendo a data e hora atual
            LocalDateTime now = LocalDateTime.now();

            // Convertendo para Timestamp (formato 'yyyy-MM-dd HH:mm:ss')
            Timestamp timestamp = Timestamp.valueOf(now);
            
            stmt.setTimestamp(1,timestamp); // Convertendo LocalDate para Timestamp
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

    //função para buscar um funcionario pelo CPF
    public funcionario buscarfuncionario(String cpf) {
        String sql = "SELECT * FROM funcionario WHERE cpf = ?";
        try (Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Busca na tabela de clientes
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Se o cliente existir, cria o objeto Cliente
                funcionario funcionario = new funcionario(
                        rs.getInt("id"),
                        rs.getInt("Cargo_id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getDouble("salario")
                );
                return funcionario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
