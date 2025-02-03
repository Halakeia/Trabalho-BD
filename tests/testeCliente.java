package tests;

// No momento essa class será para testar os comandos do CRUD 

import java.time.LocalDate;
import java.util.List;
import dao.*;
import model.*;



public class testeCliente {
    public static void main(String[] args) {

            ClienteDAO ClienteDAO = new ClienteDAO();

            //  Inserir cliente
            cliente novocliente = new cliente("João Silva","12345678900","joao@email.com", LocalDate.of(1990, 5, 20));
            ClienteDAO.inserirCliente(novocliente);
            System.out.println("✅ cliente inserido com sucesso!");

            // Listar clientes
            List<cliente> clientes = ClienteDAO.listarClientes();
            System.out.println("📋 Lista de clientes:");
            for (cliente c : clientes) {
                System.out.println(c.getCpf() + " - " + c.getNome() + " - " + c.getEmail() + " - " + c.getDataNascimento());
            }

            //  Atualizar cliente
            novocliente.setNome("João Silva Atualizado");
            ClienteDAO.atualizarCliente(novocliente);
            System.out.println("✅ cliente atualizado com sucesso!");

            //  Listar novamente para verificar atualização
            clientes = ClienteDAO.listarClientes();
            System.out.println("📋 Lista de clientes após atualização:");
            for (cliente c : clientes) {
                System.out.println(c.getCpf() + " - " + c.getNome() + " - " + c.getEmail() + " - " + c.getDataNascimento());
            }

            // 5️ Deletar cliente
            ClienteDAO.deletarCliente("12345678900");
            System.out.println("✅ cliente deletado com sucesso!");

            // 6️ Listar novamente para verificar remoção
            clientes = ClienteDAO.listarClientes();
            System.out.println("📋 Lista de clientes após deleção:");
            for (cliente c : clientes) {
                System.out.println(c.getCpf() + " - " + c.getNome() + " - " + c.getEmail() + " - " + c.getDataNascimento());
            }

    }
}
