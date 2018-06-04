package com.example.marko.blagajnapp.ui.djelatnik_kategorija;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Kategorija;

import java.util.ArrayList;
import java.util.List;

public class KategorijaAdapter extends RecyclerView.Adapter<KategorijaAdapter.KategorijaViewHolder> {

    private List<Kategorija> mKategorija;
    private ClickListener clickListener;

    public KategorijaAdapter(List<Kategorija> kategorije) {
        mKategorija = new ArrayList<>();
    }

    @Override
    public KategorijaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kategorija,parent,false);
        return new KategorijaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KategorijaViewHolder holder, int position) {
        if (mKategorija != null){
            Kategorija odabrana = mKategorija.get(position);
            holder.btnKategorijaNaziv.setText(odabrana.getNazivKategorije());
        } else {
            holder.btnKategorijaNaziv.setText("Nema unešenih kategorija!");
        }
    }

    @Override
    public int getItemCount() {
        return mKategorija.size();
    }

    public void refreshData (List<Kategorija> kategorije){
        mKategorija.clear();
        mKategorija.addAll(kategorije);
        this.notifyDataSetChanged();
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public class KategorijaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public Button btnKategorijaNaziv;

        public KategorijaViewHolder(View itemView){
            super(itemView);
            this.btnKategorijaNaziv = (Button) itemView.findViewById(R.id.btnTvKategorijaNaziv);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null){
                clickListener.onClick(mKategorija.get(getAdapterPosition()));
            }
        }
    }

    interface ClickListener {
        void onClick(Kategorija kategorija);
    }
}
