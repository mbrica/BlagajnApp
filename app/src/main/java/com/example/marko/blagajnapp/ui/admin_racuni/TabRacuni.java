package com.example.marko.blagajnapp.ui.admin_racuni;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.PrikazRacunaData;
import com.example.marko.blagajnapp.model.Racun;
import com.example.marko.blagajnapp.model.RacunData;
import com.example.marko.blagajnapp.viewmodel.RacunViewModel;

import java.util.ArrayList;
import java.util.List;

public class TabRacuni extends Fragment {

    private static final String TAG = "TabRacuni";

    private RecyclerView rvPrikazRacuna;
    private PrikazRacunaAdapter mPrikazRacunaAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;
    private RacunViewModel model;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(this).get(RacunViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_racuni,container,false);

        Context context = getActivity();
        rvPrikazRacuna = (RecyclerView) view.findViewById(R.id.rvPopisRacuna);
        mPrikazRacunaAdapter = new PrikazRacunaAdapter(new ArrayList<PrikazRacunaData>());
        mLayoutManager = new LinearLayoutManager(context);
        mItemDecoration = new DividerItemDecoration(context,DividerItemDecoration.VERTICAL);

        rvPrikazRacuna.addItemDecoration(mItemDecoration);
        rvPrikazRacuna.setLayoutManager(mLayoutManager);
        rvPrikazRacuna.setAdapter(mPrikazRacunaAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model.getAllRacuniIStavkeRacuna().observe(this, new Observer<List<RacunData>>() {
            @Override
            public void onChanged(@Nullable List<RacunData> racunData) {
                List<PrikazRacunaData> prikazRacunaData = new ArrayList<>();
                PrikazRacunaData prikazRacuna = null;
                int racunID = -1;
                for (RacunData data : racunData) {
                    if (racunID != data.racunId) {
                        racunID = data.racunId;
                        String stavkeString = data.NazivArtikla + "\t\t" + "x" + data.Kolicina + "\t\t" + data.CijenaArtikla + "\t\t" + data.Iznos;
                        prikazRacuna = new PrikazRacunaData(data.racunId, data.vrijemeIzdavanja, data.iznosRacuna, data.imeDjelatnika, stavkeString);
                        prikazRacunaData.add(prikazRacuna);
                    } else if (prikazRacuna != null){
                        String stavkeString = "\n" + data.NazivArtikla + "\t\t" + "x" + data.Kolicina + "\t\t" + data.CijenaArtikla + "\t\t" + data.Iznos;
                        prikazRacuna.setStavkeString(prikazRacuna.getStavkeString() + stavkeString);
                    }
                }
                mPrikazRacunaAdapter.setmRacun(prikazRacunaData);
            }
        });
    }
}
