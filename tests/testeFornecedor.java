package tests;
import dao.FornecedoresDAO;
import model.fornecedores;
import java.util.List;

public class testeFornecedor {
    public static void main(String[] args) {
        FornecedoresDAO fornecedoresDAO = new FornecedoresDAO();

        //  Criar um novo fornecedor
        fornecedores fornecedor1 = new fornecedores(0, "Empresa X", "X LTDA", "12345678000100");
        fornecedoresDAO.criarFornecedores(fornecedor1);
        System.out.println("✅ Fornecedor inserido com sucesso");

        //  Listar fornecedores
        List<fornecedores> lista = fornecedoresDAO.listarFornecedores();
        System.out.println("📋 Lista de fornecedores:");
        for (fornecedores f : lista) {
            System.out.println(f.getId() + " - " + f.getRazaoSocial() + " - " + f.getNomeFantasia() + " - " + f.getCnpj());
        }

        //  Atualizar fornecedor
        if (!lista.isEmpty()) {
            fornecedores fornecedorAtualizado = lista.get(0);
            fornecedorAtualizado.setRazaoSocial("Empresa X Atualizada");
            fornecedoresDAO.atualizarFornecedor(fornecedorAtualizado);
            System.out.println("✅ Fornecedor atualizado com sucesso!");
        }

        // Listar novamente para verificar atualização
        lista = fornecedoresDAO.listarFornecedores();
        System.out.println("📋 Lista de fornecedores após atualização:");
        for (fornecedores f : lista) {
            System.out.println(f.getId() + " - " + f.getRazaoSocial() + " - " + f.getNomeFantasia() + " - " + f.getCnpj());
        }

        //  Deletar fornecedor
        if (!lista.isEmpty()) {
            int idParaDeletar = lista.get(0).getId();
            fornecedoresDAO.deletarFornecedor(idParaDeletar);
            System.out.println("✅ Fornecedor deletado com sucesso!");
        }

        //  Listar novamente para verificar remoção
        lista = fornecedoresDAO.listarFornecedores();
        System.out.println("📋 Lista de fornecedores após deleção:");
        for (fornecedores f : lista) {
            System.out.println(f.getId() + " - " + f.getRazaoSocial() + " - " + f.getNomeFantasia() + " - " + f.getCnpj());
        }
    }
}
