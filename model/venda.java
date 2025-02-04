package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class venda {
    private int id;
    private LocalDate dataHora;
    private int idCliente;
    private int idFuncionario;

    // retorno do id
    public int getid() {
        return id;
    }

    // inserção do id
    public void setid(int id) {
        this.id = id;
    }

    // retorno da data
    public LocalDate getdata() {
        return dataHora;
    }

    // inserção da data
    public void setdata(LocalDate data) {
        this.dataHora = data;
    }

    public void setIdCliente(int id) {
        this.idCliente = id;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdFuncionario(int id) {
        this.idFuncionario = id;

    }

    public int getIdFuncionario() {
        return this.idFuncionario;
    }

}
