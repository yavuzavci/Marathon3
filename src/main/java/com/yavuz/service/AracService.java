package com.yavuz.service;

import com.yavuz.repository.AracRepository;
import com.yavuz.repository.entity.Arac;
import com.yavuz.utility.MyFactoryService;

import java.util.Optional;

public class AracService extends MyFactoryService<AracRepository, Arac,Long> {
    public AracService() {
        super(new AracRepository());
    }

    public boolean existByCarName(String name){
        return getRepository().existByCarName(name);
    }

    public Optional<Arac> findByCarName(String name){
        return getRepository().findByCarName(name);
    }

}
