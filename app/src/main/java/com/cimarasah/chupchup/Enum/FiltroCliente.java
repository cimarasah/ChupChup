package com.cimarasah.chupchup.Enum;

/**
 * Created by c.de.sa.oliveira on 21/06/2018.
 */

public enum FiltroCliente {

    Nome(1),Saldo(2);

    public int opcaoFiltro;
    FiltroCliente(int opcao) {
        opcaoFiltro = opcao;
    }
}
