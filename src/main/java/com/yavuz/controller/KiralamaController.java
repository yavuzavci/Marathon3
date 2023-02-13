package com.yavuz.controller;

import com.yavuz.repository.entity.Arac;
import com.yavuz.repository.entity.Kiralama;
import com.yavuz.repository.entity.Kisi;
import com.yavuz.service.AracService;
import com.yavuz.service.KiralamaService;
import com.yavuz.service.KisiService;

import java.util.*;
import java.util.stream.Collectors;

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
                aracService.update(arac);
                Kiralama kiralama = Kiralama.builder()
                        .aracId(aracId)
                        .kisiId(kisiId)
                        .createat(System.currentTimeMillis())
                        .updateat(System.currentTimeMillis())
                        .kiraBaslangic(new Date(System.currentTimeMillis()))
                        .kiraBitis(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 15)))
                        .build();
                kiralamaService.save(kiralama);
                System.out.println("Kiralama islemi basarili.");
            }
        } catch (Exception e){
            System.out.println("Beklenmeyen bir hata olustu : " + e.toString());
            System.out.println("İslem basarisiz.");
        }
    }

    public List<Arac> musterininKiraladigiAraclariBul(){
        System.out.print("Musterinin numarasini giriniz..: ");
        Long kisiId = Long.parseLong(scanner.nextLine());
        List<Arac> aracList = kiralamaService.getCarsByCustomerId(kisiId);
        if(aracList.isEmpty()){
            System.out.println("Musterinin kiralanmis araci veya araclari yok.");
        }
        return aracList;
    }

    public Map<Kisi, List<Arac>> musterilerinKiraladiklariAraclariBul(){
        try {
            Map<Kisi, List<Arac>> map =  kiralamaService.getAllCustomersWithRentedCars();
            if(map.isEmpty())
                System.out.println("Musteriler herhangi bir arac kiralamamis.");
            return map;
        } catch (Exception e){
            System.out.println("Beklenmeyen bir hata olustu : " + e.toString());
            return new HashMap<>();
        }
    }

    public List<Arac> kiralanabilirAraclariBul(){
        List<Arac> aracList = new ArrayList<>();
        try {
            aracList = kiralamaService.getRentableCars();
            if(aracList.isEmpty())
                System.out.println("Sistemde kiralanabilir arac yok.");
        } catch (Exception e){
            System.out.println("Beklenmeyen bir hata olustu : " + e.toString());
            return new ArrayList<>();
        }
        return aracList;
    }

    public List<Arac> kiralanmisAraclariBul(){
        List<Arac> aracList = new ArrayList<>();
        try {
            aracList = kiralamaService.getRentedCars();
            if(aracList.isEmpty())
                System.out.println("Sistemde kiralik arac yok.");
        } catch (Exception e){
            System.out.println("Beklenmeyen bir hata olustu : " + e.toString());
            return new ArrayList<>();
        }
        return aracList;
    }
}
