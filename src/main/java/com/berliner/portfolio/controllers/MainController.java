package com.berliner.portfolio.controllers;


import com.berliner.portfolio.models.store.Item;
import com.berliner.portfolio.repositories.store.ItemRepository;
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
    ItemRepository itemRepo;
    
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
//Store mappings
    //home page
    @RequestMapping({"/store/home","/store"})
    public String storeWelcomePage(Model model)
    {
        return "store/home";
    }
    //all items
    @RequestMapping({"/store/showItems","/showItems"})
    public String storeItemPage(Model model)
    {
        //model.addAttribute("allItems", itemRepo.findAll());
        model.addAttribute("allItems", itemRepo.findByItemArchived(false));
        return "store/showItems";
    }
    //add item get
    @GetMapping({"/store/addItem","/addItem"})
    public String addProduct(Model model)
    {
        model.addAttribute("newItem", new Item());
        return "store/addItem";
    }
    //add item post
    @PostMapping({"/store/addItem","/addItem"})
    public String addProduct(@Valid @ModelAttribute("newItem")Item item, Model model, BindingResult result)
    {
        System.out.println("post addItem");
        if(result.hasErrors())
        {
            return "store/addItem";
        }
        //this pads the end of the description so that it's at least 50 chars to make displaying nicer
        while(item.getItemDesc().length()<50)
        {
            item.setItemDesc(item.getItemDesc() + " ");
        }
        itemRepo.save(item);

        return "store/showAdded";
    }
    //show single selected item
    @GetMapping({"/store/showDetail/{itemId}","/showDetail/{itemId}"})
    public String showDetail(@PathVariable ("itemId") long id, Model model)
    {
        System.out.println("showDetail");
        model.addAttribute("item", itemRepo.findById(id));
        return "store/showDetail";
    }
    //edit single item
    @GetMapping("store/update/{itemId}")
    public String updateItem(@PathVariable("itemId") long id, Model model)
    {
        model.addAttribute("newItem", itemRepo.findById(id));

        return "store/addItem";

    }
    //archive single item
    @RequestMapping("store/delete/{itemId}")
    public String delete(@PathVariable("itemId") long id)
    {
        Item item = itemRepo.findById(id);
        item.setItemArchived(true);
        //item.setItemArchived(!item.isItemApproved());
        itemRepo.save(item);

//        return "redirect:store/showItems";
        return "redirect:../showItems";
    }

//    @RequestMapping({"/store/showDeletedItems","/showDeletedItems"})
//    public String storeDeletedItemsPage(Model model)
//    {
//        //model.addAttribute("allItems", itemRepo.findAll());
//        model.addAttribute("allItems", itemRepo.findByItemArchived(true));
//        return "store/showItems";
//    }
}
