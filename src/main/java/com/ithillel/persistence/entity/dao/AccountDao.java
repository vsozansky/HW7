package com.ithillel.persistence.entity.dao;

import com.ithillel.persistence.entity.AccountEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.FileNotFoundException;

@Repository
public class AccountDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Integer createAccount(final AccountEntity accountEntity) {
        entityManager.persist(accountEntity);
         return accountEntity.getId();
    }

    public AccountEntity getById(Integer id) {
        return entityManager.find(AccountEntity.class, id);
    }
}
