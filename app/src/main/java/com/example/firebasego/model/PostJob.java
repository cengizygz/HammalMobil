package com.example.firebasego.model;

public class PostJob {
    public String adres ;
    public String imageUrl ;
    public String isim ;
    public String meslek;


    public PostJob(String adres, String imageUrl, String isim, String meslek) {
        this.adres = adres;
        this.imageUrl = imageUrl;
        this.isim = isim;
        this.meslek = meslek;
    }
}
