package com.berliner.portfolio.repositories.store;

import com.berliner.portfolio.models.store.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ItemRepository extends CrudRepository<Item, Long>
{

    Item findById(long id);
    ArrayList<Item> findByItemArchived(boolean isArchived);
//    ArrayList<Item> findByItem_cat_id(long id);


}

