package com.example.marko.blagajnapp.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Djelatnik;
import com.example.marko.blagajnapp.viewmodel.DjelatnikViewModel;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername;
    EditText etPassword;
    Button btnLogin;

    DjelatnikViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        model = ViewModelProviders.of(this).get(DjelatnikViewModel.class);
        setUpUI();
    }

    private void setUpUI(){
        this.etUsername = (EditText) findViewById(R.id.etUsername);
        this.etPassword = (EditText) findViewById(R.id.etPassword);
        this.btnLogin = (Button) findViewById(R.id.BtnLogin);
        this.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Djelatnik djelatnik = model.getDjelatnik(etUsername.getText().toString(),etPassword.getText().toString());
        if (djelatnik == null){
            Toast.makeText(this,"Djelatnik ne postoji!",Toast.LENGTH_SHORT).show();
        } else if (djelatnik.getVrstaDjelatnika() == Djelatnik.admin){
            Intent intent = new Intent(this,AdminActivity.class);
            startActivity(intent);
            finish();
        } else if (djelatnik.getVrstaDjelatnika() == Djelatnik.djelatnik){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
