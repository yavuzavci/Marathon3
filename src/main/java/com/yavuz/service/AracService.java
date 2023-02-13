package com.yavuz.service;

import com.yavuz.repository.AracRepository;
import com.yavuz.repository.entity.Arac;
import com.yavuz.utility.MyFactoryService;

public class AracService extends MyFactoryService<AracRepository, Arac,Long> {
    public AracService() {
        super(new AracRepository());
    }
}
