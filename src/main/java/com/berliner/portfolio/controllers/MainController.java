package com.berliner.portfolio.controllers;


import com.berliner.portfolio.models.store.Item;
import com.berliner.portfolio.repositories.store.itemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String addProduct(@Valid @ModelAttribute("newItem")Item item, Model model, BindingResult result)
    {
        System.out.println("post addItem");
        if(result.hasErrors())
        {
            return "store/addItem";
        }
        itemRepo.save(item);

        return "store/showAdded";
    }

    @GetMapping({"/store/showDetail/{item_id}","/showDetail/{item_id}"})
    public String showDetail(@PathVariable ("item_id") long id, Model model)
    {
        System.out.println("showDetail");
        model.addAttribute("item", itemRepo.findById(id));
        return "store/showDetail";
    }



}
