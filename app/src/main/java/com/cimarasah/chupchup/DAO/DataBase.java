package com.cimarasah.chupchup.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by c.de.sa.oliveira on 20/06/2018.
 */

public class DataBase extends SQLiteOpenHelper{

    private static final int VERSAO_BANCO = 1;
    private static final String BANCO = "bd_listaNegra";
    private static final String TABELA_CLIENTE = "TB_CLIENTE";
    private static final String COL_CODIGO = "CODIGO";
    private static final String COL_NOME = "NOME";
    private static final String COL_TELEFONE = "TELEFONE";
    private static final String COL_EMAIL = "EMAIL";
    private static final String COL_SALDO = "SALDO";


    public DataBase(Context context) {
        super(context, BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ONCREATE_CLIENTE = "CREATE TABLE "+ TABELA_CLIENTE+" ("
                +COL_CODIGO+ " INTEGER PRIMARY KEY, "
                +COL_NOME + " TEXT, "
                +COL_TELEFONE + " TEXT, "
                +COL_EMAIL + " TEXT, "
                +COL_SALDO + " REAL)";
        db.execSQL(ONCREATE_CLIENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }






}
