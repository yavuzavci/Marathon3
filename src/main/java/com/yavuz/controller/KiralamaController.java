package com.yavuz.controller;

import com.yavuz.repository.entity.Arac;
import com.yavuz.repository.entity.Kiralama;
import com.yavuz.repository.entity.Kisi;
import com.yavuz.service.AracService;
import com.yavuz.service.KiralamaService;
import com.yavuz.service.KisiService;

import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class KiralamaController {
    private AracService aracService;
    private KiralamaService kiralamaService;
    private KisiService kisiService;
    private Scanner scanner;
    public KiralamaController() {
        aracService = new AracService();
        kiralamaService = new KiralamaService();
        kisiService = new KisiService();
        scanner = new Scanner(System.in);
    }

    public void kirala(){
        System.out.print("Kiralamak istediginiz aracin numarasini giriniz......: ");
        Long aracId = Long.parseLong(scanner.nextLine()); // scanner bug olmasin
        System.out.print("Araci kiralayacaginiz musterinin numarasini giriniz..: ");
        Long kisiId = Long.parseLong(scanner.nextLine());
        try{
            Optional<Arac> oArac = aracService.findById(aracId);
            Optional<Kisi> oKisi = kisiService.findById(kisiId);
            if(oArac.isEmpty()){
                System.out.println("Hata : Arac sistemde kayitli degil.");
            }
            else if(oKisi.isEmpty()){
                System.out.println("Hata : Musteri sistemde kayitli degil.");
            }
            else if (!oArac.get().getKiralikMi()) {
                System.out.println("Hata : Arac zaten kiralanmis.");
            }
            else{
                Arac arac = oArac.get();
                arac.setKiralikMi(false);
                arac.setUpdateat(System.currentTimeMillis());
                Kiralama kiralama = Kiralama.builder()
                        .aracId(aracId)
                        .kisiId(kisiId)
                        .createat(System.currentTimeMillis())
                        .updateat(System.currentTimeMillis())
                        .kiraBaslangic(new Date(System.currentTimeMillis()))
                        .build();
                kiralamaService.save(kiralama);
                System.out.println("Kiralama islemi basarili.");
            }
        } catch (Exception e){
            System.out.println("Beklenmeyen bir hata olustu : " + e.toString());
            System.out.println("İslem basarisiz.");
        }
    }
}
