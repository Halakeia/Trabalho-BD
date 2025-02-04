package model;

public class itemVenda {
    private int id;
    private int vendaId;
    private int livroId;
    private int quantidadeItem;


    // Construtor
    public itemVenda(int id, int livroId, int vendaId, int quantidadeItem) {
        this.id=id;
        this.livroId = livroId;
        this.vendaId = vendaId;
        this.quantidadeItem = quantidadeItem;

    }

    // Getters e Setters
    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }
    public int getId() {
        return livroId;
    }

    public void setId(int id) {
        this.id = id;
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


}
