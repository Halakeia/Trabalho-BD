package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import dao.ClienteDAO;
import model.cliente;

public class OpcoesCadastro {
    ClienteDAO clienteDAO = new ClienteDAO();
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

                    cliente cliente = new cliente(nome, cpf, email, data);
                    clienteDAO.inserirCliente(cliente);
                break;

                case 2:
                    //Buscar dados
                    scanner.nextLine();
                    System.out.print("\n-----------------------\n");
                    System.out.println("Buscar:");
                    System.out.print("Digite o cpf do cliente: ");
                    cpf = scanner.nextLine();

                    if ((cliente = clienteDAO.buscarCliente(cpf)) == null) {
                        System.out.println("\nCliente não encontrado!\n");
                        break;
                    }
                    System.out.println("\nResultado da busca pelo cliente:");
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCpf());
                    System.out.println("Email: " + cliente.getEmail());
                    System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
                break;

                case 3:
                    //Editar dados
                    scanner.nextLine();
                    System.out.print("\n-----------------------\n");
                    System.out.println("Alterar:");
                    System.out.print("Digite o cpf do cliente: ");
                    cpf = scanner.nextLine();

                    if ((cliente = clienteDAO.buscarCliente(cpf)) == null) {
                        System.out.println("\nCliente não encontrado!\n");
                        break;
                    }

                    System.out.print("Digite o nome: ");
                    nome =(scanner.nextLine());
                    System.out.print("Digite o email: ");
                    email = (scanner.nextLine());
                    System.out.print("Digite a data de Nascimento: ");
                    dataStr = scanner.nextLine();

                    data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    
                    cliente = new cliente(nome, cpf, email, data);
                    
                    clienteDAO.atualizarCliente(cliente);

                break; 

                case 4:
                    //Excluir dados
                    scanner.nextLine();
                    System.out.print("\n-----------------------\n");
                    System.out.println("Excluir:");
                    System.out.print("Digite o cpf do cliente: ");
                    cpf = scanner.nextLine();

                    if ((cliente = clienteDAO.buscarCliente(cpf)) == null) {
                        System.out.println("\nCliente não encontrado!\n");
                        break;
                    }

                    System.out.print("\nDeseja excluir o cadastro de " + cliente.getNome() + "? (s - confirmar): ");
                    String confirm = scanner.nextLine();
                    System.out.println("Excluir:" + confirm);
                    if ((confirm.equals("s")) || (confirm.equals("S"))) {
                        clienteDAO.deletarCliente(cpf);
                        break;
                    } 

                    System.out.println("\nOpção inválida!");

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
