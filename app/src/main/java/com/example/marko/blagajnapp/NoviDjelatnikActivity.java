package com.example.marko.blagajnapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class NoviDjelatnikActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etImeDjelatnika;
    private EditText etPrezimeDjelatnika;
    private EditText etOIBDjelatnika;
    private Button btnDodajDjelatnika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novi_djelatnik_activity);
        setUpUI();
    }

    private void setUpUI(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.etUsername = (EditText) findViewById(R.id.etUsername);
        this.etPassword = (EditText) findViewById(R.id.etPassword);
        this.etImeDjelatnika = (EditText) findViewById(R.id.etImeDjelatnika);
        this.etPrezimeDjelatnika = (EditText) findViewById(R.id.etPrezimeDjelatnika);
        this.etOIBDjelatnika = (EditText) findViewById(R.id.etOIB);
        this.btnDodajDjelatnika = (Button) findViewById(R.id.btnDodajDjelatnika);
        this.btnDodajDjelatnika.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //razraditi logiku za spremanje djelatnika u bazu
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

    //implementirati metodu dodajDjelatnika();
}
