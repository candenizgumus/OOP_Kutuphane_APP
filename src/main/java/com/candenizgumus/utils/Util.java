package com.candenizgumus.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Util
{

    static Scanner scanner = new Scanner(System.in);

    /**
     * Kullanıcıya soru sorar ve aldığı sonucu döndürür.
     *
     * @param input Kullanıcıya soracağınız soruyu giriniz.
     * @return Kullanıcının cevabını String olarak döndürür.
     */
    public static String getStringValue(String input)
    {

        System.out.println(input);
        return scanner.nextLine();
    }

    /**
     * Kullanıcıya soru sorar ve aldığı sonucu döndürür.
     * Hatalı girdi aldığında tekrar girdi ister.
     * @param input Kullanıcıya soracağınız soruyu giriniz.
     * @return Kullanıcının cevabını double olarak döndürür.
     */
    public static double getDoubleValue(String input)
    {
        while (true)
        {
            try
            {
                System.out.println(input);
                double deger = scanner.nextDouble();
                scanner.nextLine();
                return deger;
            } catch (InputMismatchException e)
            {
                System.out.println("Yanlış tipte girdi girildi. Tekrar Deneyiniz.");
                scanner.nextLine();
            }
        }
    }

    /**
     * Kullanıcıya soru sorar ve aldığı sonucu döndürür.
     * Hatalı girdi aldığında tekrar girdi ister.
     * @param input Kullanıcıya soracağınız soruyu giriniz.
     * @return Kullanıcının cevabını int olarak döndürür.
     */
    public static int getIntegerValue(String input)
    {
        while (true)
        {
            try
            {
                System.out.println(input);
                int deger = scanner.nextInt();
                scanner.nextLine();
                return deger;
            } catch (InputMismatchException e)
            {
                System.out.println("Yanlış tipte girdi girildi. Tekrar Deneyiniz.");
                scanner.nextLine();
            }
        }

    }



}
