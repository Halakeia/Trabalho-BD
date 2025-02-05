package model;

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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFornecedorId() {
        return this.fornecedorId;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public int getEditoraId() {
        return this.editoraId;
    }

    public void setEditoraId(int editoraId) {
        this.editoraId = editoraId;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

}
