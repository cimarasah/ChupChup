package com.cimarasah.chupchup.Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by c.de.sa.oliveira on 20/06/2018.
 */

public class Cliente {

    int id;
    String nome;
    String telefone;
    String email;
    BigDecimal saldo;
    boolean taDevendo;



    Date dt_cadastro;


    public Cliente (){}

    public Cliente(int id, String nome, BigDecimal saldo, boolean taDevendo) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
        this.dt_cadastro = new Date();
    }

    public Cliente (String nome, BigDecimal saldo){
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public boolean isTaDevendo() {

        if(BigDecimal.valueOf(0).compareTo(this.saldo)==1){
            return true;
        }else{
            return false;
        }

    }



}
