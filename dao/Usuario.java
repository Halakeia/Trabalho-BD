package dao;

import model.usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//Todas as classes criadas com letra maiuscula pertencem ao DAO

public class Usuario {
    // Cria um novo fornecedor
    public void criar_Usuario(usuario usuario) 
    {
        String sql = "INSERT INTO usuario (userName,senha) VALUES (?, ?)"; //como vai ser enviado para o banco de dados
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) 
            {
                //Recebe os dados atraves do Set e retorna para o valor no Get
                
                stmt.setString(1, usuario.getuserName());
                stmt.setInt(2, usuario.getsenha());
                stmt.executeUpdate();
    
                // Recupera o ID gerado 
                // Entender melhor como funciona 

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    usuario.setid(rs.getInt(1));
                }
    
            } 
            catch (SQLException e) 
            {
                throw new RuntimeException("Erro ao inserir usuario", e);
            }
        }

    //Método para Ler todos os fornecedores 
    public List<usuario> listar_Usuario(){

        List<usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = Conexao.conectar();
             
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                usuario usuario  =  new usuario (rs.getInt("id"), rs.getString("userName"), rs.getInt("senha"));
                lista.add(usuario );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    //Metodo para atualizar os dados 
    public void atualizar_Usuario(usuario usuario) 
    {
        String sql = "UPDATE usuario SET userName = ?, senha = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, usuario.getuserName());
                stmt.setInt(2, usuario.getsenha());
                stmt.setInt(3, usuario.getid());
                stmt.executeUpdate();
            System.out.println("Usuário atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Metodo para excluir um fornecedor 
    public void deletar_Usuario(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuario deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
