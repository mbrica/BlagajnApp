package com.example.marko.blagajnapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marko.blagajnapp.R;

public class LoginActivity extends Activity implements View.OnClickListener {

    EditText etUsername;
    EditText etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

        //pozvati funkciju login?

    }

    public void login(View view){
        //razraditi logiku za logiranje(provjera je li korisnik Admin ili Djelatnik)sssss i pozvati ovu metodu (vjv u onClick)
    }
}
