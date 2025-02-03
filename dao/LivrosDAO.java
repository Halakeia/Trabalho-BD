package dao;

import model.livros;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.usuario;

public class LivrosDAO {
    // Cria um novo fornecedor
    public void criar_Usuario(livros livros) 
    {
        String sql = "INSERT INTO livro (nome,nomeAutor, nomeEditora, valor, quantidade, dataCadastro, descricao, fornecedor, editora) VALUES (?, ?)"; //como vai ser enviado para o banco de dados
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) 
            {
                //Recebe os dados atraves do Set e retorna para o valor no Get
                
                stmt.setString(1, livros.getnome());
                stmt.setString(2, livros.getnomeAutor());
                stmt.setString(3, livros.getnomeEditora());
                stmt.setDouble(4, livros.getvalor());
                stmt.setInt(5, livros.getquantidade());
                stmt.setDate(6, Date.valueOf(livros.getdataCadastro()));
                stmt.setString(7, livros.getdescricao());
                stmt.setInt(8, livros.getfornecedores()); // identifica o id de fornecedores
                stmt.setInt(9, livros.geteditora()); //identifica o id da editora



                
                stmt.executeUpdate();
    
                // Recupera o ID gerado 
                // Entender melhor como funciona 

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    livros.setid(rs.getInt(1));
                }
    
            } 
            catch (SQLException e) 
            {
                throw new RuntimeException("Erro ao inserir Fornecedor", e);
            }
        }

    //Método para Ler todos os fornecedores 
    public List<livros> listar_Usuario(){

        List<livros> lista = new ArrayList<>();
        String sql = "SELECT * FROM livro";

        try (Connection conn = Conexao.conectar();
             
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                livros livros =  new livros (rs.getInt("id"), 
                rs.getString("nome"),
                rs.getString("nomeAutor"),
                rs.getString("nomeEditora"),
                rs.getDouble("valor"),
                rs.getInt("quantidade"),
                rs.getDate("dataCadastro").toLocalDate(),
                rs.getInt("cliente_id"),
                rs.getInt("usuario_id"));

                lista.add(livros );
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
