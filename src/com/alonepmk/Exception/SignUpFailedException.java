package com.alonepmk.Exception;

import org.springframework.http.HttpStatus;

// Referenced classes of package com.alonepmk.Exception:
//            MainException

public class SignUpFailedException extends MainException
{

    private static final long serialVersionUID = 1L;

    public SignUpFailedException()
    {
        super("SignUp Failed Exception");
    }

    public HttpStatus getHttpStatus()
    {
        return HttpStatus.UNAUTHORIZED;
    }
}
