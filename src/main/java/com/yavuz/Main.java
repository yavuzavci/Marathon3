package com.yavuz;

import com.yavuz.controller.AracController;
import com.yavuz.controller.KiralamaController;
import com.yavuz.controller.KisiController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        anaMenu();
    }

    private static void anaMenu() {
        int secim;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("**************************************");
            System.out.println("****** ARAC KIRALAMA UYGULAMASI ******");
            System.out.println("**************************************");
            System.out.println();
            System.out.println("1- Arac Ekle");
            System.out.println("2- Arac Bul");
            System.out.println("3- Kisi Ekle");
            System.out.println("4- Kiralama Yap");
            System.out.println("5- Raporlamalar");
            System.out.println("0- CIKIS YAP");
            System.out.print("Seciniz...: ");
            secim = sc.nextInt();
            switch (secim){
                case 1:
                    new AracController().aracEkle();
                    break;
                case 2:
                    new AracController().aracBul();
                    break;
                case 3:
                    new KisiController().kisiEkle();
                    break;
                case 4:
                    new KiralamaController().kirala();
                    break;
                case 5:
                    raporlamaMenusu();
                    break;
                default:
                    break;
            }
        } while (secim != 0);
        System.out.println("UYGULAMA SONLANDIRILDI.");
    }

    private static void raporlamaMenusu(){
        int secim;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("**************************************");
            System.out.println("********** RAPORLAMA MENUSU **********");
            System.out.println("**************************************");
            System.out.println();
            System.out.println("1- Su An Kiralanmis Araclar");
            System.out.println("2- Bostaki Araclar");
            System.out.println("3- Herhangi Bir Musterinin Kiraladigi Araclar");
            System.out.println("4- Musterilerin Kiraladiklari Araclar");
            System.out.println("0- <<< Geri Don");
            System.out.print("Seciniz...: ");
            secim = sc.nextInt();
            switch (secim){
                case 1:
                    new KiralamaController().kiralanmisAraclariBul()
                            .forEach(System.out::println);
                    break;
                case 2:
                    new KiralamaController().kiralanabilirAraclariBul()
                            .forEach(System.out::println);
                    break;
                case 3:
                    new KiralamaController().musterininKiraladigiAraclariBul()
                            .forEach(System.out::println);
                    break;
                case 4:
                    new KiralamaController().musterilerinKiraladiklariAraclariBul()
                            .forEach((kisi,araclar) -> {
                                System.out.println(kisi);
                                araclar.forEach(System.out::println);
                            });
                    break;
                default:
                    break;
            }
        } while (secim != 0);
    }
}