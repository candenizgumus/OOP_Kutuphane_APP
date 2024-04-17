package com.candenizgumus.entities;

import com.candenizgumus.enums.Durum;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Kitap
{
    private String ISBN;
    private String baslik;
    private String yazar;
    private LocalDate yayinYili;


    public Kitap(String baslik, String yazar, String yayinYili)
    {

        this.ISBN = UUID.randomUUID().toString(); //her bir kitap için uuid tanımlandı.
        this.baslik = baslik;
        this.yazar = yazar;
        this.yayinYili = LocalDate.parse(yayinYili); //YayinYili LocalDate'e çevrildi.
    }

    public abstract Durum getDurum();
    public abstract void setDurum(Durum durum);


    @Override
    public String toString()
    {

        return "Kitap{" + "ISBN='" + ISBN + '\'' + ", baslik='" + baslik + '\'' + ", yazar='" + yazar + '\'' + ", yayinYili='" + yayinYili + '\'' + '}';
    }

    public String getISBN()
    {

        return ISBN;
    }

    public String getBaslik()
    {

        return baslik;
    }

    public String getYazar()
    {

        return yazar;
    }

    public LocalDate getYayinYili()
    {

        return yayinYili;
    }


}
