package com.alonepmk.Exception;

import org.springframework.http.HttpStatus;

// Referenced classes of package com.alonepmk.Exception:
//            MainException

public class UserNameAndPasswordWrongException extends MainException
{

    private static final long serialVersionUID = 1L;

    public UserNameAndPasswordWrongException()
    {
        super("Username and Password Incorrect");
    }

    public HttpStatus getHttpStatus()
    {
        return HttpStatus.BAD_REQUEST;
    }
}
