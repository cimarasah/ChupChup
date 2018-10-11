package com.cimarasah.chupchup.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cimarasah.chupchup.Adapter.HomeRecyclerViewAdapter;
import com.cimarasah.chupchup.Enum.TipoTransacao;
import com.cimarasah.chupchup.Model.Cliente;
import com.cimarasah.chupchup.Model.Transacao;
import com.cimarasah.chupchup.R;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by c.de.sa.oliveira on 21/08/2018.
 */

public class CreditFragment extends Fragment {

    View v;
    private RecyclerView myRecyclerView;
    private List<Transacao> lstCredito;
    public CreditFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_credit_list, container,false);
        myRecyclerView = v.findViewById(R.id.credit_recyclerview);
        HomeRecyclerViewAdapter recyclerAdapter = new HomeRecyclerViewAdapter(getContext(), lstCredito, false);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerAdapter);
        myRecyclerView.addItemDecoration(
                new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstCredito = new ArrayList<>();

        lstCredito.add(mockTransacao());
        lstCredito.add(mockTransacao());
        lstCredito.add(mockTransacao());
        lstCredito.add(mockTransacao());
        lstCredito.add(mockTransacao());
        lstCredito.add(mockTransacao());
    }

    private Transacao mockTransacao(){
        Cliente c = new Cliente(1,"Carla",new BigDecimal("10"),true);

        Transacao trans = new Transacao(1,TipoTransacao.CREDITO,new Date(),new BigDecimal("12"),c);

        return trans;
    }
}
