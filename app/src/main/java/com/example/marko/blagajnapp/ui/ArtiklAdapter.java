package com.example.marko.blagajnapp.ui;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Artikl;

import java.util.List;

public class ArtiklAdapter extends RecyclerView.Adapter<ArtiklAdapter.ArtiklViewHolder> {

    private List<Artikl> mArtikl;

    public ArtiklAdapter(List<Artikl> artikli){
        mArtikl = artikli;
        this.refreshData(artikli);
    }

    @Override
    public ArtiklViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_artikl,parent,false);
        return new ArtiklViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ArtiklViewHolder holder, int position) {
        if (mArtikl != null){
            Artikl odabrani = mArtikl.get(position);
            holder.btnArtiklNaziv.setText(odabrani.getNazivArtikla());
        } else {
            holder.btnArtiklNaziv.setText("Nema artikala u ovoj kategoriji!");
        }
    }

    @Override
    public int getItemCount() {
        return mArtikl.size();
    }

    //refreshData bi trebala refreshirati artikle na osnovu kojoj kategoriji pripada
    public void refreshData(List<Artikl> artikli){
        mArtikl.clear();
        mArtikl.addAll(artikli);
        this.notifyDataSetChanged();
    }

    public static class ArtiklViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public Button btnArtiklNaziv;

        public ArtiklViewHolder (View itemView){
            super(itemView);
            this.btnArtiklNaziv = (Button) itemView.findViewById(R.id.btnTvArtiklNaziv);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //pozvati metodu koja dodaje odabrani artikl na račun u fragmentu 3
        }
    }
}
