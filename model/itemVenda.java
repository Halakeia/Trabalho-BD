package model;

public class itemVenda {
    private int livroId;
    private int vendaId;
    private int quantidadeItem;
    private double valorItem;

    // Construtor
    public itemVenda(int livroId, int vendaId, int quantidadeItem, double valorItem) {
        this.livroId = livroId;
        this.vendaId = vendaId;
        this.quantidadeItem = quantidadeItem;
        this.valorItem = valorItem;
    }

    // Getters e Setters
    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    public int getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(int quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

}
