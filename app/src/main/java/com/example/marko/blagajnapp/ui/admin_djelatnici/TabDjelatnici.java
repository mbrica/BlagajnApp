package com.example.marko.blagajnapp.ui.admin_djelatnici;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.marko.blagajnapp.model.Djelatnik;
import com.example.marko.blagajnapp.viewmodel.DjelatnikViewModel;

import java.util.ArrayList;
import java.util.List;

public class TabDjelatnici extends Fragment implements PrikazDjelatnikaAdapter.ClickListener {

    private static final String TAG = "TabDjelatnici";

    private TextView tvdjelatnici;
    private FloatingActionButton fabNoviDjelatnik;
    private RecyclerView rvPrikazDjelatnika;
    private PrikazDjelatnikaAdapter mPrikazDjelatnikaAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;
    private DjelatnikViewModel model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(this).get(DjelatnikViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_djelatnici,container,false);


        Context context = getActivity();
        rvPrikazDjelatnika = (RecyclerView) view.findViewById(R.id.rvPopisDjelatnika);
        mPrikazDjelatnikaAdapter = new PrikazDjelatnikaAdapter(new ArrayList<Djelatnik>());
        mPrikazDjelatnikaAdapter.setClickListeer(this);
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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model.getAllDjelatnik().observe(this, new Observer<List<Djelatnik>>() {
            @Override
            public void onChanged(@Nullable List<Djelatnik> djelatnici) {
                mPrikazDjelatnikaAdapter.setDjelatnici(djelatnici);
            }
        });
    }

    @Override
    public void onClick(View v, final Djelatnik djelatnik) {
        PopupMenu menu = new PopupMenu(getContext(),v);
        menu.inflate(R.menu.item_menu);
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menuItemUredi){
                    Intent intent = new Intent();
                    intent.setClass(getActivity(),NoviDjelatnikActivity.class);
                    intent.putExtra(NoviDjelatnikActivity.ID, djelatnik.getDjelatnikId());
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.menuItemBrisi) {
                    model.deleteDjelatnik(djelatnik);
                    return true;
                }
                return false;
            }
        });
        menu.show();
    }
}
