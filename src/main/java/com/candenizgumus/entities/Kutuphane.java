package com.candenizgumus.entities;

import com.candenizgumus.enums.Durum;
import com.candenizgumus.utils.Util;

import java.util.ArrayList;
import java.util.HashMap;

public class Kutuphane
{

    //region DataBase
    public static ArrayList<Uye> uyeArrayList = new ArrayList<>();
    public static ArrayList<Kitap> kitapListesi = new ArrayList<>();
    public static HashMap<Kitap, Uye> oduncVerilenKitaplar = new HashMap<>();
    //endregion

    /**
     * Kutuphane DataBase'ine kitap ekler.
     * @param kitap Eklenecek olan kitap.
     */
    public void kitapEkle(Kitap kitap)
    {

        kitapListesi.add(kitap);
    }

    /**
     * Kutuphane DataBase'ine uye ekler.
     * @param uye Eklenecek olan uye.
     */
    public void uyeEkle(Uye uye)
    {

        uyeArrayList.add(uye);
    }

    /**
     * Kullanıcıdan alınan inputlar ile uye oluşturur ve Kutuphane DataBase'ine ekler.
     */
    public void register()
    {

        String isim = Util.getStringValue("İsminizi giriniz");
        String kullaniciAdi = Util.getStringValue("Kullanici adi giriniz");
        String sifre = Util.getStringValue("Sifre Giriniz");
        Uye uye = new Uye(isim, kullaniciAdi, sifre);
        uyeEkle(uye);
    }

    /**
     * Kullanıcıdan alınan inputlar ile sisteme uye olarak giriş yapar.
     * @return Giris yapan uyeyi doner.
     */
    public Uye login()
    {

        String kullaniciAdi = Util.getStringValue("Kullanici adi giriniz");
        String sifre = Util.getStringValue("Sifre Giriniz");
        Uye uye = uyeBul(kullaniciAdi, sifre);
        if (uye != null)
        {
            return uye;
        }
        else
        {
            System.out.println("Kullanici adi veya sifre hatali");
            return null;
        }
    }

    /**
     * Kutuphane DataBase'inde uye arar.
     * @param kullaniciAdi Aranan uyenin kullanici adi.
     * @param sifre Aranan uyenin sifresi.
     * @return Uye doner.
     */
    private Uye uyeBul(String kullaniciAdi, String sifre)
    {

        for (Uye uye : uyeArrayList)
        {
            if (kullaniciAdi.equals(uye.getKullaniciAdi()) && sifre.equals(uye.getSifre()))
            {
                return uye;
            }
        }

        return null;

    }



    /**
     * Kullanıcıdan alınan input ile durumu değiştirilmek istenen kitabı bulur ve durumunu günceller.
     */
    public void kitapDurumunuDegistir()
    {

        kitaplariGoruntule();
        String isbn = Util.getStringValue("Durumunu değiştirmek istediğiniz kitabın ISBN nosunu giriniz");
        Kitap bulunanKitap = kitapBul(isbn);
        if (bulunanKitap == null)
        {
            System.out.println("Girdiğiniz ISBN no ile kitap bulunmamaktadır.");
            return;
        }
        System.out.println("1- Odunc Alinabilir");
        System.out.println("2- Odunc Verildi");
        System.out.println("3- Mevcut Degil");
        int secim = Util.getIntegerValue("Seçiminizi giriniz");
        inputIleKitapDurumDegistirme(secim, bulunanKitap);
        System.out.println("Kitap durumu başarıyla değiştirildi.");
    }

    /**
     * Kullanıcının yaptıgı secimlere gore kitabin durumunu degistirir.
     * @param secim Kullanicinin yaptigi secim.
     * @param bulunanKitap Durumu guncellenecek olan kitap.
     */
    private void inputIleKitapDurumDegistirme(int secim, Kitap bulunanKitap)
    {

        switch (secim)
        {
            case 1:
                bulunanKitap.setDurum(Durum.ODUNC_ALINABILIR);
                break;
            case 2:
                bulunanKitap.setDurum(Durum.ODUNC_VERILDI);
                break;
            case 3:
                bulunanKitap.setDurum(Durum.MEVCUT_DEGIL);
                break;
            default:
                System.out.println("Yanlıs secim yaptiniz tekrar deneyiniz.");
                break;
        }
    }

    /**
     * Kutuphane DataBase'inde girilen ISBN no ile kitap arar.
     * @param isbn Aranan kitabın ISBN no'su.
     * @return Kitap doner.
     */
    private Kitap kitapBul(String isbn)
    {

        for (Kitap kitap : Kutuphane.kitapListesi)
        {
            if (isbn.equals(kitap.getISBN()))
            {
                return kitap;
            }
        }

        return null;

    }

    /**
     * Kutuphane DataBase'indeki butun kitaplari goruntuler.
     */
    public void kitaplariGoruntule()
    {

        Kutuphane.kitapListesi.forEach(System.out::println);
    }

    /**
     * Kutuphane DataBase'indeki butun uyeleri goruntuler.
     */
    public void uyeleriGoster()
    {
        Kutuphane.uyeArrayList.forEach(System.out::println);

    }

    /**
     * Kutuphane DataBase'indeki butun odunc verilmiş kitaplari goruntuler.
     */
    public void oduncAlinanKitaplariGoster()
    {
        Kutuphane.oduncVerilenKitaplar.forEach(((kitap, uye) -> System.out.println(kitap + " " + uye.getIsim() + " adlı üye tarafından ödünç alınmıstır.")));

    }
}
