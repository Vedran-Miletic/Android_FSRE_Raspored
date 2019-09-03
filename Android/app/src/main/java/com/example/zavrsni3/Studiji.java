package com.example.zavrsni3;

public class Studiji {


    /**
     * godina : 1
     * id : 1
     * naziv : Racunarstvo
     * url : http://intranet.fsre.sum.ba:81/intranetfsr/teamworks.dll/calendar/calendar1/calendar?ShowSysMessages=true&urlencUTF8=true
     */

    private int godina;
    private int id;
    private String naziv;
    private String url;

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
