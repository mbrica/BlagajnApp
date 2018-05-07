package com.example.marko.blagajnapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity {

    private final String KATEGORIJA_FRAGMENT = "Kategorija";
    private final String ARTIKL_FRAGMENT = "Artikl";
    private final String RACUN_FRAGMENT = "Racuna";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUpFragments();
    }


    //Postavljanje fragmenata na sučelje
    private void setUpFragments(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flKategorije, new KategorijaFragment(),this.KATEGORIJA_FRAGMENT);
        fragmentTransaction.add(R.id.flArtikli, new ArtiklFragment(), this.ARTIKL_FRAGMENT);
        fragmentTransaction.add(R.id.flRacun, new RacunFragment(), this.RACUN_FRAGMENT);
        fragmentTransaction.commit();
    }

    //Metode za menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = this.getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //Pogledati valja li ovako ?
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuItemLogout:
                this.logout();
                return true;
        }
        return false;
    }

    //na developers.android piše da mora biti public
    public void logout(){
        //implementirati logiku za odjavu usera
    }
}
