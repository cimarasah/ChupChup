package com.cimarasah.chupchup.Business.Impl;

import android.content.Context;

import com.cimarasah.chupchup.DAO.ClienteDAO;
import com.cimarasah.chupchup.Enum.FiltroCliente;
import com.cimarasah.chupchup.Model.Cliente;
import com.cimarasah.chupchup.Business.Interface.IClienteBusiness;

import java.util.ArrayList;

/**
 * Created by c.de.sa.oliveira on 06/08/2018.
 */

public class ClienteBusinessImpl implements IClienteBusiness {


    ClienteDAO clienteDAO;

    public ClienteBusinessImpl(Context context) {
        clienteDAO = new ClienteDAO(context);
    }

    @Override
    public void inserirCliente(Cliente cliente) {
        try {
            clienteDAO.inserirCliente(cliente);
        } catch (Exception ex) {
            //tratar
        }
    }

    @Override
    public void deletarCliente(int id) {
        try {
            clienteDAO.deletarCliente(id);
        } catch (Exception ex) {
            //tratar
        }
    }

    @Override
    public Cliente buscarCliente(int id) {
        try {
            return clienteDAO.buscarCliente(id);
        } catch (Exception ex) {
            //tratar
        }
        return null;
    }

    @Override
    public void alterarCliente(Cliente cliente) {
        try {
            clienteDAO.alterarCliente(cliente);
        } catch (Exception ex) {
            //tratar
        }
    }

    @Override
    public ArrayList<Cliente> listarCliente(FiltroCliente opcaoFiltro) {

        try {
            return clienteDAO.listarCliente(opcaoFiltro);
        } catch (Exception ex) {
            //tratar
        }

        return null;
    }

}
