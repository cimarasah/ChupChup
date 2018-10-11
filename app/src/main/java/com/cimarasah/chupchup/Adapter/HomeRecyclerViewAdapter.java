package com.cimarasah.chupchup.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cimarasah.chupchup.Enum.TipoTransacao;
import com.cimarasah.chupchup.Model.Transacao;
import com.cimarasah.chupchup.R;

import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by c.de.sa.oliveira on 21/08/2018.
 */

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Transacao> lstTransicao;
    boolean isDaily=false;

    public HomeRecyclerViewAdapter(Context mContext, List<Transacao> lstTransacao, boolean isDaily) {
        this.mContext = mContext;
        this.lstTransicao = lstTransacao;
        this.isDaily = isDaily;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v  = LayoutInflater.from(mContext).inflate(R.layout.item_home_recycler_view, parent,false);


        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        Format formatter;
        formatter = new SimpleDateFormat("dd/MM");


        holder.tv_nome.setText(lstTransicao.get(position).getCliente().getNome());
        holder.tv_data.setText(formatter.format(lstTransicao.get(position).getDt()));
        if(isDaily){

            if(lstTransicao.get(position).getTipo().equals(TipoTransacao.DEBITO)){
                holder.tv_valor_trans.setTextColor(Color.rgb(164,0,90));
                holder.tv_valor_trans.setText(" - " + nf.format (lstTransicao.get(position).getValor()));
            }else{
                holder.tv_valor_trans.setTextColor(Color.rgb(0,130,118));
                holder.tv_valor_trans.setText(" + " + nf.format (lstTransicao.get(position).getValor()));
            }
        }else{
            holder.tv_valor_trans.setText(nf.format (lstTransicao.get(position).getCliente().getSaldo()));
        }

    }

    @Override
    public int getItemCount() {
        return lstTransicao.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_nome;
        private TextView tv_data;
        private TextView tv_valor_trans;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_nome = itemView.findViewById(R.id.nome_list_home);
            tv_data = itemView.findViewById(R.id.debito_data_home);
            tv_valor_trans = itemView.findViewById(R.id.debito_list_home);
        }
    }
}
