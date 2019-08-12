package com.alonepmk.Exception;

import org.springframework.http.HttpStatus;

// Referenced classes of package com.alonepmk.Exception:
//            MainException

public class EmailSendFailException extends MainException
{

    private static final long serialVersionUID = 1L;

    public EmailSendFailException()
    {
        super("!!! Something Wrong at the Backend...Report this Bug to alone21896@gmail.com !!!");
    }

    public HttpStatus getHttpStatus()
    {
        return HttpStatus.BAD_GATEWAY;
    }
}
