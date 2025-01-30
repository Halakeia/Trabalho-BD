package model;

public class fornecedores {
    
    private int id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
   
    //Construtor
    public fornecedores (int id,  String razaoSocial, String nomeFantasia, String cnpj) 
    {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia= nomeFantasia;
        this.cnpj = cnpj;
        
    }

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
    public String getrazaoSocial() {
        return razaoSocial;
    }
    //inserção do razão social
    public void setrazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    //retorno do nome fantasia
    public String getnomeFantasia(){
    return nomeFantasia;

    }
    

    //inserção do nome fantasia
    public void setnomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    //retorno do cnpj
    public String getcnpj() {
        return cnpj;
    }

    //inserção do cnpj
    public void setcnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
}
