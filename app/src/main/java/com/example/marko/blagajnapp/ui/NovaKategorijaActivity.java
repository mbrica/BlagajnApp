package com.example.marko.blagajnapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marko.blagajnapp.R;

public class NovaKategorijaActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private EditText etNazvKategorije;
    private Button btnDodajKategoriju;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_kategorija_activity);
        setUpUI();
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
        //spremanje kategorije u bazu podataka
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
