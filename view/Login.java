package view;

import dao.*;
import model.*;

import java.util.Scanner;

public class Login {

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        LoginDAO loginDAO = new LoginDAO();
        int opcao;
        do {
            System.out.println();
            System.out.println("Bem-vindo ao Sistema bookflow!\n");
            System.out.println("1 - Login.");
            System.out.println("2 - Encerrar Sistema.");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Solicita username e senha
                    scanner.nextLine();
                    System.out.println("\n------------------------\n");
                    System.out.print("Informe seu Username: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Informe sua senha: ");
                    String senha = scanner.nextLine();

                    // Verifica a autenticação no Banco de Dados com a senha criptografada
                    usuario usuario = loginDAO.autenticar(cpf, senha);

                    if (usuario != null) {
                        System.out.println("\n------------------------\n");
                        System.out.println("Login realizado com sucesso!");
                        System.out.println("Bem-vindo, " + usuario.getuserName());


                        MenuPrincipal.menuSistema(usuario.getid());

                    } else {
                        System.out.println("Username ou senha inválidos!\n");
                    }
                break;
                case 2:
                    System.out.println("Encerrando...");
                    System.out.println("\n------------------------\n");
                break;

                default:
                    System.out.println("Opção inválida!");
                break;
            }
        } while (opcao != 2);
        scanner.close();
    }

    
}
