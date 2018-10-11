package com.cimarasah.chupchup.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cimarasah.chupchup.Business.Impl.ClienteBusinessImpl;
import com.cimarasah.chupchup.Business.Interface.IClienteBusiness;
import com.cimarasah.chupchup.Model.Cliente;
import com.cimarasah.chupchup.R;
import com.santalu.widget.MaskEditText;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientEditActivity extends AppCompatActivity {

    Button btnLimpar,btnCancelar, btnSalvar;
    IClienteBusiness business;
    EditText etNome, etEmail;
    MaskEditText etTelefone;
    Intent intent;
    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_edit);

        etTelefone = (MaskEditText)findViewById(R.id.client_phone);
        btnSalvar = (Button) findViewById(R.id.btnSaveClient);
        etNome = (EditText)findViewById(R.id.client_name);
        etEmail = (EditText)findViewById(R.id.client_email);
        business = new ClienteBusinessImpl(ClientEditActivity.this);

        btnSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cliente = new Cliente();
                cliente.setNome(etNome.getText().toString());
                cliente.setEmail(etEmail.getText().toString());
                cliente.setTelefone(etTelefone.getRawText());
                cliente.setDt_cadastro(new Date());
                cliente.setSaldo(BigDecimal.valueOf(0));
                business.inserirCliente(cliente);
                intent = new Intent(ClientEditActivity.this, ClientActivity.class);
                startActivity(intent);

            }
        });



    }

}
