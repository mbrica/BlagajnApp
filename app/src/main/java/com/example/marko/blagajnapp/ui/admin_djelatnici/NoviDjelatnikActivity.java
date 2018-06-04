package com.example.marko.blagajnapp.ui.admin_djelatnici;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Djelatnik;
import com.example.marko.blagajnapp.viewmodel.DjelatnikViewModel;

public class NoviDjelatnikActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ID = "id";

    private Toolbar toolbar;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etImeDjelatnika;
    private EditText etPrezimeDjelatnika;
    private EditText etOIBDjelatnika;
    private Button btnDodajDjelatnika;
    private DjelatnikViewModel model;
    private Djelatnik djelatnikZaEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novi_djelatnik_activity);
        setUpUI();

        model = ViewModelProviders.of(this).get(DjelatnikViewModel.class);

        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(ID)){
            model.getDjelatnikByID(getIntent().getIntExtra(ID,0)).observe(this, new Observer<Djelatnik>() {
                @Override
                public void onChanged(@Nullable Djelatnik djelatnik) {
                    djelatnikZaEdit = djelatnik;
                    etUsername.setText(djelatnik.getUsername());
                    etPassword.setText(djelatnik.getPassword());
                    etImeDjelatnika.setText(djelatnik.getImeDjelatnika());
                    etPrezimeDjelatnika.setText(djelatnik.getPrezimeDjelatnika());
                    etOIBDjelatnika.setText(djelatnik.getOIB());
                }
            });
        }
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
        if (!TextUtils.isEmpty(etUsername.getText()) && !TextUtils.isEmpty(etPassword.getText()) && !TextUtils.isEmpty(etImeDjelatnika.getText()) &&
                !TextUtils.isEmpty(etPrezimeDjelatnika.getText()) && !TextUtils.isEmpty(etOIBDjelatnika.getText())) {
            if (djelatnikZaEdit != null) {
                djelatnikZaEdit.setUsername(etUsername.getText().toString());
                djelatnikZaEdit.setPassword(etPassword.getText().toString());
                djelatnikZaEdit.setImeDjelatnika(etImeDjelatnika.getText().toString());
                djelatnikZaEdit.setPrezimeDjelatnika(etPrezimeDjelatnika.getText().toString());
                djelatnikZaEdit.setOIB(etOIBDjelatnika.getText().toString());
                model.updateDjelatnik(djelatnikZaEdit);
            } else {
                model.insertDjelatnik(new Djelatnik(etUsername.getText().toString(),etPassword.getText().toString(), etImeDjelatnika.getText().toString(),
                        etPrezimeDjelatnika.getText().toString(),etOIBDjelatnika.getText().toString(),Djelatnik.djelatnik));
                Toast.makeText(NoviDjelatnikActivity.this, "Djelatnik je uspješno dodan!",Toast.LENGTH_SHORT).show();
            }
            finish();
        }

    }
}
