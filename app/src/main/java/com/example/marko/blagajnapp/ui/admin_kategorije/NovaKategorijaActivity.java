package com.example.marko.blagajnapp.ui.admin_kategorije;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Kategorija;
import com.example.marko.blagajnapp.viewmodel.KategorijaViewModel;

import java.util.List;

public class NovaKategorijaActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ID = "id";

    private Toolbar toolbar;
    private EditText etNazvKategorije;
    private Button btnDodajKategoriju;
    private KategorijaViewModel model;
    private Kategorija kategorijaZaEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_kategorija_activity);
        setUpUI();

        model = ViewModelProviders.of(this).get(KategorijaViewModel.class);

        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(ID)){
            model.getKategorijaByID(getIntent().getIntExtra(ID,0)).observe(this, new Observer<Kategorija>(){
                @Override
                public void onChanged(@Nullable Kategorija kategorija) {
                    kategorijaZaEdit = kategorija;
                    etNazvKategorije.setText(kategorija.getNazivKategorije());
                }
            });
        }
    }

    private void setUpUI(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.etNazvKategorije = (EditText) findViewById(R.id.etNazivKategorije);
        this.btnDodajKategoriju = (Button) findViewById(R.id.btnDodajKategoriju);
        this.btnDodajKategoriju.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!TextUtils.isEmpty(etNazvKategorije.getText())){
            if (kategorijaZaEdit != null){
                kategorijaZaEdit.setNazivKategorije(etNazvKategorije.getText().toString());
                model.updateKategorija(kategorijaZaEdit);
            } else {
                model.insertKategorija(new Kategorija(etNazvKategorije.getText().toString()));
                Toast.makeText(NovaKategorijaActivity.this, "Kategorija je uspješno dodana!",Toast.LENGTH_SHORT).show();
            }
            finish();
        }
    }
}
