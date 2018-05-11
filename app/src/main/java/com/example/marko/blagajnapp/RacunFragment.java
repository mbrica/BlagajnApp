package com.example.marko.blagajnapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RacunFragment extends Fragment {

    TextView tvNaziv;
    TextView tvKolicina;
    TextView tvCijena;
    TextView tvIznos;

    RecyclerView rvRacun;
    RacunAdapter mRacunAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.racun_fragment,null);
        setUpUI(layout);
        return layout;
    }

    private void setUpUI(View layout){
        this.rvRacun = (RecyclerView) layout.findViewById(R.id.rvRacun);
        this.mRacunAdapter = new RacunAdapter(new ArrayList<Racun>());
        this.mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        this.rvRacun.setLayoutManager(this.mLayoutManager);
        this.rvRacun.setAdapter(this.mRacunAdapter);
    }
}
