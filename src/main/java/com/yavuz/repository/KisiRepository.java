package com.yavuz.repository;

import com.yavuz.repository.entity.Kisi;
import com.yavuz.utility.MyFactoryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class KisiRepository extends MyFactoryRepository<Kisi,Long> {
    public KisiRepository() {
        super(new Kisi());
    }

    public List<Kisi> getCustomersWhoRentedCars(List<Long> customerIds){
        return findAll().stream()
                .filter(x -> customerIds.contains(x.getId()))
                .collect(Collectors.toList());
    }
}
