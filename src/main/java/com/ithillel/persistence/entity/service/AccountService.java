package com.ithillel.persistence.entity.service;

import com.ithillel.persistence.entity.AccountEntity;
import com.ithillel.persistence.entity.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional
    public Integer create(final AccountEntity accountEntity) {
       return accountDao.createAccount(accountEntity);
    }

    //@Transactional
    public AccountEntity getById(Integer id) {
        AccountEntity accountEntity = accountDao.getById(id);
        accountEntity.getClients().size();
        return accountEntity;
    }
}
