package com.alonepmk.ControllerModel;

import com.alonepmk.Model.Account;

public class RespondPayload
{

    private int status;
    private Account account;
    private String message;

    public RespondPayload()
    {
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
