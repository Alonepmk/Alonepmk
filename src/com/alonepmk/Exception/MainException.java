package com.alonepmk.Exception;

import org.springframework.http.HttpStatus;

public abstract class MainException extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    public MainException(String Message)
    {
        super(Message);
    }

    public abstract HttpStatus getHttpStatus();
}
