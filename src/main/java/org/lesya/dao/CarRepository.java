package org.lesya.dao;

import jakarta.persistence.EntityManager;
import org.lesya.entity.Car;


public class CarRepository extends RepositoryBase<Integer, Car>{
    public CarRepository(EntityManager entityManager) {
        super(Car.class, entityManager);
    }
}
