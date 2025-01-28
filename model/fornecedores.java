package model;

public class fornecedores {
    
    private int id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
   
    

// criar os Getters e os  Setters
//Getters = - retornam os dados 
// Setters = - colocam os dados
 
    //retorno do id
    public int getid()
    {
    return id;
    }

    //inserção do id
    public void setid(int id) 
    {
        this.id = id;
    }

    //retorno da razão social
    public String getnome() {
        return razaoSocial;
    }
    //inserção do razão social
    public void setnome(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    //retorno do nome fantasia
    public String getnomeFantaisa(){
    return nomeFantasia;

    }

    //inserção do nome fantasia
    public void setcpf(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    //retorno do cnpj
    public String getcnpj() {
        return cnpj;
    }

    //inserção do cnpj
    public void setEmail(String cnpj) {
        this.cnpj = cnpj;
    }

    
}
