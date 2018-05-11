package com.example.marko.blagajnapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NoviArtiklActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private EditText etNazivArtikla;
    private EditText etCijenaArtikla;
    private Spinner spinKategorija;
    private Button btnDodajArtikl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novi_artikl_activity);
        setUpUI();
    }

    private void setUpUI(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.etNazivArtikla = (EditText) findViewById(R.id.etNazivArtikla);
        this.etCijenaArtikla = (EditText) findViewById(R.id.etCijenaArtikla);
        this.spinKategorija = (Spinner) findViewById(R.id.spinKategorija);
        this.btnDodajArtikl = (Button) findViewById(R.id.btnDodajArtikl);
        this.btnDodajArtikl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //funkcija za spremanje artikla u bazu
    }

    //sljedeće dvije metode su potrebne za prikaz i funkcioniranje menua
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuItemLogout:
                Toast.makeText(this,"Kliknuta odjava",Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
