package dao;

import model.itemVenda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class itemVendaDAO {

    // Criar um novo item de venda
    public void inserirItemVenda(itemVenda item) {
        String sql = "INSERT INTO item_venda (livro_id, venda_id, quantidadeItem, valorItem) VALUES (?, ?, ?, ?)";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, item.getLivroId());
            stmt.setInt(2, item.getVendaId());
            stmt.setInt(3, item.getQuantidadeItem());
            stmt.setDouble(4, item.getValorItem());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ler todos os itens de venda
    public List<itemVenda> listarItensVenda() {
        List<itemVenda> lista = new ArrayList<>();
        String sql = "SELECT * FROM item_venda";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                itemVenda item = new itemVenda(
                        rs.getInt("livro_id"),
                        rs.getInt("venda_id"),
                        rs.getInt("quantidadeItem"),
                        rs.getDouble("valorItem")
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
        String sql = "UPDATE item_venda SET quantidadeItem = ?, valorItem = ? WHERE livro_id = ? AND venda_id = ?";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, item.getQuantidadeItem());
            stmt.setDouble(2, item.getValorItem());
            stmt.setInt(3, item.getLivroId());
            stmt.setInt(4, item.getVendaId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar um item de venda
    public void deletarItemVenda(int livroId, int vendaId) {
        String sql = "DELETE FROM item_venda WHERE livro_id = ? AND venda_id = ?";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, livroId);
            stmt.setInt(2, vendaId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
