package model;

import java.time.LocalDate;

public class livros {
    private int id;
    private String nome;
    private String nomeAutor;
    private String nomeEditora;
    private double valor;
    private int quantidade;
    private String descricao;
    private LocalDate dataCadastro;
    private fornecedores fornecedores; //Representa o relacionamento com a tabela fornecedores
    

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

    //retorno do nome do Autor 
    public String getnomeAutor(){
    return nomeAutor;

    }

    //inserção do nome do Autor 
    public void setnomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    //retorno do nome da Editora
    public String getnomeEditora() {
        return nomeEditora;
    }

    //inserção do nome da Editora
    public void setnomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    //retorno do valor 
    public double getvalor()
    {
        return valor;
    }

    //inserção do valor
    public void setvalor(double valor)
    {
        this.valor = valor;
    }

    //retorno da quantidade
    public int getquantidade(){
        return quantidade;
    }
    
    //inserção da quantidade
    public void setquantidade(int quantidade){
        this.quantidade = quantidade;

    }
    
    //retorno da quantidade
    public String descricao(){
        return descricao;

    }
    
    //inserção da  descrição
    public void setdescricao(String descricao){
        this.descricao = descricao;

    }

    //retorno da fk do fornecedor 
    public fornecedores getfornecedores(){
        return fornecedores;
    }
    //retorno da fk do fornecedor 
    public void setfornecedores(fornecedores fornecedores){
        this.fornecedores= fornecedores;

    }   

    //retorno da data de cadastro 
    public LocalDate getdataCadastro(){

        return dataCadastro;
    }

    //inserção da data de cadastro
    public void setdataCadastro(LocalDate dataCadatro){

        this.dataCadastro= dataCadatro;
        
    }

}
