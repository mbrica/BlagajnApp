package com.example.marko.blagajnapp.ui;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.marko.blagajnapp.R;
import com.example.marko.blagajnapp.room.BlagajnAppDatabase;
import com.example.marko.blagajnapp.ui.admin_artikli.TabArtikli;
import com.example.marko.blagajnapp.ui.admin_kategorije.TabKategorije;
import com.example.marko.blagajnapp.ui.djelatnici.TabDjelatnici;

public class AdminActivity extends AppCompatActivity {

    Toolbar toolbar;

    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager mViewPAger;

    public static BlagajnAppDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

        mViewPAger = (ViewPager) findViewById(R.id.viewpager);
        setUpViewPager(mViewPAger);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tltabovi);
        tabLayout.setupWithViewPager(mViewPAger);
    }

    private void setUpViewPager(ViewPager viewPager){
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabRacuni(),"Računi");
        adapter.addFragment(new TabDjelatnici(), "Djelatnici");
        adapter.addFragment(new TabKategorije(),"Kategorije");
        adapter.addFragment(new TabArtikli(),"Artikli");
        viewPager.setAdapter(adapter);
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
