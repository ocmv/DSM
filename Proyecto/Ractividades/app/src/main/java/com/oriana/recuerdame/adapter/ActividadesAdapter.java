package com.oriana.recuerdame.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oriana.recuerdame.R;
import com.oriana.recuerdame.entidades.TareasA;

import java.util.ArrayList;


/**
 * Created by Oriana on 24/8/2018.
 */

public class ActividadesAdapter extends RecyclerView.Adapter<ActividadesAdapter.ActividadesViewHolder> {

    private Context mContext;
    private ArrayList<TareasA> mTareasList;


    public ActividadesAdapter (Context context, ArrayList<TareasA> tareaList){
        mContext= context;
        mTareasList=tareaList;
    }




    @NonNull
    @Override
    public ActividadesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_act, parent, false);
        return new ActividadesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ActividadesViewHolder holder, int position) {
        TareasA currentItem =  mTareasList.get(position);

        String tituloActividad= currentItem.getmTitulo();
        String descripcionActividad = currentItem.getmDescripcion();


        holder.mTituloView.setText(tituloActividad);
        holder.mDescripcionView.setText(descripcionActividad);


    }



    @Override
    public int getItemCount() {
        return mTareasList.size();
    }

    public class ActividadesViewHolder extends RecyclerView.ViewHolder{

        public TextView mTituloView;
        public   TextView mDescripcionView;

        public ActividadesViewHolder(View itemView) {
            super(itemView);
            mTituloView = itemView.findViewById(R.id.ver_activi);
            mDescripcionView= itemView.findViewById(R.id.ver_descr);


        }
    }
}
