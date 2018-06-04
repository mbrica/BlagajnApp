package com.example.marko.blagajnapp.ui.djelatnik_artikl;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Artikl;
import com.example.marko.blagajnapp.model.Kategorija;
import com.example.marko.blagajnapp.ui.MainInterface;
import com.example.marko.blagajnapp.viewmodel.ArtiklViewModel;


import java.util.ArrayList;
import java.util.List;

public class ArtiklFragment extends Fragment implements ArtiklAdapter.ClickListener {

    private RecyclerView rvArtikli;
    private ArtiklAdapter mArtiklAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArtiklViewModel model;
    private MainInterface mainInterface;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(this).get(ArtiklViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.artikl_fragment, null);
        setUpUI(layout);
        return layout;
    }

    private void setUpUI(View layout){
        this.rvArtikli = (RecyclerView) layout.findViewById(R.id.rvArtikli);
        this.mArtiklAdapter = new ArtiklAdapter(new ArrayList<Artikl>());
        this.mArtiklAdapter.setClickListener(this);
        this.mLayoutManager = new GridLayoutManager(getActivity(),2,GridLayoutManager.HORIZONTAL,false);

        this.rvArtikli.setLayoutManager(this.mLayoutManager);
        this.rvArtikli.setAdapter(this.mArtiklAdapter);
    }

    public void setMainInterface(MainInterface mainInterface){
        this.mainInterface = mainInterface;
    }

    public void prikaziArtikle(Kategorija kategorija){
        model.getArtikliIzKategorije(kategorija.getMKategorijaId()).observe(this, new Observer<List<Artikl>>() {
            @Override
            public void onChanged(@Nullable List<Artikl> artikli) {
                mArtiklAdapter.refreshData(artikli);
            }
        });
    }

    @Override
    public void onClick(Artikl artikl) {
        if (mainInterface != null){
            mainInterface.dodajNaRacun(artikl);
        }
    }
}
