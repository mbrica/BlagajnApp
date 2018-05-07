package com.example.marko.blagajnapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RacunAdapter extends RecyclerView.Adapter<RacunAdapter.RacunViewHolder> {


    private List<Racun> mRacun;

    public RacunAdapter(List<Racun> racuni){
        mRacun = new ArrayList<>(); // provjeriti ovo
    }

    @NonNull
    @Override
    public RacunViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_racun,parent,false);
        return new RacunViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RacunViewHolder holder, int position) {
        Racun dodaniArtikl = mRacun.get(position);
        //dodati holdere za račune
    }

    @Override
    public int getItemCount() {
        return mRacun.size();
    }

    public static class RacunViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvNazivArtikla;
        public EditText etKolicina;
        public TextView tvCijena;
        public TextView tvIznos;

        public RacunViewHolder (View itemView){
            super(itemView);
            this.tvNazivArtikla = (TextView) itemView.findViewById(R.id.tvNaziv);
            this.etKolicina = (EditText) itemView.findViewById(R.id.etOdabranaKolicina);
            this.tvCijena = (TextView) itemView.findViewById(R.id.tvCijena);
            this.tvIznos = (TextView) itemView.findViewById(R.id.tvIznos);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
