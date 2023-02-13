package com.yavuz.service;

import com.yavuz.repository.KiralamaRepository;
import com.yavuz.repository.entity.Arac;
import com.yavuz.repository.entity.Kiralama;
import com.yavuz.repository.entity.Kisi;
import com.yavuz.utility.MyFactoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KiralamaService extends MyFactoryService<KiralamaRepository, Kiralama,Long> {
    private AracService aracService;
    private KisiService kisiService;
    public KiralamaService() {
        super(new KiralamaRepository());
        aracService = new AracService();
        kisiService = new KisiService();
    }

    public List<Arac> getRentableCars(){
        List<Arac> aracList = aracService.findAll()
                .stream()
                .filter(a -> !a.getKiralikMi())
                .collect(Collectors.toList());
        return aracList;
    }

    public List<Arac> getRentedCars(){
        List<Long> aracIdList = getCarIds();
        List<Arac> aracList = new ArrayList<>();
        aracIdList.forEach(id -> {
            Arac arac = aracService.findById(id).get();
            aracList.add(arac);
        });
        return aracList;
    }

    public List<Kisi> getCustomersWhoRentedCars(){
        List<Long> customerIds = getCustomerIds();
        return kisiService.getCustomersWhoRentedCars(customerIds);
    }

    public List<Long> getCarIds(){
        return getRepository().getCarIds();
    }

    public List<Long> getCustomerIds(){
        return getRepository().getCustomerIds();
    }

    public Map<Kisi,List<Arac>> getAllCustomersWithRentedCars(){
        Map<Kisi,List<Arac>> kisilerVeAraclar = new HashMap<>();
        try{
            List<Kisi> kisiler = getCustomersWhoRentedCars();
            kisiler.forEach(k -> {
                if(!kisilerVeAraclar.containsKey(k)){
                    kisilerVeAraclar.put(k,getCarsByCustomerId(k.getId()));
                }
            });
        } catch (Exception e){
            System.out.println("Beklenmeyen bir hata oldu : " + e.toString());
        }
        return kisilerVeAraclar;
    }

    public List<Long> getCarIdsByCustomerId(Long customerId){
        return getRepository().getCarIdsByCustomerId(customerId);
    }

    public List<Arac> getCarsByCustomerId(Long customerId){
        List<Arac> aracList = new ArrayList<>();

        try{
            List<Long> aracIdList = getCarIdsByCustomerId(customerId);
            aracIdList.forEach(id -> {
                Arac arac = aracService.findById(id).get();
                aracList.add(arac);
            });
        } catch (Exception e){
            System.out.println("Beklenmeyen bir hata olustu : " + e.toString());
        }

        return aracList;
    }
}
