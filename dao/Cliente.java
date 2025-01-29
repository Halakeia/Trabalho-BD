package dao;

import model.cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class Cliente {
    // basicamente conecto com meu banco de dados e falo pra ele o que estou "fazendo"
    
        // Método para inserir um cliente
    public void criar(cliente cliente) {
        String sql = "INSERT INTO usuarios (id,nome,cpf, email, dataNascimento ) VALUES (?, ?)"; //como vai ser digitado
        try (Connection conn = Conexao.conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
    
                stmt.setInt(1, cliente.getid());
                stmt.setString(2, cliente.getnome());
                stmt.setString(3, cliente.getcpf());
                stmt.setString(4, cliente.getEmail());
                //stmt.setLocalDate(5, cliente.getdataNascimento()); Aprender a conversão.... Socorro
                stmt.executeUpdate();
    
                // Recupera o ID gerado 
                // Entender melhor como funciona 

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    cliente.setid(rs.getInt(1));
                }
    
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao inserir usuário", e);
            }
        }

    // Coisas que faltam ser realizadas 
        //---- Método para listar todos os usuários
        //---- Método para excluir um usuário pelo ID
        //---- Método para buscar um usuário





}
