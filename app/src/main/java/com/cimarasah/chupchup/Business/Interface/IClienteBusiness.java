package com.cimarasah.chupchup.Business.Interface;

import com.cimarasah.chupchup.Enum.FiltroCliente;
import com.cimarasah.chupchup.Model.Cliente;

import java.util.ArrayList;

/**
 * Created by c.de.sa.oliveira on 06/08/2018.
 */

public interface IClienteBusiness {

    void inserirCliente(Cliente cliente);
    void deletarCliente(int id);
    Cliente buscarCliente(int id);
    void alterarCliente(Cliente cliente);
    ArrayList<Cliente> listarCliente(FiltroCliente opcaoFiltro);
}
