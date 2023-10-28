package com.example.javaegitimleri.nesne_tabanli;

public class Odev {
Double km ;
    public Double KmDonustur(double km){
    double mil = km * 0.621;
    return mil;
}
int a;
    int b;

    public Integer AlanHesapla(int a,int b){
        int alan = a*b;
        return alan;
    }

    public Integer Faktoriyel(int sayi){
        if (sayi < 0){
            System.out.println("Sayı Tanımsızdır");
        }
int faktoriyel = 1;
        for (int i = 1; i <= sayi; i++) {
            faktoriyel = faktoriyel * i;
        }
        return faktoriyel;

    }

    public Integer HarfBul(String kelime , char harf ){
       int harfSayi = kelime.length();
       int sayi = 0;
        for (int i = 0; i < harfSayi; i++) {
            if (kelime.charAt(i) == harf) {
                sayi ++;
            }
        }
       return sayi;
    }

    public Integer IcAci(int a ){
        int icAci = ((a-2)*180)/a;
        return icAci;
    }
public Double Maas (int gun){
        int calisma = 40;
        int mesai =80;
        int csaat = 8 * gun;
        if (csaat <= 150 ){
            double maas = csaat * calisma;
            return maas;
        }else {
            int mesaii = csaat -150 ;
            double maas = (csaat * calisma) + (mesaii * mesai);
            return  maas;
        }
}
 public Double Otopark(int a){
     double ucret = 50.0;
     double ekucret =10.0;
     if (a < 1 ){
         return 0.0;
     } else if (a == 1) {
         return ucret;
     }else {
         double hesap = ucret;
         for (int i = 1; i < a; i++) {
             hesap += ekucret;
         }
         return hesap;
     }
 }
}
