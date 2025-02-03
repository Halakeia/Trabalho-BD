package model;

import java.time.LocalDate;

public class cliente {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;

    public cliente(String nome, String cpf, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    // retorno do id
    public int getId() {
        return id;
    }

    // inserção do id
    public void setId(int id) {
        this.id = id;
    }

    // retorno do nome
    public String getNome() {
        return nome;
    }

    // inserção do nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // retorno do cpf
    public String getCpf() {
        return cpf;

    }

    // inserção do cpf
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // retorno do email
    public String getEmail() {
        return email;
    }

    // inserção do email
    public void setEmail(String email) {
        this.email = email;
    }

    // retorno da data de nascimento
    public LocalDate getDataNascimento() {

        return dataNascimento;
    }

    // inserção da data de nascimento
    public void setDataNascimento(LocalDate dataNascimento) {

        this.dataNascimento = dataNascimento;

    }

}
