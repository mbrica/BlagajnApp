package com.example.marko.blagajnapp.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Racun;

import java.util.List;

public class PrikazRacunaAdapter extends RecyclerView.Adapter<PrikazRacunaAdapter.PrikazRacunaViewHolder> {

    private List<Racun> mRacun;

    public PrikazRacunaAdapter(List<Racun> racuni){
        mRacun = racuni;
    }

    @Override
    public PrikazRacunaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prikaz_racuna,parent,false);
        return new PrikazRacunaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PrikazRacunaViewHolder holder, int position) {
        Racun racun = this.mRacun.get(position);
        //Dodati holdere za iteme recycler viewa
    }

    @Override
    public int getItemCount() {
        return mRacun.size();
    }

    public static class PrikazRacunaViewHolder extends RecyclerView.ViewHolder{

        public TextView tvRacun;

        public PrikazRacunaViewHolder(View itemView){
            super(itemView);
            this.tvRacun = (TextView) itemView.findViewById(R.id.tvRacun);
        }

    }
}
