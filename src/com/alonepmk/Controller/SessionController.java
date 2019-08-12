package com.alonepmk.Controller;

import com.alonepmk.ControllerModel.RespondPayload;
import com.alonepmk.Exception.SessionTimeoutException;
import com.alonepmk.Model.Session;
import com.alonepmk.Utils.SessionUtils;
import java.io.PrintStream;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController
{

    private static final RespondPayload successPayload;

    public SessionController()
    {
    }

    @RequestMapping(value = "/active", method = RequestMethod.POST)
    public RespondPayload active(HttpSession session)
    {
        if(session == null)
        {
            throw new SessionTimeoutException();
        }
        System.out.println("i'as call for session test");
        Session ses = SessionUtils.getSessionObject(session);
        if(ses == null)
        {
            throw new SessionTimeoutException();
        } else
        {
            return successPayload;
        }
    }

    @RequestMapping(value = "/logout" , method = RequestMethod.POST)
    public RespondPayload logout(HttpSession session)
    {
        session.invalidate();
        return successPayload;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test(HttpSession session)
    {
        Session s = SessionUtils.getSessionObject(session);
    }

    @RequestMapping(value = "/checkActive" , method = RequestMethod.GET)
    public RespondPayload checkActive(HttpSession session)
    {
        RespondPayload responsePayload = null;
        if(session == null)
        {
            responsePayload.setStatus(401);
        }
        Session ses = SessionUtils.getSessionObject(session);
        if(ses == null)
        {
            responsePayload.setStatus(401);
        } else
        {
            responsePayload.setStatus(200);
        }
        return responsePayload;
    }

    static 
    {
        successPayload = new RespondPayload();
        successPayload.setStatus(200);
    }
}
