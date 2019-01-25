package com.berliner.portfolio.repositories.store;

import com.berliner.portfolio.models.store.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface itemRepo extends CrudRepository<Item, Long>
{
    //Set<Item> findByitem_archivedIsFalse();
//    Set<Item> findAllByItem_cat_idIs(long catId);
      Item findById(long id);

}

