package com.yavuz.repository;

import com.yavuz.repository.entity.Kisi;
import com.yavuz.utility.MyFactoryRepository;

public class KisiRepository extends MyFactoryRepository<Kisi,Long> {
    public KisiRepository() {
        super(new Kisi());
    }
}
