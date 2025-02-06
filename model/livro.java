package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class livro {
    private int id;
    private int fornecedorId;
    private int editoraId;
    private String nome;
    private int quantidade;
    private LocalDateTime dataCadastro;
    private String descricao;

    

    
    public livro(int id, int fornecedorId, int editoraId, String nome, int quantidade, LocalDateTime dataCadastro, String descricao) {
        this.id = id;
        this.fornecedorId = fornecedorId;
        this.editoraId = editoraId;
        this.nome = nome;
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
        this.descricao = descricao;
    }

    public livro(){
        
    }
    

// criar os Getters e os  Setters
//Getters = - retornam os dados 
// Setters = - colocam os dados
 
    public livro(int int1, String string, String string2, String string3, double double1, int int2,
            LocalDate localDate, int int3, int int4) {
    }
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

    //retorno da quantidade
    public int getquantidade(){
        return quantidade;
    }
    
    //inserção da quantidade
    public void setquantidade(int quantidade){
        this.quantidade = quantidade;

    }
    
    //retorno da quantidade
    public String getdescricao(){
        return descricao;

    }
    
    //inserção da  descrição
    public void setdescricao(String descricao){
        this.descricao = descricao;

    }

    //retorno da fk do fornecedor 
    public int getfornecedorId(){
        return fornecedorId;
    }
    //retorno da fk do fornecedor 
    public void setfornecedorID(int fornecedor_id){
        this.fornecedorId= fornecedor_id;

    }   

    //retorno da data de cadastro 
    public LocalDateTime getdataCadastro(){

        return dataCadastro;
    }

    //inserção da data de cadastro
    public void setdataCadastro(LocalDateTime dataCadatro){

        this.dataCadastro= dataCadatro;
        
    }

    public int geteditoraId (){
        return editoraId;

    }
    public void seteditora(int editora_id){
        this.editoraId= editora_id;
    }

}
