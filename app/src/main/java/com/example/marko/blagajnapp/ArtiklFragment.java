package com.example.marko.blagajnapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ArtiklFragment extends Fragment {

    RecyclerView rvArtikli;
    ArtiklAdapter mArtiklAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.artikl_fragment, null);
        setUpUI(layout);
        return layout;
    }

    private void setUpUI(View layout){
        this.rvArtikli = (RecyclerView) layout.findViewById(R.id.rvArtikli);
        this.mArtiklAdapter = new ArtiklAdapter(new ArrayList<Artikl>());
        this.mLayoutManager = new GridLayoutManager(getActivity(),2,GridLayoutManager.HORIZONTAL,false);

        this.rvArtikli.setLayoutManager(this.mLayoutManager);
        this.rvArtikli.setAdapter(this.mArtiklAdapter);
    }
}
