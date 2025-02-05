package dao;

import java.sql.*;
import model.usuario;

public class LoginDAO {

    /**
     * Realiza a autenticação de um usuário com CPF e senha
     * @param userName CPF do usuário
     * @param senha Senha do usuário
     * @return O usuário autenticado ou NULL se falhar
     */
    public usuario autenticar(String userName, String senha) {
        String sql = "SELECT * FROM usuario WHERE userName = ? AND senha = ?";

        try (
                Connection conexao = Conexao.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)
        ) {
            stmt.setString(1, userName);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new usuario(
                        rs.getInt("id"),
                        rs.getInt("funcionario_id"),
                        rs.getString("userName"),
                        rs.getString("senha")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Retorna NULL se não encontrar o usuário
    }
}