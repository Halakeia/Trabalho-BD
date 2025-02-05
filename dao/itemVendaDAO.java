package dao;

import model.itemVenda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class itemVendaDAO {

    // Criar um novo item de venda
    public void inserirItemVenda(itemVenda item) {
        String sql = "INSERT INTO item_venda (livro_id, venda_id, quantidadeItem) VALUES (?, ?, ?)";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, item.getLivroId());
            stmt.setInt(2, item.getVendaId());
            stmt.setInt(3, item.getQuantidadeItem());
            stmt.executeUpdate();

            // Capturar o ID gerado automaticamente
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ler todos os itens de venda
    public List<itemVenda> listarItensVenda() {
        List<itemVenda> lista = new ArrayList<>();
        String sql = "SELECT item_venda_id, livro_id, venda_id, quantidadeItem FROM item_venda";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                itemVenda item = new itemVenda(
                        rs.getInt("item_venda_id"),
                        rs.getInt("livro_id"),
                        rs.getInt("venda_id"),
                        rs.getInt("quantidadeItem")
                );
                lista.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Atualizar um item de venda
    public void atualizarItemVenda(itemVenda item) {
        String sql = "UPDATE item_venda SET livro_id = ?, venda_id = ?, quantidadeItem = ? WHERE item_venda_id = ?";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, item.getLivroId());
            stmt.setInt(2, item.getVendaId());
            stmt.setInt(3, item.getQuantidadeItem());
            stmt.setInt(4, item.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar um item de venda pelo ID
    public void deletarItemVenda(int id) {
        String sql = "DELETE FROM item_venda WHERE item_venda_id = ?";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
