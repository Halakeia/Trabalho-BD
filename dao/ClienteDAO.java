package dao;

import java.sql.*;
import model.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // Criar (Inserir um cliente)
    public void inserirCliente(cliente cliente) {
        String sql = "INSERT INTO cliente (cpf, nome, email, dataNascimento) VALUES (?, ?, ?, ?)";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setDate(4, Date.valueOf(cliente.getDataNascimento())); // Conversão de LocalDate
            stmt.executeUpdate();

            System.out.println("\nCliente inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ler (Selecionar todos os clientes)
    public List<cliente> listarClientes() {
        String sql = "SELECT * FROM cliente";
        List<cliente> clientes = new ArrayList<>();
        try (Connection conexao = Conexao.conectar();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                cliente cliente = new cliente(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getDate("dataNascimento").toLocalDate()
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // Atualizar (Atualizar informações de um cliente)
    public void atualizarCliente(cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ?, dataNascimento = ? WHERE cpf = ?";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setDate(3, Date.valueOf(cliente.getDataNascimento())); // Conversão correta
            stmt.setString(4, cliente.getCpf());
            stmt.executeUpdate();

            System.out.println("\nCliente atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar (Deletar um cliente)
    public void deletarCliente(String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf = ?";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();

            System.out.println("\nCliente deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public cliente buscarCliente(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?";
        try (Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Busca na tabela de clientes
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Se o cliente existir, cria o objeto Cliente
                cliente cliente = new cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("dataNascimento").toLocalDate()
                );
                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
