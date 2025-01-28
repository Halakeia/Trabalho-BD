package model;

public class usuario {

    private int id;
    private String userName;
    private int senha;

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

    //retorno do nome
    public String getnome() {
        return userName;
    }
    //inserção do nome
    public void setnome(String userName) {
        this.userName = userName;

    }

    //retorno da senha
    public int getsenha()
    {
    return senha;
    }

    //inserção da senha 
    public void setsenha(int senha) 
    {
        this.senha= senha ;
    }

}
