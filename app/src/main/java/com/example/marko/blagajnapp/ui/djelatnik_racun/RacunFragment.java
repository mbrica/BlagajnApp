package com.example.marko.blagajnapp.ui.djelatnik_racun;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Artikl;
import com.example.marko.blagajnapp.model.Racun;
import com.example.marko.blagajnapp.model.StavkeRacuna;
import com.example.marko.blagajnapp.viewmodel.RacunViewModel;
import com.example.marko.blagajnapp.viewmodel.StavkeRacunaViewModel;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RacunFragment extends Fragment implements RacunAdapter.ClickListener, View.OnClickListener {

    private TextView tvUkupnoCijena;
    private Button btnOdustani;
    private Button btnSpremi;
    private RecyclerView rvRacun;
    private RacunAdapter mRacunAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RacunViewModel racunModel;
    private StavkeRacunaViewModel stavkeRacunaModel;
    private int djelatnik;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        racunModel = ViewModelProviders.of(this).get(RacunViewModel.class);
        stavkeRacunaModel = ViewModelProviders.of(this).get(StavkeRacunaViewModel.class);
        racunModel.getAllRacuni().observe(this, new Observer<List<Racun>>() {
            @Override
            public void onChanged(@Nullable List<Racun> racuni) {
                if (mRacunAdapter != null && mRacunAdapter.getItemCount() > 0){
                    Racun noviRacun = racuni.get(racuni.size() - 1);
                    List<StavkeRacuna> stavkeRacuna = mRacunAdapter.getmStavkeRacuna();
                    for (StavkeRacuna stavka : stavkeRacuna){
                        stavka.setIdRacuna(noviRacun.getRacunId());
                    }
                    stavkeRacunaModel.insertStavkeRacuna(stavkeRacuna);
                }
            }
        });
        stavkeRacunaModel.getAllStavkeRacuna().observe(this, new Observer<List<StavkeRacuna>>() {
            @Override
            public void onChanged(@Nullable List<StavkeRacuna> stavkeRacuna) {
                if (mRacunAdapter != null){
                    mRacunAdapter.obrisiSveStavkeRacuna();
                    tvUkupnoCijena.setText("0");
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.racun_fragment,null);
        setUpUI(layout);
        return layout;
    }

    private void setUpUI(View layout){
        this.tvUkupnoCijena = (TextView) layout.findViewById(R.id.tvUkupnoCijena);
        this.btnOdustani = (Button) layout.findViewById(R.id.btnOdustani);
        this.btnOdustani.setOnClickListener(this);
        this.btnSpremi = (Button) layout.findViewById(R.id.btnSpremi);
        this.btnSpremi.setOnClickListener(this);
        this.rvRacun = (RecyclerView) layout.findViewById(R.id.rvRacun);
        this.mRacunAdapter = new RacunAdapter(new ArrayList<StavkeRacuna>());
        this.mRacunAdapter.setClickListener(this);
        this.mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        this.rvRacun.setLayoutManager(this.mLayoutManager);
        this.rvRacun.setAdapter(this.mRacunAdapter);
    }

    public void dodajStavkuRacuna(Artikl artikl){
        mRacunAdapter.dodajStavkuRacuna(new StavkeRacuna(artikl.getMNaziv(),1,artikl.getMCijena(),artikl.getMCijena()));
    }

    public void setDjelatnik(int djelatnik){
        this.djelatnik = djelatnik;
    }

    @Override
    public void onClick(String iznos) {
        tvUkupnoCijena.setText(iznos);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSpremi) {
            if (mRacunAdapter.getItemCount() > 0){
                Racun noviRacun = new Racun(simpleDateFormat.format(new Date(System.currentTimeMillis())),tvUkupnoCijena.getText().toString(),djelatnik);
                racunModel.insertRacun(noviRacun);
            }
        } else if (view.getId() == R.id.btnOdustani){
            mRacunAdapter.obrisiSveStavkeRacuna();
            tvUkupnoCijena.setText("0");
        }
    }
}
