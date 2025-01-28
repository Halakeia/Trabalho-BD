package model;

public class cliente {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String dataNascimento;
    

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
        return nome;
    }
    //inserção do nome
    public void setnome(String nome) {
        this.nome = nome;
    }

    //retorno do cpf 
    public String getcpf(){
    return cpf;

    }

    //inserção do cpf
    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    //retorno do email
    public String getEmail() {
        return email;
    }

    //inserção do email
    public void setEmail(String email) {
        this.email = email;
    }

    //retorno da data de nascimento
    public String getdataNascimento()
    {


        return dataNascimento;
    }

    //inserção da data de nascimento
    public void setdataNascimento(String dataNascimento)
    {

        this.dataNascimento = dataNascimento;
        
    }

}






