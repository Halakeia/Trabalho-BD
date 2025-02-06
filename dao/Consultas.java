package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Consultas {

    private Connection connection;

    // ------------------- Consultas com Junção -------------------

    public List<String> getLivrosEAutores() {
        List<String> resultado = new ArrayList<>();
        String query = "SELECT l.nome AS livro, a.nomeAutor AS autor " + // Ajustando para o nome correto da coluna
                "FROM livro l " +
                "JOIN livro_autor la ON l.id = la.livro_id " +
                "JOIN autor a ON la.autor_id = a.id";

        try (Connection connection = Conexao.conectar(); // Cria a conexão aqui
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultado.add(rs.getString("livro") + " - " + rs.getString("autor"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public List<String> getFuncionariosEVendas() {
        List<String> resultado = new ArrayList<>();
        String query = "SELECT f.nome AS funcionario, v.id AS venda_id, v.dataHora AS data_venda " +
                "FROM funcionario f " +
                "JOIN venda v ON f.id = v.funcionario_id";

        try (Connection connection = Conexao.conectar(); // Cria a conexão aqui
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultado.add(rs.getString("funcionario") + " - Venda ID: " + rs.getInt("venda_id") + " - "
                        + rs.getTimestamp("data_venda"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public List<String> getClientesEItensComprados() {
        List<String> resultado = new ArrayList<>();
        String query = "SELECT c.nome AS cliente, l.nome AS livro, iv.quantidadeItem " +
                "FROM venda v " +
                "JOIN cliente c ON v.cliente_id = c.id " +
                "JOIN item_venda iv ON v.id = iv.venda_id " +
                "JOIN livro l ON iv.livro_id = l.id";

        try (Connection connection = Conexao.conectar(); // Cria a conexão aqui
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultado.add(rs.getString("cliente") + " comprou " + rs.getString("livro") + " - Quantidade: "
                        + rs.getInt("quantidadeItem"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    // ------------------- Consultas com GROUP BY e Funções Agregadas
    // -------------------

    public List<String> getTotalLivrosVendidosPorLivro() {
        List<String> resultado = new ArrayList<>();
        String query = "SELECT l.nome AS livro, SUM(iv.quantidadeItem) AS total_vendido " +
                "FROM livro l " +
                "JOIN item_venda iv ON l.id = iv.livro_id " +
                "GROUP BY l.nome";

        try (Connection connection = Conexao.conectar(); // Cria a conexão aqui
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultado.add(rs.getString("livro") + " - Total vendido: " + rs.getInt("total_vendido"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public List<String> getVendasPorFuncionarioComMaisDeCincoItens() {
        List<String> resultado = new ArrayList<>();
        String query = "SELECT f.nome AS funcionario, SUM(iv.quantidadeItem) AS total_vendido " +
                "FROM funcionario f " +
                "JOIN venda v ON f.id = v.funcionario_id " +
                "JOIN item_venda iv ON v.id = iv.venda_id " +
                "GROUP BY f.nome " +
                "HAVING SUM(iv.quantidadeItem) > 5";

        try (Connection connection = Conexao.conectar(); // Cria a conexão aqui
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultado.add(rs.getString("funcionario") + " - Total vendido: " + rs.getInt("total_vendido"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public List<String> getTotalGastoPorCliente() {
        List<String> resultado = new ArrayList<>();
        String query = "SELECT c.nome AS cliente, SUM(p.valor) AS total_gasto " +
                "FROM cliente c " +
                "JOIN venda v ON c.id = v.cliente_id " +
                "JOIN item_venda iv ON v.id = iv.venda_id " +
                "JOIN preco_livro p ON iv.livro_id = p.livro_id " +
                "GROUP BY c.nome " +
                "ORDER BY total_gasto DESC";

        try (Connection connection = Conexao.conectar(); // Cria a conexão aqui
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultado.add(rs.getString("cliente") + " - Total gasto: " + rs.getDouble("total_gasto"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    // ------------------- Consultas com Funções de Data -------------------

    public List<String> getVendasUltimoMes() {
        List<String> resultado = new ArrayList<>();
        String query = "SELECT v.id AS venda_id, v.dataHora AS data_venda " +
                "FROM venda v " +
                "WHERE v.dataHora >= CURDATE() - INTERVAL 1 MONTH";

        try (Connection connection = Conexao.conectar(); // Cria a conexão aqui
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultado.add("Venda ID: " + rs.getInt("venda_id") + " - " + rs.getTimestamp("data_venda"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public List<String> getLivrosCadastradosUltimoAno() {
        List<String> resultado = new ArrayList<>();
        String query = "SELECT l.nome AS livro, l.dataCadastro " +
                "FROM livro l " +
                "WHERE l.dataCadastro >= CURDATE() - INTERVAL 1 YEAR";

        try (Connection connection = Conexao.conectar(); // Cria a conexão aqui
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultado.add(rs.getString("livro") + " - Cadastrado em: " + rs.getTimestamp("dataCadastro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public List<String> getVendasHoje() {
        List<String> resultado = new ArrayList<>();
        String query = "SELECT v.id AS venda_id, v.dataHora AS data_venda " +
                "FROM venda v " +
                "WHERE DATE(v.dataHora) = CURDATE()";

        try (Connection connection = Conexao.conectar(); // Cria a conexão aqui
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultado.add("Venda ID: " + rs.getInt("venda_id") + " - " + rs.getTimestamp("data_venda"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    // ------------------- Consultas Aninhadas -------------------

    public String getClienteQueGastouMais() {
        String resultado = "";
        String query = "SELECT c.nome AS cliente, SUM(iv.quantidadeItem * pl.valor) AS totalGasto " +
                "FROM cliente c " +
                "JOIN venda v ON c.id = v.cliente_id " +
                "JOIN item_venda iv ON v.id = iv.venda_id " +
                "JOIN livro l ON iv.livro_id = l.id " +
                "JOIN preco_livro pl ON l.id = pl.livro_id " +
                "GROUP BY c.id " +
                "ORDER BY totalGasto DESC LIMIT 1";

        try (Connection connection = Conexao.conectar(); // Cria a conexão aqui
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                resultado = rs.getString("cliente") + " - " + rs.getDouble("totalGasto");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public List<String> getTotalGastoPorTodosClientes() {
        List<String> resultados = new ArrayList<>();
        String query = "SELECT c.nome AS cliente, SUM(iv.quantidadeItem * pl.valor) AS totalGasto " +
                "FROM cliente c " +
                "JOIN venda v ON c.id = v.cliente_id " +
                "JOIN item_venda iv ON v.id = iv.venda_id " +
                "JOIN livro l ON iv.livro_id = l.id " +
                "JOIN preco_livro pl ON l.id = pl.livro_id " +
                "GROUP BY c.id " +
                "ORDER BY totalGasto DESC"; // Aqui listamos todos os clientes e seus totais gastos

        try (Connection connection = Conexao.conectar(); // Cria a conexão aqui
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Adiciona a string formatada com o nome do cliente e o total gasto
                resultados.add(rs.getString("cliente") + " - " + rs.getDouble("totalGasto"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    public List<String> getLivrosComQuantidadeInferiorAMedia() {
        List<String> resultado = new ArrayList<>();
        String query = "SELECT nome " +
                "FROM livro " +
                "WHERE quantidade < (SELECT AVG(quantidade) FROM livro)";

        try (Connection connection = Conexao.conectar(); // Cria a conexão aqui
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultado.add(rs.getString("nome"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public List<String> getFuncionariosSemVendas() {
        List<String> resultado = new ArrayList<>();
        String query = "SELECT nome " +
                "FROM funcionario " +
                "WHERE id NOT IN (SELECT funcionario_id FROM venda)";

        try (Connection connection = Conexao.conectar(); // Cria a conexão aqui
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultado.add(rs.getString("nome"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
