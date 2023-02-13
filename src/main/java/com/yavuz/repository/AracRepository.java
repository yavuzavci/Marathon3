package com.yavuz.repository;

import com.yavuz.repository.entity.Arac;
import com.yavuz.utility.MyFactoryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AracRepository extends MyFactoryRepository<Arac,Long> {
    public AracRepository(){
        super(new Arac());
    }
}
