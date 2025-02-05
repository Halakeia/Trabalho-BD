package view;

import dao.*;
import java.util.Scanner;


public class MenuCadastros {
    ClienteDAO cliente = new ClienteDAO();
    OpcoesCadastro opcoes = new OpcoesCadastro();
    Scanner scanner = new Scanner(System.in);

    public void menuCadastros(int usuarioID) {
        int opcao;
        do {
            System.out.println("\n-----------------------------\n");
            System.out.println("Menu Cadastro: ");
            System.out.println("1 - Cliente");
            System.out.println("2 - Voltar");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                opcoes.cadastroCliente(usuarioID);
                break;
                
                case 2:
                    System.out.println("Retornando...");
                break;
                    
                default:
                    System.out.println("Opção Inválida...");
                    break;
            }

        } while (opcao != 2);
    }

    


}
