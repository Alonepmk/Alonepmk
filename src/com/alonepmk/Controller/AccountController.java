package com.alonepmk.Controller;

import com.alonepmk.Exception.AccountUnauthorizedException;
import com.alonepmk.Manager.AccountManager;
import com.alonepmk.Model.Account;
import java.util.List;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController
{
	@Autowired
    private AccountManager accountManager;

    public AccountController()
    {
    }

    @RequestMapping(value = "/getAllAccount", method = RequestMethod.GET)
    public List<Account> getAllAccount(HttpSession session, ServletRequest request)
    {
        if(session.getAttribute("account") == null)
        {
            throw new AccountUnauthorizedException();
        } else
        {
            return accountManager.getAllAccount();
        }
    }

    @RequestMapping(value = "/getAccount/{id}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable("id") int id, HttpSession session, ServletRequest request)
    {
        return accountManager.getAccount(id);
    }
}
