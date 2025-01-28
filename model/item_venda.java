package model;

public class item_venda {
    
    private livros livros;
    private venda venda;
    private int quantidadeItem;
    private double valorItem;

    public livros getlivros(){
        return livros;
    }

    public void setlivros( livros livros){
        this.livros = livros;
    }

    public venda getvenda(){
        return venda;
    }

    public void setvenda( venda venda){
        this.venda = venda;
    }

    public int getquantidadeItem(){
        return quantidadeItem;
    }

    public void setquantidadeItem( int quantidadeItem){
        this.quantidadeItem = quantidadeItem;
    }
    
    public double getvalorItem(){
        return valorItem;
    }

    public void setvalorItem( double valorItem){
        this.valorItem = valorItem;
    }
    




}
