package org.lesya.dao;


import jakarta.persistence.EntityManager;
import org.lesya.entity.Model;

public class ModelRepository extends RepositoryBase<Integer, Model>{
    public ModelRepository(EntityManager entityManager) {
        super(Model.class, entityManager);
    }
}
