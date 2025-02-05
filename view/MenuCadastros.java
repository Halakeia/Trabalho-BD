package view;

import dao.*;
import model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class MenuCadastros {
    ClienteDAO cliente = new ClienteDAO();
    OpcoesCadastro opcoes = new OpcoesCadastro();
    Scanner scanner = new Scanner(System.in);

    public void menuCadastros(int usuarioID) {
        int opcao;
        do {
            System.out.println("\n-----------------------------\n");
            System.out.println("Selecione o tipo de cadastro: ");
            System.out.println("1 - Usuário");
            System.out.println("2 - Cliente");
            System.out.println("3 - Livro");
            System.out.println("4 - Voltar");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    //cadastro de usuário
                break;

                case 2:
                opcoes.cadastroCliente(usuarioID);
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

    


}
