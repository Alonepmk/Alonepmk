package com.alonepmk.Exception;

import org.springframework.http.HttpStatus;

// Referenced classes of package com.alonepmk.Exception:
//            MainException

public class SessionTimeoutException extends MainException
{

    private static final long serialVersionUID = 1L;

    public SessionTimeoutException()
    {
        super("Session Time Out");
    }

    public HttpStatus getHttpStatus()
    {
        return HttpStatus.UNAUTHORIZED;
    }
}
