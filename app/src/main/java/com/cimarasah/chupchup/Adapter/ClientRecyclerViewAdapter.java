package com.cimarasah.chupchup.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cimarasah.chupchup.Enum.TipoTransacao;
import com.cimarasah.chupchup.Model.Cliente;
import com.cimarasah.chupchup.R;

import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by c.de.sa.oliveira on 21/08/2018.
 */

public class ClientRecyclerViewAdapter extends RecyclerView.Adapter<ClientRecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Cliente> lstCliente;

    public ClientRecyclerViewAdapter(Context mContext,List<Cliente> lstCliente) {
        this.mContext = mContext;
        this.lstCliente = lstCliente;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_client_recycler_view, parent, false);


        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        Format formatter;
        formatter = new SimpleDateFormat("dd/MM");


        holder.tv_nome.setText(lstCliente.get(position).getNome());
        holder.tv_saldo.setText(nf.format(lstCliente.get(position).getSaldo()));
        if (lstCliente.get(position).isTaDevendo()) {
            holder.tv_saldo.setTextColor(Color.rgb(194, 0, 90));
            holder.btn_fin_pend.setImageResource( R.drawable.ic_attach_money_black_24dp);

        } else {
            holder.tv_saldo.setTextColor(Color.rgb(0, 130, 118));
            holder.btn_fin_pend.setImageResource(R.drawable.ic_done_black_24dp);

        }

//        holder.btn_edit.setOnClickListener(view -> updateItem(position));
//        holder.btn_cred.setOnClickListener(view -> removerItem(position));
//        holder.btn_deb.setOnClickListener(view -> removerItem(position));
    }

    @Override
    public int getItemCount() { return lstCliente != null ? lstCliente.size() : 0;   }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_nome;
        private TextView tv_saldo;
        private ImageButton btn_edit;
        private ImageButton btn_fin_pend;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_nome = itemView.findViewById(R.id.nome_list_client);
            tv_saldo = itemView.findViewById(R.id.saldo_list_client);
            btn_edit = itemView.findViewById(R.id.btn_edit_client);
            btn_fin_pend = itemView.findViewById(R.id.btn_fin_pend_client);

        }
    }
}
