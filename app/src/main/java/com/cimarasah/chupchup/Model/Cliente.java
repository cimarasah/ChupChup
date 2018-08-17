package com.cimarasah.chupchup.Model;

import java.util.Date;

/**
 * Created by c.de.sa.oliveira on 20/06/2018.
 */

public class Cliente {

    int id;
    String nome;
    String telefone;
    String email;
    double saldo;
    Date dt_cadastro;


    public Cliente (){}

    public Cliente (String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

}
