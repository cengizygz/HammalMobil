package com.example.firebasego.model;

public class Post {
    public String adres ;
    public String deneyim ;
    public String iletisim ;
    public String imageUrl ;
    public String isim ;
    public String meslek;
    public String ogretim ;
    public String tanit ;
    public String yas ;
    public String calismasaat ;

    public Post(String adres, String deneyim, String iletisim, String imageUrl, String isim, String meslek, String ogretim, String tanit, String yas, String calismasaat) {
        this.adres = adres;
        this.deneyim = deneyim;
        this.iletisim = iletisim;
        this.imageUrl = imageUrl;
        this.isim = isim;
        this.meslek = meslek;
        this.ogretim = ogretim;
        this.tanit = tanit;
        this.yas = yas;
        this.calismasaat = calismasaat;
    }
}
