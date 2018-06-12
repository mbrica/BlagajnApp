package com.example.marko.blagajnapp.ui.djelatnik_artikl;
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
    private ClickListener clickListener;

    public ArtiklAdapter(List<Artikl> artikli){
        mArtikl = artikli;
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
            holder.btnArtiklNaziv.setText(odabrani.getMNaziv());
        } else {
            holder.btnArtiklNaziv.setText("Nema artikala u ovoj kategoriji!");
        }
    }

    @Override
    public int getItemCount() {
        return mArtikl.size();
    }

    public void refreshData(List<Artikl> artikli){
        mArtikl.clear();
        mArtikl.addAll(artikli);
        this.notifyDataSetChanged();
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public class ArtiklViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public Button btnArtiklNaziv;

        public ArtiklViewHolder (View itemView){
            super(itemView);
            this.btnArtiklNaziv = (Button) itemView.findViewById(R.id.btnTvArtiklNaziv);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null){
                clickListener.onClick(mArtikl.get(getAdapterPosition()));
            }
        }
    }

    interface ClickListener{
        void onClick(Artikl artikl);
    }
}
