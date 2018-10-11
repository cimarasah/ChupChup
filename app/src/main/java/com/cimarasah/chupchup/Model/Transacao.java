package com.cimarasah.chupchup.Model;

import com.cimarasah.chupchup.Enum.TipoTransacao;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by c.de.sa.oliveira on 21/08/2018.
 */

public class Transacao {
    private int id;
    private TipoTransacao tipo;
    private Date dt;
    private BigDecimal valor;
    private Cliente cliente;

    public Transacao() {

    }

    public Transacao(int id, TipoTransacao tipo, Date dt, BigDecimal valor, Cliente cliente) {
        this.id = id;
        this.tipo = tipo;
        this.dt = dt;
        this.valor = valor;
        this.cliente = cliente;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
