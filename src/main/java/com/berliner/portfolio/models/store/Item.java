package com.berliner.portfolio.models.store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long item_id;

    @NotEmpty
    private String item_title;

    @NotNull
    @Min(0)
    private Double item_price;

    @NotEmpty
    private String item_desc;


    private String item_img;

    @Min(0)
    private int item_disc;

    @NotNull
    private int item_stock;

    @NotNull
    private boolean item_taxable;

    @NotNull
    private Date item_created;

    @NotNull
    private String item_owner;

    @NotNull
    private long item_cat_id;

    private boolean item_archived;

    private boolean item_approved;

    public Item()
    {
        this.item_archived = false;
        this.item_created = new Date();
        this.item_owner = "NullOwner";
    }

    public long getItem_id()
    {
        return item_id;
    }

    public void setItem_id(long item_id)
    {
        this.item_id = item_id;
    }

    public String getItem_title()
    {
        return item_title;
    }

    public void setItem_title(String item_title)
    {
        this.item_title = item_title;
    }

    public Double getItem_price()
    {
        return item_price;
    }

    public void setItem_price(Double item_price)
    {
        this.item_price = item_price;
    }

    public String getItem_desc()
    {
        return item_desc;
    }

    public void setItem_desc(String item_desc)
    {
        this.item_desc = item_desc;
    }

    public String getItem_img()
    {
        return item_img;
    }

    public void setItem_img(String item_img)
    {
        this.item_img = item_img;
    }

    public int getItem_disc()
    {
        return item_disc;
    }

    public void setItem_disc(int item_disc)
    {
        this.item_disc = item_disc;
    }

    public int getItem_stock()
    {
        return item_stock;
    }

    public void setItem_stock(int item_stock)
    {
        this.item_stock = item_stock;
    }

    public boolean isItem_taxable()
    {
        return item_taxable;
    }

    public void setItem_taxable(boolean item_taxable)
    {
        this.item_taxable = item_taxable;
    }

    public Date getItem_created()
    {
        return item_created;
    }

    public void setItem_created(Date item_created)
    {
        this.item_created = item_created;
    }

    public String getItem_owner()
    {
        return item_owner;
    }

    public void setItem_owner(String item_owner)
    {
        this.item_owner = item_owner;
    }

    public long getItem_cat_id()
    {
        return item_cat_id;
    }

    public void setItem_cat_id(long item_cat_id)
    {
        this.item_cat_id = item_cat_id;
    }

    public boolean isItem_archived()
    {
        return item_archived;
    }

    public void setItem_archived(boolean item_archived)
    {
        this.item_archived = item_archived;
    }

    public boolean isItem_approved()
    {
        return item_approved;
    }

    public void setItem_approved(boolean item_approved)
    {
        this.item_approved = item_approved;
    }
}