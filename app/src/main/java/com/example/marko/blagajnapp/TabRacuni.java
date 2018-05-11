package com.example.marko.blagajnapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabRacuni extends Fragment {

    private static final String TAG = "TabRacuni";

    private TextView tvracuni;
    private RecyclerView rvPrikazRacuna;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_racuni,container,false);
        TextView tvracuni = (TextView) view.findViewById(R.id.tvracuni);

        //dodati recycler view

        return view;
    }


}
