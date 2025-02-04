package model;

import java.time.LocalDate;

public class autor {
    private int id;
    private LocalDate dataNascimento;
    private String nome;

    public autor(int id, LocalDate dataNascimento, String nome) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
