package tests;

import model.itemVenda;
import java.util.List;

import dao.itemVendaDAO;

public class testeItemVenda {

    public static void main(String[] args) {
        // Criando uma instância do itemVendaDAO
        itemVendaDAO itemVendaDAO = new itemVendaDAO();

        // Testando o método inserirItemVenda
        itemVenda novoItem = new itemVenda(1, 1, 2, 150.0);  // livroId, vendaId, quantidadeItem, valorItem
        itemVendaDAO.inserirItemVenda(novoItem);
        System.out.println("Item de venda inserido com sucesso!");

        // Testando o método listarItensVenda
        System.out.println("Listando todos os itens de venda:");
        List<itemVenda> itens = itemVendaDAO.listarItensVenda();
        for (itemVenda item : itens) {
            System.out.println("Livro ID: " + item.getLivroId() +
                               ", Venda ID: " + item.getVendaId() +
                               ", Quantidade: " + item.getQuantidadeItem() +
                               ", Valor: " + item.getValorItem());
        }

        // Testando o método atualizarItemVenda
        novoItem.setQuantidadeItem(3);
        novoItem.setValorItem(180.0);
        itemVendaDAO.atualizarItemVenda(novoItem);
        System.out.println("Item de venda atualizado com sucesso!");

        // Testando o método deletarItemVenda
        itemVendaDAO.deletarItemVenda(1, 1);  // livroId, vendaId
        System.out.println("Item de venda deletado com sucesso!");
    }
}
