package com.example.marko.blagajnapp.model;

public class PrikazRacunaData {

    private int racunId;
    private String vrijemeIzdavanja;
    private String iznosRacuna;
    private String imeDjelatnika;
    private String stavkeString;

    public PrikazRacunaData(int racunId, String vrijemeIzdavanja, String iznosRacuna, String imeDjelatnika, String stavkeString){
        this.racunId = racunId;
        this.vrijemeIzdavanja = vrijemeIzdavanja;
        this.iznosRacuna = iznosRacuna;
        this.imeDjelatnika = imeDjelatnika;
        this.stavkeString = stavkeString;
    }

    public int getRacunId(){
        return racunId;
    }

    public String getVrijemeIzdavanja() {
        return vrijemeIzdavanja;
    }

    public String getIznosRacuna() {
        return iznosRacuna;
    }

    public String getImeDjelatnika() {
        return imeDjelatnika;
    }

    public String getStavkeString() {
        return stavkeString;
    }

    public void setStavkeString(String stavkeString) {
        this.stavkeString = stavkeString;
    }
}
