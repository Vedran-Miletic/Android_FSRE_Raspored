package com.example.zavrsni3;

public class Termini {


    /**
     * datum : Tue, 11 Jun 2019 00:00:00 GMT
     * id : 1
     * naslov : Programiranje 2 (kolokvij, D103 i D304)
     * pocetak : 09:00:00
     * trajanje : 1
     */

    private String datum;
    private int id;
    private String naslov;
    private String pocetak;
    private String kraj;
    private int trajanje;

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getPocetak() {
        return pocetak;
    }

    public String getKraj() {
        return kraj;
    }

    public void setPocetak(String pocetak) {
        this.pocetak = pocetak;
    }

    public void setKraj(String kraj) {
        this.kraj = pocetak;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }
}
