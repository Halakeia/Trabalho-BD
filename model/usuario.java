package model;

public class usuario {

    private int id;
    private int funcionarioId;
    private String userName;
    private String senha;

    public usuario(int id, int funcionarioId, String userName, String senha) {
        this.id = id;
        this.funcionarioId = funcionarioId;
        this.userName = userName;
        this.senha = senha;

    }

    public usuario(int funcionarioId, String userName, String senha) {
        this.funcionarioId = funcionarioId;
        this.userName = userName;
        this.senha = senha;
    }

    // retorno do id
    public int getid() {
        return id;
    }

    // inserção do id
    public void setid(int id) {
        this.id = id;
    }

    // retorno do nome
    public String getuserName() {
        return userName;
    }

    // inserção do nome
    public void setuserName(String userName) {
        this.userName = userName;

    }

    // retorno da senha
    public String getsenha() {
        return senha;
    }

    // inserção da senha
    public void setsenha(String id) {
        this.senha = id;
    }

    public int getFuncionarioId() {
        return this.funcionarioId;
    }

    // inserção da senha
    public void setFuncionarioId(int id) {
        this.funcionarioId = id;
    }
}
