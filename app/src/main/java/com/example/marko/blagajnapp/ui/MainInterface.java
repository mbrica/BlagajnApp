package com.example.marko.blagajnapp.ui;

import com.example.marko.blagajnapp.model.Artikl;
import com.example.marko.blagajnapp.model.Kategorija;

public interface MainInterface {

    void prikaziArtikle(Kategorija kategorija);
    void dodajNaRacun(Artikl artikl);
}
