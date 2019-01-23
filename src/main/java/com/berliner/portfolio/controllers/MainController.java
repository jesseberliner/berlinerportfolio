package com.berliner.portfolio.controllers;


import com.berliner.portfolio.models.store.Item;
import com.berliner.portfolio.repositories.store.itemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;

@Controller
public class MainController
{
    
    @Autowired
    itemRepo itemRepo;
    
    @RequestMapping({"/home","/"})
    public String welcomePage(Model model)
    {
        System.out.println("home");
        return "home";
    }

    @RequestMapping({"/calendar/home","/calendar"})
    public String calendarWelcomePage(Model model)
    {
        return "calendar/home";

    }

    @RequestMapping({"/store/home","/store"})
    public String storeWelcomePage(Model model)
    {
        return "store/home";
    }

    @RequestMapping({"/store/showItems","/showItems"})
    public String storeItemPage(Model model)
    {
        model.addAttribute("allItems", itemRepo.findAll());
        return "store/showItems";
    }

    @GetMapping({"/store/addItem","/addItem"})
    public String addProduct(Model model)
    {
        System.out.println("additem");
        model.addAttribute("newItem", new Item());
        return "store/addItem";
    }

    @PostMapping({"/store/addItem","/addItem"})
    public String addProduct(@Valid @ModelAttribute("newItem")Item item, BindingResult result)
    {
        if(result.hasErrors())
        {
            System.out.println("Problem");
            System.out.println(result.getErrorCount());
            return "store/addItem";
        }
        itemRepo.save(item);
        System.out.println("No Problem");

        return "store/showItems";
    }


    @GetMapping("/update/{p_id}")
    public String updateItem(@PathVariable("p_id") long id, Model model)
    {
        //model.addAttribute("newItem", itemRepo.findById(id));
        model.addAttribute("newItem", itemRepo.findAll());

        return "store/additem";

    }

    @GetMapping("/addstock/{p_id}")
    public String updateStock(@PathVariable("p_id") long id, Model model)
    {
        model.addAttribute("changeItem", itemRepo.findAll());
        return "store/addstock";

    }
}
