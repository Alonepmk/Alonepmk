package com.alonepmk.Utils;

import com.alonepmk.Exception.SessionNotFoundException;
import com.alonepmk.Exception.SessionTimeoutException;
import com.alonepmk.Model.Account;
import com.alonepmk.Model.Session;
import java.io.PrintStream;
import javax.servlet.http.HttpSession;

public class SessionUtils
{

    public SessionUtils()
    {
    }

    public static synchronized Session getSessionObject(HttpSession session)
    {
        System.out.println("i want to know that was i call?");
        if(session == null)
        {
            throw new SessionNotFoundException();
        }
        System.out.println("pass null test");
        Object object = session.getAttribute("account");
        System.out.println("pass get session test");
        if(object != null && (object instanceof Account))
        {
            System.out.println("i wasnt null at getting account");
            Session currentSession = new Session((Account)object);
            System.out.println((new StringBuilder(String.valueOf(currentSession.getAccount().getEmail()))).append("Email plz").toString());
            return currentSession;
        } else
        {
            System.out.println("it was fail and didn't reach here");
            throw new SessionTimeoutException();
        }
    }
}
