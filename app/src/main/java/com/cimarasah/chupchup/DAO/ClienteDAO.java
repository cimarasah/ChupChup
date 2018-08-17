package com.cimarasah.chupchup.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cimarasah.chupchup.Enum.FiltroCliente;
import com.cimarasah.chupchup.Model.Cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by c.de.sa.oliveira on 20/06/2018.
 */

public class ClienteDAO extends DataBase{

    private static final String TABELA_CLIENTE = "TB_CLIENTE";
    private static final String COL_ID = "ID";
    private static final String COL_NOME = "NOME";
    private static final String COL_TELEFONE = "TELEFONE";
    private static final String COL_EMAIL = "EMAIL";
    private static final String COL_SALDO = "SALDO";
    private static final String COL_DT_CADASTRO = "DT_CADASTRO";

    public ClienteDAO(Context context) {
        super(context);
    }

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    public void inserirCliente(Cliente cliente){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NOME,cliente.getNome());
        values.put(COL_EMAIL,cliente.getEmail());
        values.put(COL_TELEFONE,cliente.getTelefone());
        values.put(COL_SALDO,cliente.getSaldo());
        values.put(COL_DT_CADASTRO, String.valueOf(new Date()));

        db.insert(TABELA_CLIENTE, null, values);
        db.close();

    }

    public void deletarCliente(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABELA_CLIENTE, COL_ID + " = ? ", new String[] {String.valueOf(id)});

        db.close();

    }

    public Cliente buscarCliente (int id) throws ParseException {

        SQLiteDatabase db = this.getReadableDatabase();



        Cursor cursor = db.query(TABELA_CLIENTE,
                new String[] {COL_ID, COL_NOME, COL_TELEFONE, COL_EMAIL, COL_SALDO, COL_DT_CADASTRO},
                COL_ID + " = ?",
                new String[] {String.valueOf(id)},
                null, null,null,null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(cursor.getString(0)));
        cliente.setNome(cursor.getString(1));
        cliente.setTelefone(cursor.getString(2));
        cliente.setEmail(cursor.getString(3));
        cliente.setSaldo(Double.parseDouble(cursor.getString(4)));
        cliente.setDt_cadastro(formato.parse(cursor.getString(3)));

        return cliente;

    }

    public void alterarCliente(Cliente cliente){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NOME,cliente.getNome());
        values.put(COL_TELEFONE,cliente.getTelefone());
        values.put(COL_EMAIL,cliente.getEmail());
        values.put(COL_SALDO,cliente.getSaldo());

        db.update(TABELA_CLIENTE,  values, COL_ID +" = ? ",new String[] {String.valueOf(cliente.getId())} );
        db.close();

    }

    public ArrayList<Cliente> listarCliente ( FiltroCliente opcaoFiltro) throws ParseException {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ");
        query.append(TABELA_CLIENTE);
       // query.append(" ORDER BY ");
        query.append(";");

        Cursor cursor = db.rawQuery(query.toString(), null);

        if(cursor.moveToFirst()){
            do{
                Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(cursor.getString(0)));
                cliente.setNome(cursor.getString(1));
                cliente.setTelefone(cursor.getString(2));
                cliente.setEmail(cursor.getString(3));
                cliente.setSaldo(Double.parseDouble(cursor.getString(4)));
                cliente.setDt_cadastro(formato.parse(cursor.getString(3)));
                clientes.add(cliente);
            }while (cursor.moveToNext());
        }

        return clientes;

    }
}
