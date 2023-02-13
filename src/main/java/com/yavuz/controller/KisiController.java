package com.yavuz.controller;

import com.yavuz.repository.entity.Kisi;
import com.yavuz.service.KisiService;

import java.util.Scanner;

public class KisiController {
    private KisiService kisiService;
    private Scanner scanner;
    public KisiController() {
        kisiService = new KisiService();
        scanner = new Scanner(System.in);
    }

    public void kisiEkle(){
        System.out.println("Musterinin adini giriniz.");
        String ad = scanner.nextLine();
        System.out.println("Musterinin telefon numarasini giriniz.");
        String telefon = scanner.nextLine();
        System.out.println("Musterinin mail adresini giriniz.");
        String email = scanner.nextLine();
        try{
            Kisi kisi = Kisi.builder()
                    .ad(ad)
                    .telefon(telefon)
                    .email(email)
                    .createat(System.currentTimeMillis())
                    .updateat(System.currentTimeMillis())
                    .build();
            kisiService.save(kisi);
            System.out.println("Kisi sisteme basariyla eklendi. Kisi no : " + kisi.getId());
        } catch (Exception e){
            System.out.println("Beklenmeyen bir hata olustu : " + e.toString());
            System.out.println("İslem basarisiz.");
        }

    }
}
