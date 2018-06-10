package com.example.marko.blagajnapp.ui.admin_artikli;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.marko.blagajnapp.model.Kategorija;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {

    private List<Kategorija> mKategorija;

    public SpinnerAdapter(List<Kategorija> mKategorija){
        this.mKategorija = mKategorija;
    }

    @Override
    public int getCount() {
        return mKategorija.size();
    }

    @Override
    public Object getItem(int position) {
        return mKategorija.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mKategorija.get(position).getMKategorijaId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_spinner_dropdown_item,viewGroup,false);

        TextView textView = (TextView) row.findViewById(android.R.id.text1);
        textView.setText(mKategorija.get(position).getNazivKategorije());
        return row;
    }

    public void setmKategorija(List<Kategorija> kategorije) {
        mKategorija.clear();
        mKategorija.add(new Kategorija(-1,""));
        mKategorija.addAll(kategorije);
        notifyDataSetChanged();
    }

    public int preselected(int kategorijaID){
        for (int i = 0; i < mKategorija.size(); i++){
            if (mKategorija.get(i).getMKategorijaId() == kategorijaID)
                return i;
        }
        return 0;
    }
}
