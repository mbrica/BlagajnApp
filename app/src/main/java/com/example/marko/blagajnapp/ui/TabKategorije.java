package com.example.marko.blagajnapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Kategorija;
import com.example.marko.blagajnapp.ui.NovaKategorijaActivity;
import com.example.marko.blagajnapp.ui.PrikazKategorijeAdapter;

import java.util.ArrayList;

public class TabKategorije extends Fragment {

    private static final String TAG = "TabKategorije";

    private TextView tvkategorije;
    private FloatingActionButton fabNovaKategorija;
    private RecyclerView rvPrikazKategorija;
    private PrikazKategorijeAdapter mPrikazKategorijaAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_kategorije,container,false);
        TextView tvkategorije = (TextView) view.findViewById(R.id.tvdjelatnici);

        Context context = getActivity();
        rvPrikazKategorija = (RecyclerView) view.findViewById(R.id.rvPopisKategorija);
        mPrikazKategorijaAdapter = new PrikazKategorijeAdapter(new ArrayList<Kategorija>());
        mLayoutManager = new LinearLayoutManager(context);
        mItemDecoration = new DividerItemDecoration(context,DividerItemDecoration.VERTICAL);

        rvPrikazKategorija.addItemDecoration(mItemDecoration);
        rvPrikazKategorija.setLayoutManager(mLayoutManager);
        rvPrikazKategorija.setAdapter(mPrikazKategorijaAdapter);

        FloatingActionButton fabNovaKategorija = (FloatingActionButton) view.findViewById(R.id.fabNovaKategorija);
        fabNovaKategorija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),NovaKategorijaActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}


