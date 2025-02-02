// No momento essa class será para testar os comandos do CRUD 

import java.util.List;
import dao.*;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar");
            System.out.println("2. Realizar Venda");
            System.out.println("3. Relatório");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {

                case 1:
                    // pergunta se vai cadastrar cliente ou produto e chama o método
                    break;
                case 2:
                    // Chamar o método para realizar venda
                    break;
                case 3:
                    // Chamar o método para mostrar relatório
                    break;
                case 4:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
