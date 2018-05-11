package com.example.marko.blagajnapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabArtikli extends Fragment {

    private static final String TAG = "TabArtikli";

    private TextView tvartikli;
    private FloatingActionButton fabNoviArtikl;
    private RecyclerView rvPrikazArtikala;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_artikli,container,false);
        TextView tvartikli = (TextView) view.findViewById(R.id.tvartikli);

        //dodati RecyclerView

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

