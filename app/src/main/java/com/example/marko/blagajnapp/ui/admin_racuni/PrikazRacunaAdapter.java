package com.example.marko.blagajnapp.ui.admin_racuni;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.PrikazRacunaData;


import java.util.List;

public class PrikazRacunaAdapter extends RecyclerView.Adapter<PrikazRacunaAdapter.PrikazRacunaViewHolder> {

    private List<PrikazRacunaData> mRacun;

    public PrikazRacunaAdapter(List<PrikazRacunaData> racuni){
        mRacun = racuni;
    }

    @Override
    public PrikazRacunaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prikaz_racuna,parent,false);
        return new PrikazRacunaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PrikazRacunaViewHolder holder, int position) {
        holder.tvRacun.setText("Br. Računa: " + String.valueOf(mRacun.get(position).getRacunId()));
        holder.tvVrijeme.setText("Vrijeme: " + mRacun.get(position).getVrijemeIzdavanja());
        holder.tvDjelatnik.setText("Djelatnik:" + mRacun.get(position).getImeDjelatnika());
        holder.tvStavke.setText(mRacun.get(position).getStavkeString());
        holder.tvUkupno.setText("Ukupno: " + mRacun.get(position).getIznosRacuna() + "KN");
    }

    @Override
    public int getItemCount() {
        return mRacun.size();
    }

    public void setmRacun(List<PrikazRacunaData> prikazRacunaData){
        this.mRacun.clear();
        this.mRacun.addAll(prikazRacunaData);
        this.mRacun = prikazRacunaData;
        notifyDataSetChanged();
    }

    public static class PrikazRacunaViewHolder extends RecyclerView.ViewHolder{

        public TextView tvRacun;
        public TextView tvVrijeme;
        public TextView tvDjelatnik;
        public TextView tvStavke;
        public TextView tvUkupno;

        public PrikazRacunaViewHolder(View itemView){
            super(itemView);
            this.tvRacun = (TextView) itemView.findViewById(R.id.tvRacun);
            this.tvVrijeme = (TextView) itemView.findViewById(R.id.tvVrijeme);
            this.tvDjelatnik = (TextView) itemView.findViewById(R.id.tvDjelatnik);
            this.tvStavke = (TextView) itemView.findViewById(R.id.tvStavke);
            this.tvUkupno = (TextView) itemView.findViewById(R.id.tvUkupno);
        }
    }
}
