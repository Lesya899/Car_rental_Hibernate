package org.lesya.dao;

import jakarta.persistence.EntityManager;
import org.lesya.entity.Rent;

public class RentRepository extends RepositoryBase<Integer, Rent> {
    public RentRepository(EntityManager entityManager) {
        super(Rent.class, entityManager);
    }
}
