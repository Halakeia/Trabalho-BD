package model;

import java.time.LocalDate;

public class venda {
    private int id;
    private LocalDate dataHora;
    private int idCliente;
    private int idFuncionario;
    


    public venda (int idClient, int idFuncionario){
        this.idCliente = idClient;
        this.idFuncionario = idFuncionario;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataHora() {
        return this.dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFuncionario() {
        return this.idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }


    public venda(int id, LocalDate dataHora, int idCliente, int idFuncionario) {
        this.id = id;
        this.dataHora = dataHora;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
    }

   

}
