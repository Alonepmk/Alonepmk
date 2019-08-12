package com.alonepmk.Exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class ExceptionResolver extends SimpleMappingExceptionResolver
{

    public ExceptionResolver()
    {
        setWarnLogCategory(ExceptionResolver.class.getName());
    }

    public String buildLogMessage(Exception e, HttpServletRequest req)
    {
        return (new StringBuilder("MVC exception: ")).append(e.getLocalizedMessage()).toString();
    }

    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
    {
        ModelAndView mav = super.doResolveException(request, response, handler, exception);
        mav.addObject("url", request.getRequestURL());
        mav.addObject("msg", exception.getMessage());
        return mav;
    }
}
