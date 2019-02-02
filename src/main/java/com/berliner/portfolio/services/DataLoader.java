package com.berliner.portfolio.services;

import com.berliner.portfolio.models.store.Category;
import com.berliner.portfolio.repositories.store.CategoryRepository;
import com.berliner.portfolio.repositories.store.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void run(String... strings) throws Exception {

        if(categoryRepository.count() == 0)
        {
            System.out.println("Loading data...");
            categoryRepository.save(new Category("Arts and Crafts"));
            categoryRepository.save(new Category("Automotive"));
            categoryRepository.save(new Category("Baby and Toddler"));
            categoryRepository.save(new Category("Bath"));
            categoryRepository.save(new Category("Books"));
            categoryRepository.save(new Category("Chemicals"));
            categoryRepository.save(new Category("Clothing, Shoes, and Accessories"));
            categoryRepository.save(new Category("Cosmetics"));
            categoryRepository.save(new Category("Electronics"));
            categoryRepository.save(new Category("Fitness"));
            categoryRepository.save(new Category("Greeting Cards"));
            categoryRepository.save(new Category("Grocery"));
            categoryRepository.save(new Category("Models and Collectibles"));
            categoryRepository.save(new Category("Movies"));
            categoryRepository.save(new Category("Office"));
            categoryRepository.save(new Category("Paper Goods"));
            categoryRepository.save(new Category("Pets"));
            categoryRepository.save(new Category("Pharmacy"));
            categoryRepository.save(new Category("Toys"));
            categoryRepository.save(new Category("Video Games"));
            categoryRepository.save(new Category("Other"));
        }

        //Category category = categoryRepository.findByTitle("Toys");

    }
}
