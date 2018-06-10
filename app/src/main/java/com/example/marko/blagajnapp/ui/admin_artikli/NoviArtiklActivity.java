package com.example.marko.blagajnapp.ui.admin_artikli;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Artikl;
import com.example.marko.blagajnapp.model.Kategorija;
import com.example.marko.blagajnapp.viewmodel.ArtiklViewModel;
import com.example.marko.blagajnapp.viewmodel.KategorijaViewModel;

import java.util.ArrayList;
import java.util.List;

public class NoviArtiklActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ID = "id";

    private Toolbar toolbar;
    private EditText etNazivArtikla;
    private EditText etCijenaArtikla;
    private Spinner spinKategorija;
    private Button btnDodajArtikl;
    private SpinnerAdapter mSpinnerAdapter;
    private ArtiklViewModel artiklModel;
    private KategorijaViewModel kategorijaModel;
    private Artikl artiklZaEdit;
    private Kategorija odabranaKategroija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novi_artikl_activity);
        setUpUI();

        artiklModel = ViewModelProviders.of(this).get(ArtiklViewModel.class);
        kategorijaModel = ViewModelProviders.of(this).get(KategorijaViewModel.class);

        kategorijaModel.getAllKategorije().observe(this, new Observer<List<Kategorija>>() {
            @Override
            public void onChanged(@Nullable List<Kategorija> kategorije) {
                mSpinnerAdapter.setmKategorija(kategorije);
                if (artiklZaEdit != null){
                    spinKategorija.setSelection(mSpinnerAdapter.preselected(artiklZaEdit.getKategorija()));
                }
            }
        });

        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(ID)){
            artiklModel.getArtiklByID(getIntent().getIntExtra(ID,0)).observe(this, new Observer<Artikl>() {
                @Override
                public void onChanged(@Nullable Artikl artikl) {
                    artiklZaEdit = artikl;
                    etCijenaArtikla.setText(String.valueOf(artikl.getMCijena()));
                    etNazivArtikla.setText(artikl.getMNaziv());
                    if (mSpinnerAdapter.getCount() > 0)
                        spinKategorija.setSelection(mSpinnerAdapter.preselected(artiklZaEdit.getKategorija()));
                }
            });
        }
    }

    private void setUpUI(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.etNazivArtikla = (EditText) findViewById(R.id.etNazivArtikla);
        this.etCijenaArtikla = (EditText) findViewById(R.id.etCijenaArtikla);
        this.spinKategorija = (Spinner) findViewById(R.id.spinKategorija);
        this.btnDodajArtikl = (Button) findViewById(R.id.btnDodajArtikl);
        this.btnDodajArtikl.setOnClickListener(this);

        mSpinnerAdapter = new SpinnerAdapter(new ArrayList<Kategorija>());
        spinKategorija.setAdapter(mSpinnerAdapter);
        spinKategorija.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                odabranaKategroija = (Kategorija) mSpinnerAdapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!TextUtils.isEmpty(etCijenaArtikla.getText()) && !TextUtils.isEmpty(etNazivArtikla.getText()) &&
                odabranaKategroija != null && !TextUtils.isEmpty(odabranaKategroija.getNazivKategorije())){
            if (artiklZaEdit != null){
                artiklZaEdit.setMCijena(Float.valueOf(etCijenaArtikla.getText().toString()));
                artiklZaEdit.setMNaziv(etNazivArtikla.getText().toString());
                artiklZaEdit.setKategorija(odabranaKategroija.getMKategorijaId());
                artiklZaEdit.setMkategorijaNaziv(odabranaKategroija.getNazivKategorije());
                artiklModel.updateArtikl(artiklZaEdit);
            } else {
                artiklModel.insertArtikl(new Artikl(etNazivArtikla.getText().toString(), Float.valueOf(etCijenaArtikla.getText().toString()),
                        odabranaKategroija.getMKategorijaId(),odabranaKategroija.getNazivKategorije()));
                Toast.makeText(NoviArtiklActivity.this, "Artikl je uspješno dodan!",Toast.LENGTH_SHORT).show();
            }
            finish();
        }
    }
}
