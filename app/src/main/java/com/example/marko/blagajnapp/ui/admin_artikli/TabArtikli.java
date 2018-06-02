package com.example.marko.blagajnapp.ui.admin_artikli;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Artikl;
import com.example.marko.blagajnapp.viewmodel.ArtiklViewModel;


import java.util.ArrayList;
import java.util.List;

public class TabArtikli extends Fragment implements PrikazArtiklaAdapter.ClickListener {

    private static final String TAG = "TabArtikli";

    private TextView tvartikli;
    private FloatingActionButton fabNoviArtikl;
    private RecyclerView rvPrikazArtikala;
    private PrikazArtiklaAdapter mPrikazArtikalaAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;
    private ArtiklViewModel model;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(this).get(ArtiklViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_artikli,container,false);

        Context context = getActivity();
        rvPrikazArtikala = (RecyclerView) view.findViewById(R.id.rvPopisArtikala);
        mPrikazArtikalaAdapter = new PrikazArtiklaAdapter(new ArrayList<Artikl>());
        mPrikazArtikalaAdapter.setClickListener(this);
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model.getArtikli().observe(this, new Observer<List<Artikl>>() {
            @Override
            public void onChanged(List<Artikl> artikli) {
                mPrikazArtikalaAdapter.setArtikli(artikli);
            }
        });
    }

    @Override
    public void onClick(View v, final Artikl artikl) {
        PopupMenu menu = new PopupMenu(getContext(),v);
        menu.inflate(R.menu.item_menu);
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menuItemUredi){
                    Intent intent = new Intent();
                    intent.setClass(getActivity(),NoviArtiklActivity.class);
                    intent.putExtra(NoviArtiklActivity.ID, artikl.getMartiklId());
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.menuItemBrisi) {
                    model.deleteArtikl(artikl);
                    return true;
                }
                return false;
            }
        });
        menu.show();
    }
}

