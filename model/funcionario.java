package model;

public class funcionario {
    private int id;
    private int idCargo;
    private String cpf;
    private String nome;
    private double salario;


    public funcionario(int id, int idCargo, String cpf, String nome, double salario) {
        this.id = id;
        this.idCargo = idCargo;
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
    }

    public funcionario(int idCargo, String cpf, String nome, double salario) {
        this.idCargo = idCargo;
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCargo() {
        return this.idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
