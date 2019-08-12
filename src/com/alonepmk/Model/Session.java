package com.alonepmk.Model;


// Referenced classes of package com.alonepmk.Model:
//            Account

public class Session
{

    private Account account;

    public Session()
    {
    }

    public Session(Account account)
    {
        this.account = account;
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }
}
