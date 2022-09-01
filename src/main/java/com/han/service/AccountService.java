package com.han.service;

import com.han.dao.AccountMapper;
import com.han.vo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public Account queryAccountById(Integer id){
        Account account = accountMapper.selectByPrimaryKey(id);
        return account;
    }

    public  int addAccount(Account account){
        int insert = accountMapper.insert(account);
        return insert;
    }


    public int updateAccount(Account account){
        int i = accountMapper.updateByPrimaryKey(account);
        return i;
    }

    public int deleteAccount(Integer id){
        int i = accountMapper.deleteByPrimaryKey(id);
        return i;
    }

    public List<Account> selectAccountAll(){
        return accountMapper.queryAll();
    }
}
