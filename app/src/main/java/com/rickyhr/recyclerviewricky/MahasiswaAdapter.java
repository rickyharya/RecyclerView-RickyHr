package com.rickyhr.recyclerviewricky;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {
private ArrayList<Mahasiswa> datalist;

public MahasiswaAdapter(ArrayList<Mahasiswa> datalist){
    this.datalist = datalist;
}
    @Override
    public MahasiswaAdapter.MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mahasiswa_list_item,parent,false);
       return new MahasiswaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MahasiswaAdapter.MahasiswaViewHolder holder, int position) {
        holder.txtnama.setText(datalist.get(position).getNama());
        holder.txtnim.setText(datalist.get(position).getNim());

    }

    @Override
    public int getItemCount() {
        return (datalist != null) ? datalist.size() :0;
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtnama, txtnim;
        private ImageView icngambar;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            txtnama = (TextView) itemView.findViewById(R.id.nama);
            txtnim  = (TextView) itemView.findViewById(R.id.nim);

        }
    }
}
