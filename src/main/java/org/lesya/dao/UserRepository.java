package org.lesya.dao;

import jakarta.persistence.EntityManager;
import org.lesya.entity.User;

public class UserRepository extends RepositoryBase<Integer, User>{
    public UserRepository(EntityManager entityManager) {
        super(User.class, entityManager);
    }
}
