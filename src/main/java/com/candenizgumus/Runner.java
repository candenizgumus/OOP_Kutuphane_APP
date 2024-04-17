package com.candenizgumus;

import com.candenizgumus.entities.Kitap;
import com.candenizgumus.entities.KitapBilim;
import com.candenizgumus.entities.Kutuphane;
import com.candenizgumus.entities.Uye;
import com.candenizgumus.managers.UyeManager;
import com.candenizgumus.utils.Util;

public class Runner
{

    static Kutuphane kutuphane = new Kutuphane();
    static UyeManager uyeManager = new UyeManager();

    public static void main(String[] args)
    {
        //region sisteme data ekleme
        Kitap kitapBilim1 = new KitapBilim("Türlerin Kökeni", "Charles Darwin", "1859-10-24");
        Kitap kitapBilim2 = new KitapBilim("Kozmos", "Carl Sagan", "1980-05-02");
        Kitap kitapRoman1 = new KitapBilim("Suç ve Ceza", "Fyodor Dostoyevski", "1866-12-01");
        Kitap kitapRoman2 = new KitapBilim("Kürk Mantolu Madonna", "Sabahattin Ali", "1943-01-06");
        Kitap kitapTarih1 = new KitapBilim("Nutuk", "Mustafa Kemal Atatürk", "1927-09-11");
        Kitap kitapTarih2 = new KitapBilim("Zeytindağı", "Falih Rıfkı Atay", "1932-11-06");
        kutuphane.kitapEkle(kitapBilim1);
        kutuphane.kitapEkle(kitapBilim2);
        kutuphane.kitapEkle(kitapRoman1);
        kutuphane.kitapEkle(kitapRoman2);
        kutuphane.kitapEkle(kitapTarih1);
        kutuphane.kitapEkle(kitapTarih2);
        Uye uye1 = new Uye("Can Deniz Gumus", "deniz", "123");
        Uye uye2 = new Uye("Ahmet Veli", "ahmet", "123");
        kutuphane.uyeEkle(uye1);
        kutuphane.uyeEkle(uye2);

        //endregion
        systemMenu();
    }


    /**
     * Kullanıcı menüsü, kayıt olma ve giriş yapma işlemleri gerçekleştirilir.
     */
    public static void systemMenu()
    {

        while (true)
        {
            System.out.println("*************KUTUPHANE*************");
            System.out.println("1-Register");
            System.out.println("2-Login");
            System.out.println("3-Sistemi Kapat");
            int islem = Util.getIntegerValue("Yapmak istediğiniz işlemi giriniz");
            switch (islem)
            {
                case 1:
                    kutuphane.register();
                    break;
                case 2:
                    Uye loggedUser = kutuphane.login();
                    if (loggedUser != null)
                    {
                        uyeMenu(loggedUser);
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;

            }
        }
    }

    /**
     * Uyenin yapabileceği işlemler tanımlanmıştır.
     * @param loggedUser Giriş yapmış olan uye.
     */
    public static void uyeMenu(Uye loggedUser)
    {
        while (true)
        {
            System.out.println("1-Kitap Ödünç Al");
            System.out.println("2-Kitap İade Et");
            System.out.println("3-Kitap Mevcut Durumunu Değiştir");
            System.out.println("4-Bir Üyenin Ödünç Aldığı Kitapları Görüntüle");
            System.out.println("5-Bütün Kitapları Görüntüle");
            System.out.println("6-Bütün Ödünç Alınan Kitapları Görüntüle");
            System.out.println("7-Bütün Üyeleri Görüntüle");
            System.out.println("8-Üst Menü");
            int islem = Util.getIntegerValue("Yapmak istediğiniz işlemi giriniz");
            switch (islem)
            {
                case 1:
                    uyeManager.kitapOduncAl(loggedUser);
                    break;
                case 2:
                    uyeManager.kitapIadeEt(loggedUser);
                    break;
                case 3:
                    kutuphane.kitapDurumunuDegistir();
                    break;
                case 4:
                    uyeManager.uyeOduncKitaplariGoster();
                    break;
                case 5:
                    kutuphane.kitaplariGoruntule();
                    break;
                case 6:
                    kutuphane.oduncAlinanKitaplariGoster();
                    break;
                case 7:
                    kutuphane.uyeleriGoster();
                    break;
                case 8:
                    systemMenu();
                    break;
                default:
                    System.out.println("Yanlış tuşlama yaptınız.");
                    break;


            }
        }

    }


}
