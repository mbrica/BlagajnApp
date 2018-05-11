package com.example.marko.blagajnapp;

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

import java.util.ArrayList;

public class TabArtikli extends Fragment {

    private static final String TAG = "TabArtikli";

    private TextView tvartikli;
    private FloatingActionButton fabNoviArtikl;
    private RecyclerView rvPrikazArtikala;
    private PrikazArtiklaAdapter mPrikazArtikalaAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_artikli,container,false);
        TextView tvartikli = (TextView) view.findViewById(R.id.tvartikli);

        Context context = getActivity();
        rvPrikazArtikala = (RecyclerView) view.findViewById(R.id.rvPopisArtikala);
        mPrikazArtikalaAdapter = new PrikazArtiklaAdapter(new ArrayList<Artikl>());
        mLayoutManager = new LinearLayoutManager(context);
        mItemDecoration = new DividerItemDecoration(context,DividerItemDecoration.VERTICAL);

        rvPrikazArtikala.addItemDecoration(mItemDecoration);
        rvPrikazArtikala.setLayoutManager(mLayoutManager);
        rvPrikazArtikala.setAdapter(mPrikazArtikalaAdapter);

        FloatingActionButton fabNoviArtikl = (FloatingActionButton) view.findViewById(R.id.fabNoviArtikl);
        fabNoviArtikl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),NoviArtiklActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }


}

