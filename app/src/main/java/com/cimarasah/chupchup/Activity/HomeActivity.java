package com.cimarasah.chupchup.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.cimarasah.chupchup.Adapter.HomeViewPagerAdapter;
import com.cimarasah.chupchup.Fragment.CreditFragment;
import com.cimarasah.chupchup.Fragment.DailyFregment;
import com.cimarasah.chupchup.Fragment.DebitFragment;
import com.cimarasah.chupchup.Model.Cliente;
import com.cimarasah.chupchup.R;

import java.math.BigDecimal;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private HomeViewPagerAdapter adapter;

    FloatingActionButton fab_add, fab_shopp, fab_client;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    boolean isOpen = false;
    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Log.d(TAG,"OnCreate: Started");


//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        setFloatingActionButton();

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        adapter = new HomeViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new DailyFregment(), "Diário");
        adapter.AddFragment(new DebitFragment(), "Débito");
        adapter.AddFragment(new CreditFragment(), "Crédito");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



     //  ListView mBlackListView = findViewById(R.id.listViewDeb);


         ArrayList<Cliente> listaClientes;
        listaClientes =  mockClienteDeb();
        //listaClientes = clienteDAO.listarCliente(FiltroCliente.Nome);


    }

    private ArrayList<Cliente> mockClienteDeb(){
        ArrayList<Cliente> list= new ArrayList<Cliente>();

        Cliente cli = new Cliente();
        cli.setId(1);
        cli.setNome("Cimara");
        cli.setSaldo(BigDecimal.valueOf(12.00));
        Cliente cli2 = new Cliente();
        cli2.setId(1);
        cli2.setNome("Carla");
        cli2.setSaldo(BigDecimal.valueOf(24.00));
        list.add(cli);
        list.add(cli2);

        return list;
    }


    private void setFloatingActionButton() {
        fab_add = findViewById(R.id.fab);
        fab_shopp = findViewById(R.id.fab_add_shopping);
        fab_client = findViewById(R.id.fab_add_client);

        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open_black_list);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close_black_list);

        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });
        fab_shopp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Toast.makeText(HomeActivity.this, "Inserir Fiado", Toast.LENGTH_SHORT).show();
            }
        });
        fab_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Intent intent = new Intent(HomeActivity.this, ClientActivity.class);
                startActivity(intent);
            }
        });
    }

    private void animateFab() {
        if (isOpen) {
            fab_add.startAnimation(rotateForward);
            fab_shopp.startAnimation(fabClose);
            fab_client.startAnimation(fabClose);
            fab_shopp.setClickable(false);
            fab_client.setClickable(false);
            isOpen = false;
        } else {
            fab_add.startAnimation(rotateBackward);
            fab_shopp.startAnimation(fabOpen);
            fab_client.startAnimation(fabOpen);
            fab_shopp.setClickable(true);
            fab_client.setClickable(true);
            isOpen = true;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_black_list, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }







}
