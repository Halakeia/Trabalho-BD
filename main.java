// No momento essa class será para testar os comandos do CRUD 

import java.util.List;
import dao.Fornecedores;
import model.fornecedores;
import dao.Usuario;
import model.usuario;



public class Main {
    
/*   public static void main(String[] args) {




        
        Fornecedores fornecedorDAO = new Fornecedores(); //Criando uma nova instancia para dizer, que vou usar o obejto no codigo

        // Criar usuários
        fornecedores fornecedor1 = new fornecedores(0, "Joana Paula", "Grupo Editorial Record", "44276105000143");
        fornecedorDAO.criar_Forncedores(fornecedor1);

        // Listar usuários
        List<fornecedores> fornecedores = fornecedorDAO.listar_Fornecedores();
        
        System.out.println("Lista de Usuários:");
        for (fornecedores u : fornecedores) {
            System.out.printf("ID: " + u.getid() + " | RAZAO SOCIAL: " + u.getrazaoSocial() + " | NOME FANTASIA: " + u.getnomeFantasia(), "|CNPJ "+ u.getcnpj());
        }

        // Atualizar usuário
        if (!fornecedores.isEmpty()) {
            
            fornecedores fornecedor = fornecedores.get(0);// estou procurando o fornecedor com o ID 0

            fornecedor1.setnomeFantasia("Patricia Martins");// chamando a função que atualiza o dado "nomefantasia"            
            fornecedorDAO.atualizar_Fornecedor(fornecedor1);
        }

        // Deletar usuário
        if (!fornecedores.isEmpty()) {
            fornecedorDAO.deletar_Fornecedor(fornecedores.get(0).getid());
        }
    
    }
*/


public static void main(String[] args) {

        
    Usuario usuarioDAO = new Usuario(); //Criando uma nova instancia para dizer, que vou usar o obejto no codigo

    // // Criar usuários
    // usuario usuario1 = new usuario( "Augusto", 1512);
    // usuarioDAO.criar_Usuario(usuario1);

    // Listar usuários
    List<usuario> usuario = usuarioDAO.listar_Usuario();
    
    System.out.println("Lista de Usuários:");
    for (usuario u : usuario) {
    
        System.out.printf("ID: " + u.getid() + " | NOME DO ADM: " + u.getuserName() + " | SENHA: " + u.getsenha());
        System.out.println("");
    }

    // Atualizar usuário
    // if (!usuario.isEmpty()) {
        
    //     usuario usu = usuario.get(0);// estou procurando o usuario com o ID 0

    //     usu.setuserName("Alberto");// chamando a função que atualiza o dado "nomefantasia"            
    //     usuarioDAO.atualizar_Usuario(usu);
    // }

    // System.out.println("Lista de Usuários:");
    // for (usuario u : usuario) {
    //     System.out.printf("ID: " + u.getid() + " | NOME DO ADM: " + u.getuserName() + " | SENHA: " + u.getsenha());
    // }

    // Deletar usuário
    // if (!usuario.isEmpty()) {
    //     usuarioDAO.deletar_Usuario(usuario.get(0).getid());
    // }
    

}
}
