package com.cimarasah.chupchup.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.cimarasah.chupchup.Adapter.ClientRecyclerViewAdapter;
import com.cimarasah.chupchup.Business.Impl.ClienteBusinessImpl;
import com.cimarasah.chupchup.Business.Interface.IClienteBusiness;
import com.cimarasah.chupchup.Enum.FiltroCliente;
import com.cimarasah.chupchup.Model.Cliente;
import com.cimarasah.chupchup.R;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClientActivity extends AppCompatActivity {
    View v;


    private ClientRecyclerViewAdapter mAdapter;
    private RecyclerView myRecyclerView;
    private List<Cliente> lstCliente;
    private static final String TAG = "ClientActivity";
    private ImageButton addClient;
    IClienteBusiness business;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        business = new ClienteBusinessImpl(ClientActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);

        addClient = findViewById(R.id.id_add_client);
        Log.d(TAG,"OnCreate: Started");
        setupRecycler();
        addClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClientActivity.this, ClientEditActivity.class);
                startActivity(intent);
            }
        });

    }




    private void setupRecycler() {

        lstCliente = business.listarCliente(FiltroCliente.Nome);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView = findViewById(R.id.client_recyclerview);
        myRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ClientRecyclerViewAdapter(this,lstCliente);
        myRecyclerView.setAdapter(mAdapter);
        myRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }


    private List<Cliente> mockCliente() {
        ArrayList<Cliente> list = new ArrayList<Cliente>();

        Cliente cli = new Cliente();
        cli.setId(1);
        cli.setNome("Cimara");
        cli.setSaldo(BigDecimal.valueOf(12.00));
        cli.setTaDevendo(true);
        list.add(cli);
        cli = new Cliente();
        cli.setId(2);
        cli.setNome("Carla");
        cli.setSaldo(BigDecimal.valueOf(24.00));
        cli.setTaDevendo(false);
        list.add(cli);

        return list;
    }
}
