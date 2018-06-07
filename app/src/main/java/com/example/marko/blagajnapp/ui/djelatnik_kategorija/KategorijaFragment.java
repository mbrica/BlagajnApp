package com.example.marko.blagajnapp.ui.djelatnik_kategorija;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Kategorija;
import com.example.marko.blagajnapp.ui.MainActivity;
import com.example.marko.blagajnapp.ui.MainInterface;
import com.example.marko.blagajnapp.viewmodel.KategorijaViewModel;


import java.util.ArrayList;
import java.util.List;

public class KategorijaFragment extends Fragment implements KategorijaAdapter.ClickListener {


    private RecyclerView rvKategorije;
    private KategorijaAdapter mKategorijaAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private KategorijaViewModel model;
    private MainInterface mainInterface;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(this).get(KategorijaViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Layout = inflater.inflate(R.layout.kategorija_fragment,null);
        setUpUI(Layout);
        return Layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model.getAllKategorije().observe(this, new Observer<List<Kategorija>>() {
            @Override
            public void onChanged(@Nullable List<Kategorija> kategorije) {
                mKategorijaAdapter.refreshData(kategorije);
            }
        });
    }

    private void setUpUI(View layout){
        this.rvKategorije = (RecyclerView) layout.findViewById(R.id.rvKategorije);
        this.mKategorijaAdapter = new KategorijaAdapter(new ArrayList<Kategorija>());
        this.mKategorijaAdapter.setClickListener(this);
        this.mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);

        this.rvKategorije.setLayoutManager(this.mLayoutManager);
        this.rvKategorije.setAdapter(this.mKategorijaAdapter);

    }

    @Override
    public void onClick(Kategorija kategorija) {
        if (mainInterface != null) {
            mainInterface.prikaziArtikle(kategorija);
        }
    }

    public void setMainInterface(MainInterface mainInterface){
        this.mainInterface = mainInterface;
    }
}
