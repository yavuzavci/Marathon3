package com.yavuz.controller;

import com.yavuz.repository.entity.Arac;
import com.yavuz.service.AracService;

import java.util.Scanner;

public class AracController {
    private AracService aracService;
    private Scanner scanner;

    public AracController() {
        aracService = new AracService();
        scanner = new Scanner(System.in);
    }

    public void aracEkle(){
        System.out.print("Aracin adini giriniz..: ");
        String ad = scanner.nextLine();
        if(aracService.existByCarName(ad)){
            System.out.println("Hata: Sistemde bu ada sahip bir arac var. Arac no : " + aracService.findByCarName(ad).get().getId());
        }
        else {
            try{
                Arac arac = Arac.builder()
                        .ad(ad)
                        .kiralikMi(true)
                        .createat(System.currentTimeMillis())
                        .updateat(System.currentTimeMillis())
                        .build();
                aracService.save(arac);
                System.out.println("Arac basariyla sisteme kaydedildi.");
            } catch (Exception e){
                System.out.println("Beklenmeyen bir hata olustu : " + e.toString());
            }
        }
    }

    public void aracBul(){
        System.out.print("Bulmak istediginiz aracin adini giriniz..: ");
        String ad = scanner.nextLine();
        try{
            if(aracService.existByCarName(ad)){
                Arac arac = aracService.findByCarName(ad).get();
                System.out.println("Arac bulundu -> " + arac);
            }
            else {
                System.out.println(ad + " adiyla aradiginiz arac sistemde kayitli degil.");
            }
        } catch (Exception e){
            System.out.println("Beklenmeyen bir hata olustu : " + e.toString());
        }
    }
}
