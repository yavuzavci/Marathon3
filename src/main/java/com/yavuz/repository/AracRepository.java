package com.yavuz.repository;

import com.yavuz.repository.entity.Arac;
import com.yavuz.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class AracRepository extends MyFactoryRepository<Arac,Long> {
    public AracRepository(){
        super(new Arac());
    }

    public boolean existByCarName(String name){
        TypedQuery<Boolean> typedQuery = getEntityManager()
                .createNamedQuery("Arac.existByCarName", Boolean.class);
        typedQuery.setParameter("ad",name);
        return typedQuery.getSingleResult();
    }

    public Optional<Arac> findByCarName(String name){
        TypedQuery<Arac> typedQuery = getEntityManager()
                .createNamedQuery("Arac.findByCarName", Arac.class);
        typedQuery.setParameter("ad",name);
        try{
            return Optional.of(typedQuery.getSingleResult());
        } catch (Exception exception){
            return Optional.empty();
        }
    }
}
