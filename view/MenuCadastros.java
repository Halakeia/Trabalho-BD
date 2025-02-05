package view;

import dao.*;
import model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class MenuCadastros {
    Scanner scanner = new Scanner(System.in);
    ClienteDAO cliente = new ClienteDAO();
    public void menuCadastros(int usuarioID) {
        int opcao;
        do {
            System.out.println("\n-----------------------------\n");
            System.out.println("Selecione o tipo de cadastro: ");
            System.out.println("1 - Usuário");
            System.out.println("2 - Cliente");
            System.out.println("3 - Livro");
            System.out.println("4 - Voltar");

            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    //cadastro de usuário
                break;

                case 2:
                System.out.println("\n-----------------------------\n");
                System.out.println("Clientes: ");
                opcoesCliente(usuarioID);
                break;

                case 3:
                    //cadastro de livro
                break;
                
                case 4:
                    System.out.println("Retornando...");
                break;
            
                default:
                    break;
            }

        } while (opcao != 4);
    }

    public void opcoesCliente(int usuarioID) {
        int opcao;
        do {
            System.out.println("1 - Inserir");
            System.out.println("2 - Buscar");
            System.out.println("3 - Editar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Voltar");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    //inserir dados
                    
                    scanner.nextLine();
                    System.out.print("\n-----------------------\n");
                    System.out.print("Dados do cliente:\n");
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

                    //exemplo

                    
                break;

                case 2:
                    //Buscar dados
                break;

                case 3:
                    //Editar dados
                break; 

                case 4:
                    //Excluir dados
                break; 
        
                default:
                System.out.print("opcao invalida!\n");
                break;
            } 
        } while(opcao != 5);
    }


}
