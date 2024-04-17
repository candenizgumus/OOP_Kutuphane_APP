package com.candenizgumus.entities;

import com.candenizgumus.managers.UyeManager;

import java.util.ArrayList;

public class Uye
{
    private static int uyeNoTotal = 1; //Her bir üye nesnesi yaratıldığında 1 arttırıldı.
    private final int uyeNo;
    private String isim;
    private String kullaniciAdi;
    private String sifre;
    private ArrayList<Kitap> oduncAlinanKitaplar;

    public Uye(String isim, String kullaniciAdi, String sifre)
    {

        this.uyeNo = uyeNoTotal++; //Her bir üyeye numara atanıp 1 artırıldı.
        this.isim = isim;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        oduncAlinanKitaplar = new ArrayList<>();
    }

    @Override
    public String toString()
    {

        return "Uye{" + "uyeNo=" + uyeNo + ", isim='" + isim + '\'' + ", kullaniciAdi='" + kullaniciAdi + '\'' + ", sifre='" + sifre + '}';
    }

    public static int getUyeNoTotal()
    {

        return uyeNoTotal;
    }

    public static void setUyeNoTotal(int uyeNoTotal)
    {

        Uye.uyeNoTotal = uyeNoTotal;
    }

    public int getUyeNo()
    {

        return uyeNo;
    }

    public String getIsim()
    {

        return isim;
    }

    public void setIsim(String isim)
    {

        this.isim = isim;
    }

    public String getKullaniciAdi()
    {

        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi)
    {

        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre()
    {

        return sifre;
    }

    public void setSifre(String sifre)
    {

        this.sifre = sifre;
    }

    public ArrayList<Kitap> getOduncAlinanKitaplar()
    {

        return oduncAlinanKitaplar;
    }

    public void setOduncAlinanKitaplar(ArrayList<Kitap> oduncAlinanKitaplar)
    {

        this.oduncAlinanKitaplar = oduncAlinanKitaplar;
    }
}
