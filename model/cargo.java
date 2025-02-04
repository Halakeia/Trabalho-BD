package model;

public class cargo {
    private int id;
    private String descricao;
    private String nomeCargo;

    public cargo(int id, String descricao, String nomeCargo) {
        this.id = id;
        this.descricao = descricao;
        this.nomeCargo = nomeCargo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeCargo() {
        return this.nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }
    
}
