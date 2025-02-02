package dao;

import model.fornecedores;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FornecedoresDAO 

{
    
    // Cria um novo fornecedor
    public void criar_Forncedores(fornecedores fornecedores) 
    {
        String sql = "INSERT INTO fornecedores(id,razaoSocial,nomeFantasia, cnpj) VALUES (?, ?)"; //como vai ser enviado para o banco de dados
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) 
            {
                //Recebe os dados atraves do Set e retorna para o valor no Get
                stmt.setInt(1, fornecedores.getid());
                stmt.setString(2, fornecedores.getrazaoSocial());
                stmt.setString(3, fornecedores.getnomeFantasia());
                stmt.setString(4, fornecedores.getcnpj());
                stmt.executeUpdate();
    
                // Recupera o ID gerado 
                // Entender melhor como funciona 

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    fornecedores.setid(rs.getInt(1));
                }
    
            } 
            catch (SQLException e) 
            {
                throw new RuntimeException("Erro ao inserir fornecedor", e);
            }
        }

    //Método para Ler todos os fornecedores 
    public List<fornecedores> listar_Fornecedores(){

        List<fornecedores> lista = new ArrayList<>();
        String sql = "SELECT * FROM fornecedores";

        try (Connection conn = Conexao.conectar();
             
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                fornecedores fornecedores =  new fornecedores (rs.getInt("id"), rs.getString("razaoSocial"), rs.getString("nomeFantasia"), rs.getString("cnpj"));
                lista.add(fornecedores);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    //Metodo para atualizar os dados 
    public void atualizar_Fornecedor(fornecedores fornecedores) {
        String sql = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, fornecedores.getid());
                stmt.setString(2, fornecedores.getrazaoSocial());
                stmt.setString(3, fornecedores.getnomeFantasia());
                stmt.setString(4, fornecedores.getcnpj());
                stmt.executeUpdate();
            System.out.println("Usuário atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Metodo para excluir um fornecedor 
    public void deletar_Fornecedor(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Fornecedor deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





}
