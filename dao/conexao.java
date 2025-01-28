
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Essa class é responsavel por fazer a conexão do banco de dados projeto 
public class conexao{

    //Dados da conexão
    private static final String URL = "jdbc:mysql://localhost:3306/bookflow";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    //
    public static Connection conectar() {
        //testa possiveis erros dos dados da conexão
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } 
        
        //Exibe mensagem de erro na conexão
        catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }



}
