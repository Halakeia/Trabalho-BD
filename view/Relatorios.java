package view;

import dao.Consultas;
import java.util.List;
import java.util.Scanner;

public class Relatorios {

    public  static void relatorio() {
        Consultas consultas = new Consultas();
        Scanner scanner = new Scanner(System.in);

        // Exibindo as opções
        System.out.println("Escolha sua Consulta:");
        System.out.println("1: Livros e seus Autores");
        System.out.println("2: Funcionários e Vendas");
        System.out.println("3: Clientes e Itens Comprados");
        System.out.println("4: Total de Livros Vendidos por Livro");
        System.out.println("5: Funcionários que Venderam Mais de 5 Itens");
        System.out.println("6: Total Gasto por Cliente");
        System.out.println("7: Vendas no Último Mês");
        System.out.println("8: Livros Cadastrados no Último Ano");
        System.out.println("9: Vendas de Hoje");
        System.out.println("10: Cliente que Gastou Mais");
        System.out.println("11: Livros com Quantidade Inferior à Média");
        System.out.println("12: Funcionários Sem Vendas");

        // Solicitar escolha do usuário
        int escolha = scanner.nextInt();

        // Executando a consulta escolhida
        switch (escolha) {
            case 1:
                System.out.println("\n--- Livros e seus Autores ---");
                List<String> livrosEAutores = consultas.getLivrosEAutores();
                for (String livro : livrosEAutores) {
                    System.out.println(livro);
                }
                break;
            case 2:
                System.out.println("\n--- Funcionários e Vendas ---");
                List<String> funcionariosEVendas = consultas.getFuncionariosEVendas();
                for (String funcionario : funcionariosEVendas) {
                    System.out.println(funcionario);
                }
                break;
            case 3:
                System.out.println("\n--- Clientes e Itens Comprados ---");
                List<String> clientesEItens = consultas.getClientesEItensComprados();
                for (String cliente : clientesEItens) {
                    System.out.println(cliente);
                }
                break;
            case 4:
                System.out.println("\n--- Total de Livros Vendidos por Livro ---");
                List<String> totalLivrosVendidos = consultas.getTotalLivrosVendidosPorLivro();
                for (String livro : totalLivrosVendidos) {
                    System.out.println(livro);
                }
                break;
            case 5:
                System.out.println("\n--- Funcionários que Venderam Mais de 5 Itens ---");
                List<String> funcionariosComMaisDeCincoItens = consultas.getVendasPorFuncionarioComMaisDeCincoItens();
                for (String funcionario : funcionariosComMaisDeCincoItens) {
                    System.out.println(funcionario);
                }
                break;
            case 6:
                System.out.println("\n--- Total Gasto por Cliente ---");
                List<String> totalGastoPorCliente = consultas.getTotalGastoPorCliente();
                for (String gasto : totalGastoPorCliente) {
                    System.out.println(gasto);
                }
                break;
            case 7:
                System.out.println("\n--- Vendas no Último Mês ---");
                List<String> vendasUltimoMes = consultas.getVendasUltimoMes();
                for (String venda : vendasUltimoMes) {
                    System.out.println(venda);
                }
                break;
            case 8:
                System.out.println("\n--- Livros Cadastrados no Último Ano ---");
                List<String> livrosCadastradosUltimoAno = consultas.getLivrosCadastradosUltimoAno();
                for (String livro : livrosCadastradosUltimoAno) {
                    System.out.println(livro);
                }
                break;
            case 9:
                System.out.println("\n--- Vendas de Hoje ---");
                List<String> vendasHoje = consultas.getVendasHoje();
                for (String venda : vendasHoje) {
                    System.out.println(venda);
                }
                break;
            case 10:
                System.out.println("\n--- Cliente que Gastou Mais ---");
                System.out.println(consultas.getClienteQueGastouMais());
                break;
            case 11:
                System.out.println("\n--- Livros com Quantidade Inferior à Média ---");
                List<String> livrosComQuantidadeInferiorAMedia = consultas.getLivrosComQuantidadeInferiorAMedia();
                for (String livro : livrosComQuantidadeInferiorAMedia) {
                    System.out.println(livro);
                }
                break;
            case 12:
                System.out.println("\n--- Funcionários Sem Vendas ---");
                List<String> funcionariosSemVendas = consultas.getFuncionariosSemVendas();
                for (String funcionario : funcionariosSemVendas) {
                    System.out.println(funcionario);
                }
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma consulta válida.");
        }

    
    }
}
