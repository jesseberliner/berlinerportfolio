package com.berliner.portfolio.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController
{

    
    @RequestMapping({"/home","/"})
    public String welcomePage()
    {
        System.out.println("home");
        return "home";
    }

    @RequestMapping({"/calendar/home","/calendar"})
    public String calendarWelcomePage()
    {
        System.out.println("Calendar home");
        return "calendar/home";
    }

    //Store mappings
    @RequestMapping({"/store/home","/store"})
    public String storeWelcomePage()
    {
        System.out.println("Store home");
        return "store/home";
    }

}
