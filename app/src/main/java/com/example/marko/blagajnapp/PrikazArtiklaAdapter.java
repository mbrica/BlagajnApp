package com.example.marko.blagajnapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class PrikazArtiklaAdapter extends RecyclerView.Adapter<PrikazArtiklaAdapter.PrikazArtikalaViewHolder> {

    private List<Artikl> mArtikl;

    public PrikazArtiklaAdapter(List<Artikl> artikli){
        mArtikl = artikli;
    }

    @Override
    public PrikazArtikalaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prikaz_artikla,parent,false);
        return new PrikazArtikalaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PrikazArtikalaViewHolder holder, int position) {
        Artikl artikl = this.mArtikl.get(position);
        holder.tvIdArtikla.setText(artikl.getArtiklId());
        holder.tvNazivArtikla.setText(artikl.getNazivArtikla());
        holder.tvCijenaArtikla.setX(artikl.getCijenaArtikla());
        holder.tvKategorijaArtikla.setText(artikl.getKategorija());
    }

    @Override
    public int getItemCount() {
        return mArtikl.size();
    }

    public static class PrikazArtikalaViewHolder extends RecyclerView.ViewHolder{

        public TextView tvIdArtikla;
        public TextView tvNazivArtikla;
        public TextView tvCijenaArtikla;
        public TextView tvKategorijaArtikla;

        public PrikazArtikalaViewHolder (View itemView){
            super(itemView);
            this.tvIdArtikla = (TextView) itemView.findViewById(R.id.tvIdArtikla);
            this.tvNazivArtikla = (TextView) itemView.findViewById(R.id.tvNazivArtikla);
            this.tvCijenaArtikla = (TextView) itemView.findViewById(R.id.tvCijenaArtikla);
            this.tvKategorijaArtikla = (TextView) itemView.findViewById(R.id.tvKategorijaArtikla);
        }
    }
}
