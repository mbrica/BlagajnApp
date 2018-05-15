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
import com.example.marko.blagajnapp.model.Djelatnik;
import com.example.marko.blagajnapp.ui.NoviDjelatnikActivity;
import com.example.marko.blagajnapp.ui.PrikazDjelatnikaAdapter;

import java.util.ArrayList;

public class TabDjelatnici extends Fragment {

    private static final String TAG = "TabDjelatnici";

    private TextView tvdjelatnici;
    private FloatingActionButton fabNoviDjelatnik;
    private RecyclerView rvPrikazDjelatnika;
    private PrikazDjelatnikaAdapter mPrikazDjelatnikaAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_djelatnici,container,false);
        TextView tvdjelatnicii = (TextView) view.findViewById(R.id.tvdjelatnici);


        Context context = getActivity();
        rvPrikazDjelatnika = (RecyclerView) view.findViewById(R.id.rvPopisDjelatnika);
        mPrikazDjelatnikaAdapter = new PrikazDjelatnikaAdapter(new ArrayList<Djelatnik>());
        mLayoutManager = new LinearLayoutManager(context);
        mItemDecoration = new DividerItemDecoration(context,DividerItemDecoration.VERTICAL);

        rvPrikazDjelatnika.addItemDecoration(mItemDecoration);
        rvPrikazDjelatnika.setLayoutManager(mLayoutManager);
        rvPrikazDjelatnika.setAdapter(mPrikazDjelatnikaAdapter);

        FloatingActionButton fabNoviDjelatnik = (FloatingActionButton) view.findViewById(R.id.fabNoviDjelatnik);
        fabNoviDjelatnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),NoviDjelatnikActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
