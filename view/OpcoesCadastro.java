package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import dao.ClienteDAO;
import model.cliente;

public class OpcoesCadastro {
    ClienteDAO cliente = new ClienteDAO();
    Scanner scanner = new Scanner(System.in);
    public void cadastroCliente(int usuarioID) {
        int opcao;
        do {
            System.out.println("\n-----------------------------\n");
            System.out.println("Clientes: ");
            System.out.println("1 - Inserir");
            System.out.println("2 - Buscar");
            System.out.println("3 - Editar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    //inserir dados
                    scanner.nextLine();
                    System.out.print("\n-----------------------\n");
                    System.out.println("Inserir:");
                    System.out.print("Digite o nome: ");
                    String nome =(scanner.nextLine());
                    System.out.print("Digite o cpf: ");
                    String cpf = (scanner.nextLine());
                    System.out.print("Digite o email: ");
                    String email = (scanner.nextLine());
                    System.out.print("Digite a data de Nascimento: ");
                    String dataStr = scanner.nextLine();

                    LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    cliente novoCliente = new cliente(nome, cpf, email, data);
                    cliente.inserirCliente(novoCliente);
                break;

                case 2:
                    //Buscar dados
                    cliente busca;
                    scanner.nextLine();
                    System.out.print("\n-----------------------\n");
                    System.out.println("Buscar:");
                    System.out.print("Digite o cpf do cliente: ");
                    cpf = scanner.nextLine();
                    System.out.println("CPF: " + cpf);
                    if ((busca = cliente.buscarCliente(cpf)) == null) {
                        System.out.println("\nCliente não encontrado!\n");
                        break;
                    }
                    System.out.println("\nResultado da busca pelo cliente:");
                    System.out.println("Nome: " + busca.getNome());
                    System.out.println("CPF: " + busca.getCpf());
                    System.out.println("Email: " + busca.getEmail());
                    System.out.println("Data de Nascimento: " + busca.getDataNascimento());
                break;

                case 3:
                    //Editar dados
                break; 

                case 4:
                    //Excluir dados
                break; 

                case 5:
                System.out.println("Voltando...");
                break;
        
                default:
                System.out.print("opcao invalida!\n");
                break;
            } 
        } while(opcao != 5);
    }
}
