package com.example.marko.blagajnapp.ui.admin_kategorije;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Kategorija;

import java.util.List;

public class PrikazKategorijeAdapter extends RecyclerView.Adapter<PrikazKategorijeAdapter.PrikazKategorijeViewHolder> {

    private List<Kategorija> mKategorije;
    private ClickListener clickListener;

    public PrikazKategorijeAdapter(List<Kategorija> kategorije){
        mKategorije = kategorije;
    }

    @Override
    public PrikazKategorijeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prikaz_kategorije,parent,false);
        return new PrikazKategorijeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PrikazKategorijeViewHolder holder, int position) {
        Kategorija kategorija = this.mKategorije.get(position);
        holder.tvIdKategorije.setText(String.valueOf(kategorija.getMKategorijaId()));
        holder.tvNazivKategorije.setText(kategorija.getNazivKategorije());
    }

    @Override
    public int getItemCount() {
        return mKategorije.size();
    }

    public void setKategorije(List<Kategorija> kategorije){
        mKategorije.clear();
        mKategorije.addAll(kategorije);
        notifyDataSetChanged();
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public class PrikazKategorijeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvIdKategorije;
        public TextView tvNazivKategorije;
        public ImageView ivMeni;

        public PrikazKategorijeViewHolder(View itemView) {
            super(itemView);
            this.tvIdKategorije = (TextView) itemView.findViewById(R.id.tvIdKategorije);
            this.tvNazivKategorije = (TextView) itemView.findViewById(R.id.tvNazivKategorije);
            this.ivMeni = (ImageView) itemView.findViewById(R.id.ivMeni);
            this.ivMeni.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null)
                clickListener.onClick(v, mKategorije.get(getAdapterPosition()));
        }
    }

    interface ClickListener {
        void onClick (View v, Kategorija kategorija);
    }
}
