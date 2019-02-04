package com.berliner.portfolio.controllers;

import com.berliner.portfolio.models.store.Category;
import com.berliner.portfolio.models.store.Item;
import com.berliner.portfolio.repositories.store.CategoryRepository;
import com.berliner.portfolio.repositories.store.ItemRepository;
import com.berliner.portfolio.services.CloudinaryConfig;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class StoreController
{

    @Autowired
    ItemRepository itemRepo;

    @Autowired
    CategoryRepository categoryRepo;

    @Autowired
    CloudinaryConfig cloudc;


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
        model.addAttribute("categories", categoryRepo.findAll());
        return "store/addItem";
    }
    //add item post
    @PostMapping({"/store/addItem","/addItem"})
    public String addProduct(@Valid @ModelAttribute("newItem")Item item,
                             @RequestParam("file") MultipartFile file, BindingResult result)
    {
        if(result.hasErrors())
        {
            System.out.println("has errors");
            return "store/addItem";
        }
        if(file.isEmpty())
        {
            System.out.println("fileEmpty");
            return "redirect:/addItem";
        }
//        try {
//            Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
//            item.setItemImg(uploadResult.get("url").toString());
//            System.out.println(uploadResult.get("url").toString());
//        } catch (IOException e){
//            e.printStackTrace();
//            return "redirect:/addItem";
//        }

        //this pads the end of the description so that it's at least 50 chars to make displaying nicer
        while(item.getItemDesc().length()<50)
        {
            item.setItemDesc(item.getItemDesc() + " ");
        }
        Category category = categoryRepo.findById(item.getItemCatId());

        Set<Item> items = new HashSet<Item>();
        items.add(item);
        category.setItems(items);
        category.setCatCount(category.getCatCount() + 1);
        categoryRepo.save(category);

        return "store/showAdded";
    }
    //show single selected item
    @GetMapping({"/store/showDetail/{itemId}","/showDetail/{itemId}"})
    public String showDetail(@PathVariable("itemId") long id, Model model)
    {
        model.addAttribute("item", itemRepo.findById(id));
        return "store/showDetail";
    }
    //edit single item
    @GetMapping("store/update/{itemId}")
    public String updateItem(@PathVariable("itemId") long id, Model model)
    {
        model.addAttribute("newItem", itemRepo.findById(id));
        model.addAttribute("categories", categoryRepo.findAll());

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
