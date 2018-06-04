package com.example.marko.blagajnapp.ui.djelatnik_racun;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.StavkeRacuna;
import java.util.List;

public class RacunAdapter extends RecyclerView.Adapter<RacunAdapter.RacunViewHolder> {


    private List<StavkeRacuna> mStavkeRacuna;
    private ClickListener clickListener;

    public RacunAdapter(List<StavkeRacuna> stavkeRacuna){
        mStavkeRacuna = stavkeRacuna;
    }

    @Override
    public RacunViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_racun,parent,false);
        return new RacunViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RacunViewHolder holder, int position) {
        holder.etKolicina.setText(String.valueOf(mStavkeRacuna.get(position).getKolicina()));
        holder.tvCijena.setText(String.valueOf(mStavkeRacuna.get(position).getCijenaArtikla()));
        holder.tvIznos.setText(String.valueOf(mStavkeRacuna.get(position).getIznos()));
        holder.tvNazivArtikla.setText(mStavkeRacuna.get(position).getNazivArtikla());
    }

    @Override
    public int getItemCount() {
        return mStavkeRacuna.size();
    }

    public void dodajStavkuRacuna(StavkeRacuna stavkeRacuna){
        mStavkeRacuna.add(stavkeRacuna);
        notifyDataSetChanged();

        if (clickListener != null){
            float ukupniIznos = 0;
            for (StavkeRacuna stavka : mStavkeRacuna){
                ukupniIznos = ukupniIznos + stavka.getIznos();
            }
            clickListener.onClick(String.valueOf(ukupniIznos));
        }
    }

    public void obrisiSveStavkeRacuna(){
        mStavkeRacuna.clear();
        notifyDataSetChanged();
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public List<StavkeRacuna> getmStavkeRacuna(){
        return mStavkeRacuna;
    }

    public class RacunViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNazivArtikla;
        public EditText etKolicina;
        public TextView tvCijena;
        public TextView tvIznos;

        public RacunViewHolder (View itemView){
            super(itemView);
            this.tvNazivArtikla = (TextView) itemView.findViewById(R.id.tvOdabraniArtikl);
            this.etKolicina = (EditText) itemView.findViewById(R.id.etOdabranaKolicina);
            this.tvCijena = (TextView) itemView.findViewById(R.id.tvCijenaArtikla);
            this.tvIznos = (TextView) itemView.findViewById(R.id.tvIznosArtikla);

            etKolicina.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (!editable.toString().equals(String.valueOf(mStavkeRacuna.get(getAdapterPosition()).getKolicina())) && !editable.toString().equals("")){
                        StavkeRacuna stavkeRacuna = mStavkeRacuna.get(getAdapterPosition());
                        stavkeRacuna.setKolicina(Integer.valueOf(editable.toString()));
                        stavkeRacuna.setIznos(stavkeRacuna.getCijenaArtikla() * stavkeRacuna.getKolicina());
                        notifyItemChanged(getAdapterPosition());

                        if (clickListener != null){
                            float ukupniIznos = 0;
                            for (StavkeRacuna stavka : mStavkeRacuna){
                                ukupniIznos = ukupniIznos + stavka.getIznos();
                            }
                            clickListener.onClick(String.valueOf(ukupniIznos));
                        }
                    }
                }
            });
        }
    }

    interface ClickListener{
        void onClick(String iznos);
    }
}
