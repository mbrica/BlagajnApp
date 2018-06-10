package com.example.marko.blagajnapp.ui;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.model.Artikl;
import com.example.marko.blagajnapp.model.Kategorija;
import com.example.marko.blagajnapp.ui.djelatnik_artikl.ArtiklFragment;
import com.example.marko.blagajnapp.ui.djelatnik_kategorija.KategorijaFragment;
import com.example.marko.blagajnapp.ui.djelatnik_racun.RacunFragment;

public class MainActivity extends AppCompatActivity implements MainInterface {

    private final String KATEGORIJA_FRAGMENT = "Kategorija";
    private final String ARTIKL_FRAGMENT = "Artikl";
    private final String RACUN_FRAGMENT = "Racun";
    public final static String DJELATNIK = "djelatnik";
    public final static String IME_DJELATNIKA = "imeDjelatnika";

    private Toolbar toolbar;
    private KategorijaFragment kategorijaFragment;
    private ArtiklFragment artiklFragment;
    private RacunFragment racunFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.setUpFragments();

    }

    //Postavljanje fragmenata na sučelje
    private void setUpFragments(){
        kategorijaFragment = new KategorijaFragment();
        kategorijaFragment.setMainInterface(this);
        artiklFragment = new ArtiklFragment();
        artiklFragment.setMainInterface(this);
        racunFragment = new RacunFragment();
        racunFragment.setDjelatnik(getIntent().getIntExtra(DJELATNIK, -1));
        racunFragment.setImeDjelatnika(getIntent().getStringExtra(IME_DJELATNIKA));
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flKategorije, kategorijaFragment,this.KATEGORIJA_FRAGMENT);
        fragmentTransaction.add(R.id.flArtikli, artiklFragment, this.ARTIKL_FRAGMENT);
        fragmentTransaction.add(R.id.flRacun, racunFragment, this.RACUN_FRAGMENT);
        fragmentTransaction.commit();
    }


    //Metode za menu
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
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return false;
    }

    @Override
    public void prikaziArtikle(Kategorija kategorija) {
        artiklFragment.prikaziArtikle(kategorija);
    }

    @Override
    public void dodajNaRacun(Artikl artikl) {
        racunFragment.dodajStavkuRacuna(artikl);
    }
}
