package com.example.marko.blagajnapp.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Kategorija;
import com.example.marko.blagajnapp.ui.KategorijaAdapter;

import java.util.ArrayList;

public class KategorijaFragment extends Fragment {


    RecyclerView rvKategorije;
    KategorijaAdapter mKategorijaAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Layout = inflater.inflate(R.layout.kategorija_fragment,null);
        setUpUI(Layout);
        return Layout;
    }

    private void setUpUI(View layout){
        this.rvKategorije = (RecyclerView) layout.findViewById(R.id.rvKategorije);
        this.mKategorijaAdapter = new KategorijaAdapter(new ArrayList<Kategorija>());
        this.mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);

        this.rvKategorije.setLayoutManager(this.mLayoutManager);
        this.rvKategorije.setAdapter(this.mKategorijaAdapter);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
