package com.alonepmk.Controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class ViewController
{

    public ViewController()
    {
    }

    @RequestMapping(value = "/{page}.html", method = RequestMethod.GET)
    public ModelAndView visitorViewRoute(HttpSession session, ServletRequest request, @PathVariable("page") String page)
    {
        return new ModelAndView(page);
    }

    @RequestMapping(value = "/admin/{page}.html", method = RequestMethod.GET)
    public ModelAndView adminViewRoute(HttpSession session, ServletRequest request,@PathVariable("page") String page)
    {
        return new ModelAndView((new StringBuilder("/admin/")).append(page).toString());
    }

    @RequestMapping(value = "/user/{page}.html", method = RequestMethod.GET)
    public ModelAndView userViewRoute(HttpSession session, ServletRequest request,@PathVariable("page") String page)
    {
        return new ModelAndView((new StringBuilder("/user/")).append(page).toString());
    }

    @RequestMapping(value = "/shareView/{page}.html", method = RequestMethod.GET)
    public ModelAndView shareView(HttpSession session, ServletRequest request,@PathVariable("page") String page)
    {
        return new ModelAndView((new StringBuilder("/shareView/")).append(page).toString());
    }
}
