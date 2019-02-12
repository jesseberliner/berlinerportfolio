package com.berliner.portfolio.repositories.store;

import com.berliner.portfolio.models.store.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>
{
    Category findById(long id);
    Category findAllOrderByCatTitle();
}
