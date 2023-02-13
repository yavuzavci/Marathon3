package com.yavuz.repository;

import com.yavuz.repository.entity.Kiralama;
import com.yavuz.utility.MyFactoryRepository;

public class KiralamaRepository extends MyFactoryRepository<Kiralama,Long> {
    public KiralamaRepository(){
        super(new Kiralama());
    }
}
