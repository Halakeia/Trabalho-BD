package model;

public class fornecedor {
    
    private int id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
   
    //Construtor
    public fornecedor (int id,  String razaoSocial, String nomeFantasia, String cnpj) 
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
    public int getId()
    {
    return id;
    }

    //inserção do id
    public void setId(int id) 
    {
        this.id = id;
    }

    //retorno da razão social
    public String getRazaoSocial() {
        return razaoSocial;
    }
    //inserção do razão social
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    //retorno do nome fantasia
    public String getNomeFantasia(){
    return nomeFantasia;

    }
    

    //inserção do nome fantasia
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    //retorno do cnpj
    public String getCnpj() {
        return cnpj;
    }

    //inserção do cnpj
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
}
