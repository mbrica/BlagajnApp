package com.example.marko.blagajnapp.ui.admin_artikli;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Artikl;

import java.util.List;


public class PrikazArtiklaAdapter extends RecyclerView.Adapter<PrikazArtiklaAdapter.PrikazArtikalaViewHolder> {

    private List<Artikl> mArtikl;
    private ClickListener clickListener;

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
        holder.tvIdArtikla.setText(String.valueOf(artikl.getMartiklId()));
        holder.tvNazivArtikla.setText(artikl.getMNaziv());
        holder.tvCijenaArtikla.setText(String.valueOf(artikl.getMCijena()));
        holder.tvKategorijaArtikla.setText(artikl.getMKategorijaNaziv());
    }

    @Override
    public int getItemCount() {
        return mArtikl.size();
    }

    public void setArtikli (List<Artikl> artikli){
        mArtikl.clear();
        mArtikl.addAll(artikli);
        notifyDataSetChanged();
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public class PrikazArtikalaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvIdArtikla;
        public TextView tvNazivArtikla;
        public TextView tvCijenaArtikla;
        public TextView tvKategorijaArtikla;
        public ImageView ivMeni;

        public PrikazArtikalaViewHolder(View itemView) {
            super(itemView);
            this.tvIdArtikla = (TextView) itemView.findViewById(R.id.tvIdArtikla);
            this.tvNazivArtikla = (TextView) itemView.findViewById(R.id.tvNazivArtikla);
            this.tvCijenaArtikla = (TextView) itemView.findViewById(R.id.tvCijenaArtikla);
            this.tvKategorijaArtikla = (TextView) itemView.findViewById(R.id.tvKategorijaArtikla);
            this.ivMeni = (ImageView) itemView.findViewById(R.id.ivMeni);
            this.ivMeni.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null)
                clickListener.onClick(v, mArtikl.get(getAdapterPosition()));
        }
    }

    interface ClickListener {
        void onClick(View v, Artikl artikl);
    }
}
