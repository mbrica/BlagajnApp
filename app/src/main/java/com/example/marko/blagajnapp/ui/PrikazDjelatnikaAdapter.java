package com.example.marko.blagajnapp.ui;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Djelatnik;

import java.util.List;

public class PrikazDjelatnikaAdapter extends RecyclerView.Adapter<PrikazDjelatnikaAdapter.PrikazDjelatnikaViewHolder> {

    private List<Djelatnik> mDjelatnici;

    public PrikazDjelatnikaAdapter(List<Djelatnik> djelatnici){
        mDjelatnici = djelatnici;
    }

    @Override
    public PrikazDjelatnikaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prikaz_djelatnika,parent,false);
        return new PrikazDjelatnikaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PrikazDjelatnikaViewHolder holder, int position) {
        Djelatnik djelatnik = this.mDjelatnici.get(position);
        holder.tvIdDjelatnika.setText(djelatnik.getDjelatnikId());
        holder.tvImeDjelatnika.setText(djelatnik.getImeDjelatnika());
        holder.tvPrezimeDjelatnika.setText(djelatnik.getPrezimeDjelatnika());
        holder.tvOIBDjelatnika.setText(djelatnik.getOIB());
        holder.tvUsernameDjelatnika.setText(djelatnik.getUsername());
    }

    @Override
    public int getItemCount() {
        return mDjelatnici.size();
    }

    public static class PrikazDjelatnikaViewHolder extends RecyclerView.ViewHolder{

        public TextView tvIdDjelatnika;
        public TextView tvImeDjelatnika;
        public TextView tvPrezimeDjelatnika;
        public TextView tvOIBDjelatnika;
        public TextView tvUsernameDjelatnika;

        public PrikazDjelatnikaViewHolder (View itemView){
            super(itemView);
            this.tvIdDjelatnika = (TextView) itemView.findViewById(R.id.tvIdDjelatnika);
            this.tvImeDjelatnika = (TextView) itemView.findViewById(R.id.tvImeDjelatnika);
            this.tvPrezimeDjelatnika = (TextView) itemView.findViewById(R.id.tvPrezimeDjelatnika);
            this.tvOIBDjelatnika = (TextView) itemView.findViewById(R.id.tvOIBDjelatnika);
            this.tvUsernameDjelatnika = (TextView) itemView.findViewById(R.id.tvUsernameDjelatnika);
        }
    }
}
