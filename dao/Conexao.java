package dao; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/bookflow";
    private static final String USER = "root"; // Seu usuário do MySQL
    private static final String PASSWORD = "root"; // Sua senha do MySQL

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Garante que o driver é carregado
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC não encontrado!", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados!", e);
        }
    }

    public static void main(String[] args) {
        Connection conexao = conectar();
        if (conexao != null) {
            System.out.println("Conectado ao MySQL com sucesso!");
        }
    }
}