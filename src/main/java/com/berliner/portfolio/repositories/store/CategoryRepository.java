package com.berliner.portfolio.repositories.store;

import com.berliner.portfolio.models.store.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long>
{
    Category findById(long id);
    List<Category> findAllByOrderByCatTitle();
}
