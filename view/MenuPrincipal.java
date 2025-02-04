package view;

// No momento essa class será para testar os comandos do CRUD 



import java.util.Scanner;

public class MenuPrincipal {
    public static void menuSistema() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        MenuCadastros menu = new MenuCadastros();
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
                    menu.menuCadastros();
                    break;
                case 2:
                    // Chamar o método para realizar venda
                    break;
                case 3:
                    // Chamar o método para mostrar relatório
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