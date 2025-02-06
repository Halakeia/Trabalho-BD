package view;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.*;
import dao.*;

public class VendaLivro {
    Scanner scanner = new Scanner(System.in);
    VendaDAO vendaDAO = new VendaDAO();
    LivroDAO livroDAO = new LivroDAO();
    itemVendaDAO itemVendaDAO = new itemVendaDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    // Método para adicionar uma venda e os itens de venda
    public void realizarVenda(int usuarioID){
        livro livro = new livro();
        System.out.println("\n------------------------\n");
        System.out.println("Realizar Venda:");
        System.out.println("Informe o nome do Cliente: ");
        String nome = scanner.nextLine();
        int clienteId = clienteDAO.buscarClienteId(nome);
        if (clienteId == -1) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        // Criar a venda
        venda venda = new venda(clienteId, usuarioID);
        vendaDAO.inserirVenda(venda);
        // System.out.println("Venda criada com sucesso. ID: " + vendaId);

        // Adicionar itens à venda
        List<itemVenda> itens = new ArrayList<>();
        while (true) {
            System.out.print("Digite o nome do livro que o cliente escolheu (ou digite 'finalizar' para encerrar): ");
            String nomeLivro = scanner.nextLine();
            
            // Verifica se o usuário quer finalizar
            if (nomeLivro.equalsIgnoreCase("finalizar")) {
                break;
            }

            System.out.print("Digite a quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de nova linha

            // Verificar se o livro existe
            
            if ((livro = livroDAO.buscarLivros(nomeLivro)) == null) {
                System.out.println("Livro não encontrado, tente novamente.");
                continue;
            }

            // Adiciona o item à lista
            itens.add(new itemVenda(livro.getid(), venda.getId(), quantidade));
        }


        // Inserir os itens da venda
        for (itemVenda item : itens) {
            itemVendaDAO.inserirItemVenda(item);
        }

        System.out.println("\nVenda finalizada!");
    }

}
