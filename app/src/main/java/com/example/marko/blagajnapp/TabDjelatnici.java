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

public class TabDjelatnici extends Fragment {

    private static final String TAG = "TabDjelatnici";

    private TextView tvdjelatnici;
    private FloatingActionButton fabNoviDjelatnik;
    private RecyclerView rvPrikazDjelatnika;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_djelatnici,container,false);
        TextView tvdjelatnicii = (TextView) view.findViewById(R.id.tvdjelatnici);

        //dodati RecyclerView

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
