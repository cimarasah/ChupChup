package com.cimarasah.chupchup.Enum;

/**
 * Created by c.de.sa.oliveira on 21/08/2018.
 */

public enum TipoTransacao {
    DEBITO(1),
    CREDITO(2);

    public int tipo;
    TipoTransacao(int tipo) {
        tipo = tipo;
    }


}
