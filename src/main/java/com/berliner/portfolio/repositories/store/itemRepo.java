package com.berliner.portfolio.repositories.store;

import com.berliner.portfolio.models.store.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface itemRepo extends CrudRepository<Item, Long>
{

    Item findById(long id);



}

