package com.alonepmk.Exception;

import org.springframework.http.HttpStatus;

// Referenced classes of package com.alonepmk.Exception:
//            MainException

public class AccountUnauthorizedException extends MainException
{

    private static final long serialVersionUID = 1L;

    public AccountUnauthorizedException()
    {
        super("!!! You are not Authorized to do this !!!");
    }

    public HttpStatus getHttpStatus()
    {
        return HttpStatus.UNAUTHORIZED;
    }
}
