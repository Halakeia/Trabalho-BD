 package view;

import model.*;
import java.util.Scanner;

public class MenuPrincipal {

    public static void menuSistema(int usuarioID) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        MenuCadastros cadastros = new MenuCadastros();
        Relatorios relatorios = new Relatorios(); // Instanciando a classe de relatórios
        int opcao;
        while (continuar) {
            System.out.println("\n------------------------\n");
            System.out.println("Menu Bookflow:");
            System.out.println("1. Cadastros");
            System.out.println("2. Realizar Venda");
            System.out.println("3. Relatório");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {

                case 1:
                    cadastros.menuCadastros(usuarioID);
                    break;
                case 2:
                    // Chamar o método para realizar venda
                    break;
                case 3:
                    // Chamar o método de relatórios
                    relatorios.relatorio(); // Corrigido para chamar o método correto
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo...");
                    System.out.println("\n------------------------\n");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
