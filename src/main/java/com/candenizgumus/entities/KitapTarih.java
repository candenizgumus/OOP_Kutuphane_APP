package com.candenizgumus.entities;

import com.candenizgumus.enums.Durum;

public class KitapTarih extends Kitap
{

    private String tur;

    private Durum durum;



    /**
     * Örnek parametre girdileri aşağıdaki gibidir. Belirtilen formata göre girdiler girilmelidir.
     *
     * @param baslik    "Kozmos"
     * @param yazar     "Charles Darwin"
     * @param yayinYili "1859-10-24"  (yyyy-MM-dd)
     */
    public KitapTarih(String baslik, String yazar, String yayinYili)
    {

        super(baslik, yazar, yayinYili);
        this.tur = "Tarih";
        durum = Durum.ODUNC_ALINABILIR;
    }

    @Override
    public String toString()
    {

        return "ISBN='" + getISBN() + '\'' + ", baslik='" + getBaslik() + '\'' + ", yazar='" + getYazar() + '\'' + "," +
                " yayinYili='" + getYayinYili() + '\'' + ", tur='" + tur + '\'' + ", durum=" + durum +  '}';
    }


    public Durum getDurum()
    {

        return durum;
    }

    public void setDurum(Durum durum)
    {

        this.durum = durum;
    }

    public String getTur()
    {

        return tur;
    }

    public void setTur(String tur)
    {

        this.tur = tur;
    }
}
