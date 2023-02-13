package com.yavuz.service;

import com.yavuz.repository.KisiRepository;
import com.yavuz.repository.entity.Kisi;
import com.yavuz.utility.MyFactoryService;

import java.util.List;

public class KisiService extends MyFactoryService<KisiRepository, Kisi,Long> {
    public KisiService() {
        super(new KisiRepository());
    }

    public List<Kisi> getCustomersWhoRentedCars(List<Long> customerIds){
        return getRepository().getCustomersWhoRentedCars(customerIds);
    }
}
