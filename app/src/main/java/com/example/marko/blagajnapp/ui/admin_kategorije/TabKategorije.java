package com.example.marko.blagajnapp.ui.admin_kategorije;

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
import com.example.marko.blagajnapp.model.Kategorija;
import com.example.marko.blagajnapp.viewmodel.KategorijaViewModel;

import java.util.ArrayList;
import java.util.List;

public class TabKategorije extends Fragment implements PrikazKategorijeAdapter.ClickListener {

    private static final String TAG = "TabKategorije";

    private TextView tvkategorije;
    private FloatingActionButton fabNovaKategorija;
    private RecyclerView rvPrikazKategorija;
    private PrikazKategorijeAdapter mPrikazKategorijaAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;
    private KategorijaViewModel model;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(this).get(KategorijaViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_kategorije,container,false);

        Context context = getActivity();
        rvPrikazKategorija = (RecyclerView) view.findViewById(R.id.rvPopisKategorija);
        mPrikazKategorijaAdapter = new PrikazKategorijeAdapter(new ArrayList<Kategorija>());
        mPrikazKategorijaAdapter.setClickListener(this);
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model.getAllKategorije().observe(this, new Observer<List<Kategorija>>() {
            @Override
            public void onChanged(@Nullable List<Kategorija> kategorije) {
               mPrikazKategorijaAdapter.setKategorije(kategorije);
            }
        });
    }

    @Override
    public void onClick(View v, final Kategorija kategorija){
        PopupMenu menu = new PopupMenu(getContext(),v);
        menu.inflate(R.menu.item_menu);
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menuItemUredi){
                    Intent intent = new Intent();
                    intent.setClass(getActivity(),NovaKategorijaActivity.class);
                    intent.putExtra(NovaKategorijaActivity.ID, kategorija.getMKategorijaId());
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.menuItemBrisi){
                    model.deleteKategorija(kategorija);
                    return true;
                }
                return false;
            }
        });
        menu.show();
    }
}


