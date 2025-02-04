package model;

import java.time.LocalDate;

public class preco_livro {
    private int id;
    private int idLivro;
    private LocalDate data;
    private double valor;

    public preco_livro(int id, int idLivro, LocalDate data, double valor) {
        this.id = id;
        this.idLivro = idLivro;
        this.data = data;
        this.valor = valor;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLivro() {
        return this.idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
