package com.example.marko.blagajnapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Racun;
import com.example.marko.blagajnapp.ui.PrikazRacunaAdapter;

import java.util.ArrayList;

public class TabRacuni extends Fragment {

    private static final String TAG = "TabRacuni";

    private TextView tvracuni;
    private RecyclerView rvPrikazRacuna;
    private PrikazRacunaAdapter mPrikazRacunaAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_racuni,container,false);
        TextView tvracuni = (TextView) view.findViewById(R.id.tvracuni);

        Context context = getActivity();
        rvPrikazRacuna = (RecyclerView) view.findViewById(R.id.rvPopisRacuna);
        mPrikazRacunaAdapter = new PrikazRacunaAdapter(new ArrayList<Racun>());
        mLayoutManager = new LinearLayoutManager(context);
        mItemDecoration = new DividerItemDecoration(context,DividerItemDecoration.VERTICAL);

        rvPrikazRacuna.addItemDecoration(mItemDecoration);
        rvPrikazRacuna.setLayoutManager(mLayoutManager);
        rvPrikazRacuna.setAdapter(mPrikazRacunaAdapter);

        return view;
    }


}
