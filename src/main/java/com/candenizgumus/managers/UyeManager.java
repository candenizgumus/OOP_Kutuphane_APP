package com.candenizgumus.managers;

import com.candenizgumus.entities.Kitap;
import com.candenizgumus.entities.KitapBilim;
import com.candenizgumus.entities.Kutuphane;
import com.candenizgumus.entities.Uye;
import com.candenizgumus.enums.Durum;
import com.candenizgumus.interfaces.IUye;
import com.candenizgumus.utils.Util;

import java.util.Map;

public class UyeManager implements IUye
{

    /**
     * Kutuphanede stokta bulunan kitaplardan kullanicidan aldigi bilgiler ile
     * bir uyeye kitap odunc verir ve kitabın durumunu günceller.
     * @param uye Kitabı odunc alacak uyedir.
     */
    @Override
    public void kitapOduncAl(Uye uye)
    {

        oduncAlinabilirKitaplariGoruntule();
        String isbn = Util.getStringValue("Ödünç almak istediğiniz kitabın ISBN nosunu giriniz.");
        Kitap kitap = kitapBul(isbn);
        if (kitap == null)
        {
            System.out.println("Girilen ISBN no yanlıştır.");
            return;
        }
        if (kitap.getDurum() != Durum.ODUNC_ALINABILIR)
        {
            System.out.println("Stokta kitap yoktur.");
            return;
        }
        Kutuphane.oduncVerilenKitaplar.put(kitap,uye); //Kütüphane data sistemine eklenme.
        uye.getOduncAlinanKitaplar().add(kitap); //Uyenin datalarina eklenme.
        kitap.setDurum(Durum.ODUNC_VERILDI); //Kitap durum güncellemesi
        System.out.println(kitap.getBaslik() + " adlı kitap başarıyla ödünç alındı.");


    }

    /**
     * Kutuphane DataBase'inde belirtilen ISBN no ile kitabı bulur.
     * @param isbn Kitap ISBN no.
     * @return Kitap döner.
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
     * Kullanicidan aldigi bilgiler ile
     * uyenin odunc aldigi kitabı iade eder ve kitabın durumunu günceller.
     * @param uye Iade yapacak olan uye.
     */
    @Override
    public void kitapIadeEt(Uye uye)
    {
        oduncAldigimKitaplariGoruntule(uye);
        String isbn = Util.getStringValue("İade etmek istediğiniz kitabınızın ISBN nosunu giriniz.");
        Kitap oduncAlinanKitap = oduncAlinanKitabiBul(uye, isbn);
        if (oduncAlinanKitap == null)
        {
            System.out.println("Girdiğiniz ISBN no ile kitap bulunamamıştır.");
            return;
        }

        oduncAlinanKitap.setDurum(Durum.ODUNC_ALINABILIR); //Kitap durum güncellemesi.
        Kutuphane.oduncVerilenKitaplar.remove(oduncAlinanKitap,uye); //Kutuphane Odunc Alinan kitaplardan kitap kaldırıldı.
        uye.getOduncAlinanKitaplar().remove(oduncAlinanKitap); //Uye Odunc Alinan kitaplardan kaldırıldı.
        System.out.println(oduncAlinanKitap.getBaslik() + " adlı kitap başarıyla iade edildi.");

    }

    /**
     * Uyenin datalarında, odunc alinmis olan kitabı bulur.
     * @param uye Odunc alan uye
     * @param isbn Aranan kitabin ISBN no'su.
     * @return Kitap döner.
     */
    private Kitap oduncAlinanKitabiBul(Uye uye, String isbn)
    {

        for (Kitap kitap : uye.getOduncAlinanKitaplar())
        {
            if (isbn.equals(kitap.getISBN()))
            {
                return kitap;
            }
        }
        return null;

    }

    /**
     * Uyenin odunc aldiği bütün kitaplari gösterir.
     * @param uye Kitap odunc almış olan üye.
     */
    private void oduncAldigimKitaplariGoruntule(Uye uye)
    {
        uye.getOduncAlinanKitaplar().forEach(System.out::println);
    }

    /**
     * Durumu Odunc Alınabilir olan bütün kitaplari goruntuler.
     */
    public void oduncAlinabilirKitaplariGoruntule()
    {

        Kutuphane.kitapListesi.stream().filter(kitap -> kitap.getDurum() == Durum.ODUNC_ALINABILIR).forEach(System.out::println);
    }


    /**
     * Kullanıcıdan alınan input ile istenilen kullanıcının bütün ödünç aldığı kitapları görüntüler.
     */
    public void uyeOduncKitaplariGoster()
    {
        String uyeKullaniciAdi = Util.getStringValue("Odunc alinan kitaplarini gormek istediginiz uyenin kullanici adini yaziniz.");
        Uye uye = uyeBul(uyeKullaniciAdi);
        if (uye == null)
        {
            System.out.println("Yazdiginiz kullanici adi ile uye bulunamadi.");
        }
        uye.getOduncAlinanKitaplar().forEach(System.out::println);

    }

    /**
     * Kutuphane Data Base'inde belirtilen kullanici adı ile üye bulur.
     * @param uyeKullaniciAdi Aranan üyenin kullanıcı adı.
     * @return Uye döner.
     */
    private Uye uyeBul(String uyeKullaniciAdi)
    {

        for (Uye uye : Kutuphane.uyeArrayList)
        {
            if (uyeKullaniciAdi.equals(uye.getKullaniciAdi()))
            {
                return uye;
            }
        }
        return null;
    }

}
