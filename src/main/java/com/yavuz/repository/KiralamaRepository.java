package com.yavuz.repository;

import com.yavuz.repository.entity.Kiralama;
import com.yavuz.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class KiralamaRepository extends MyFactoryRepository<Kiralama,Long> {
    public KiralamaRepository(){
        super(new Kiralama());
    }

    public List<Long> getCarIds(){
        TypedQuery<Long> typedQuery = getEntityManager()
                .createNamedQuery("Kiralama.getCarIds", Long.class);
        return typedQuery.getResultList();
    }

    public List<Long> getCustomerIds(){
        TypedQuery<Long> typedQuery = getEntityManager()
                .createNamedQuery("Kiralama.getCustomerIds", Long.class);
        return typedQuery.getResultList();
    }

    public List<Long> getCarIdsByCustomerId(Long customerId){
        TypedQuery<Long> typedQuery = getEntityManager()
                .createNamedQuery("Kiralama.getCarIdsByCustomerId", Long.class);
        typedQuery.setParameter("kisiId",customerId);
        return typedQuery.getResultList();
    }
}
