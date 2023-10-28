package com.example.javaegitimleri.nesne_tabanli;

public class OdevMain {
    public static void main(String[] args) {
        Odev km = new Odev();
        double sonuc = km.KmDonustur(20.0);
        System.out.println("Sonuc: " + sonuc);


        Odev ahesap = new Odev();
        int sonuc2 = ahesap.AlanHesapla(10,20);
        System.out.println("Sonuc2: "+sonuc2);


        Odev fak = new Odev();
        int sonuc3 = fak.Faktoriyel(5);
        System.out.println("Sonuc3: "+sonuc3);

        Odev hsayi = new Odev();
        int sonuc4 = hsayi.HarfBul("YekbunDemir", 'e');
        System.out.println("Sonuc4: "+sonuc4);

        Odev ihesap = new Odev();
        int sonuc5 = ihesap.IcAci(10);
        System.out.println("Sonuc5: "+sonuc5);

Odev maasHesapla = new Odev();
double sonuc6 = maasHesapla.Maas(10);
        System.out.println("Sonuc6: "+sonuc6);

        Odev Park = new Odev();
        double sonuc7 = Park.Otopark(10);
        System.out.println("Sonuc7: "+sonuc7);
    }
}
