package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class venda {
    private int id;
    private LocalDate data;
    private LocalTime hora;
    private double valor;
    private cliente cliente;//Representa o relacionamento com a tabela usuario 
    private usuario usuario;//Representa o relacionamento com a tabela usuario
    

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

    //retorno da data
    public LocalDate getdata() {
        return data;
    }
    
    //inserção da data
    public void setdata(LocalDate data) {
        this.data= data;
    }

    //retorno da hora 
    public LocalTime gethora(){
    return hora;

    }

    //inserção da hora
    public void sethora(LocalTime hora) {
        this.hora = hora;
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

    //retorno da fk do cliente
    public cliente getcliente(){
        return cliente;
    }
    
    //retorno da fk do cliente
    public void setcliente(cliente cliente){
        this.cliente= cliente;

    } 

    //retorno da fk do cliente
    public usuario getusuario(){
        return usuario;
    }
    //retorno da fk do cliente
    public void setusuario(usuario usuario){
        this.usuario= usuario;

    } 
      

    



}
