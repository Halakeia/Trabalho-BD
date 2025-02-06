package dao;

import model.livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LivroDAO {
    // Cria um novo fornecedor
    public void criar_Livro(livro livros) 
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
                stmt.setInt(8, livros.getfornecedorID()); // identifica o id de fornecedores
                stmt.setInt(9, livros.geteditoraId()); //identifica o id da editora



                
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
    public List<livro> listar_Livro(){

        List<livro> lista = new ArrayList<>();
        String sql = "SELECT * FROM livro";

        try (Connection conn = Conexao.conectar();
             
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                livro livros =  new livro (
                rs.getInt("id"), 
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
    public void atualizar_Livro(livro livros) 
    {
        String sql = "UPDATE livro SET nome = ?, nomeAutor = ?, nomeEditora =?, valor= ?, quantidade = ?, dataCadastro=?, descricao=?, fornecedor=?, editora=? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, livros.getnome());
                stmt.setString(2, livros.getnomeAutor());
                stmt.setString(3, livros.getnomeEditora());
                stmt.setDouble(4, livros.getvalor());
                stmt.setInt(5, livros.getquantidade());
                stmt.setDate(6, Date.valueOf(livros.getdataCadastro()));
                stmt.setString(7, livros.getdescricao());
                stmt.setInt(8, livros.getfornecedorID()); // identifica o id de fornecedores
                stmt.setInt(9, livros.geteditoraId());
                stmt.setInt(10, livros.getid()); 
                stmt.executeUpdate();
            System.out.println("Livro atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Metodo para excluir um fornecedor 
    public void deletar_Livro(int id) {
        String sql = "DELETE FROM livro WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Livro deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public livro buscarLivros(String nome) {
        String sql = "SELECT * FROM livro WHERE id = ?";
        try (Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Busca na tabela de clientes
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Se o cliente existir, cria o objeto Cliente
                livro livros = new livro(
                        rs.getInt("id"),
                        rs.getInt("fornecedor_id"),
                        rs.getInt("editora_id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getDate("dataCadastro").toLocalDate()
                );
                return livros;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
