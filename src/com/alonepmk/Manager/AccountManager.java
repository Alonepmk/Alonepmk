package com.alonepmk.Manager;

import com.alonepmk.Mapper.AccountMapper;
import com.alonepmk.Model.Account;
import java.io.PrintStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountManager
{
	@Autowired
    AccountMapper accountMapper;

    public AccountManager()
    {
    }

    public List getAllAccount()
    {
        return accountMapper.getAllAccount();
    }

    public Account getAccountByEmail(String email)
    {
        return accountMapper.getAccountByEmail(email);
    }

    public Account getAccount(int id)
    {
        return accountMapper.getAccount(id);
    }

    public Account getAccountByNameAndPassword(String email, String password)
    {
        return accountMapper.getAccountByNameAndPassword(email, password);
    }

    public void addNewAccount(Account account)
    {
        System.out.println("still here");
        accountMapper.addNewAccount(account);
    }

    public int checkAccountEmailExist(String email)
    {
        return accountMapper.checkAccountEmailExist(email);
    }

    public int isFirstTime(Account account)
    {
        return accountMapper.isFirstTime(account);
    }

    public Account getAccountByNameAndPasswordAndCode(String email, String password, int code)
    {
        return accountMapper.getAccountByNameAndPasswordAndCode(email, password, code);
    }

    public void setConfirmCode(int i, String email)
    {
        accountMapper.setConfirmCode(i, email);
    }

	public List<Account> getAllUserAccount() {
		return accountMapper.getAllUserAccount();
	}
}
