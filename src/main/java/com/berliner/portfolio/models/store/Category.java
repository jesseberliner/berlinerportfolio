package com.berliner.portfolio.models.store;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long catId;

    private int catCount;

    private String catTitle;

    @OneToMany(mappedBy = "itemId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Item> items;

    //public Category(@NotEmpty String catTitle)
    public Category(String catTitle)
    {
        this.catTitle = catTitle;
    }

    public Category()
    {
        this.catCount=0;
    }

    public long getCatId()
    {
        return catId;
    }

    public void setCatId(long catId)
    {
        this.catId = catId;
    }

    public String getCatTitle()
    {
        return catTitle;
    }

    public void setCatTitle(String catTitle)
    {
        this.catTitle = catTitle;
    }

    public Set<Item> getItems()
    {
        return items;
    }

    public void setItems(Set<Item> items)
    {
        this.items = items;
    }

    public int getCatCount()
    {
        return catCount;
    }

    public void setCatCount(int catCount)
    {
        this.catCount = catCount;
    }
}
