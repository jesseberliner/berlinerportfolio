package com.berliner.portfolio.models.store;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemId;

    @NotEmpty
    private String itemTitle;

    @NotNull
    @Min(0)
    private Double itemPrice;

    @NotEmpty
    private String itemDesc;


    private String itemImg;

    @Min(0)
    private int itemDisc;

    @NotNull
    private int itemStock;

    @NotNull
    private boolean itemTaxable;

    @NotNull
    private Date itemCreated;

    @NotNull
    private Date itemLastEdited;

    @NotNull
    private String itemOwner;

    @NotNull
    private String itemLastEditor;

    private long itemCatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_catid")
    private Category category;

    private boolean itemArchived;

    private boolean itemApproved;

    public Item()
    {
        this.itemArchived = false;
        this.itemCreated = new Date();
        this.itemOwner = "NullOwner";
        this.itemLastEdited = new Date();
        this.itemLastEditor = "lastNullOwner";
    }

    public long getItemId()
    {
        return itemId;
    }

    public void setItemId(long itemId)
    {
        this.itemId = itemId;
    }

    public String getItemTitle()
    {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle)
    {
        this.itemTitle = itemTitle;
    }

    public Double getItemPrice()
    {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice)
    {
        this.itemPrice = itemPrice;
    }

    public String getItemDesc()
    {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc)
    {
        this.itemDesc = itemDesc;
    }

    public String getItemImg()
    {
        return itemImg;
    }

    public void setItemImg(String itemImg)
    {
        this.itemImg = itemImg;
    }

    public int getItemDisc()
    {
        return itemDisc;
    }

    public void setItemDisc(int itemDisc)
    {
        this.itemDisc = itemDisc;
    }

    public int getItemStock()
    {
        return itemStock;
    }

    public void setItemStock(int itemStock)
    {
        this.itemStock = itemStock;
    }

    public boolean isItemTaxable()
    {
        return itemTaxable;
    }

    public void setItemTaxable(boolean itemTaxable)
    {
        this.itemTaxable = itemTaxable;
    }

    public Date getItemCreated()
    {
        return itemCreated;
    }

    public void setItemCreated(Date itemCreated)
    {
        this.itemCreated = itemCreated;
    }

    public Date getItemLastEdited()
    {
        return itemLastEdited;
    }

    public void setItemLastEdited(Date itemLastEdited)
    {
        this.itemLastEdited = itemLastEdited;
    }

    public String getItemOwner()
    {
        return itemOwner;
    }

    public void setItemOwner(String itemOwner)
    {
        this.itemOwner = itemOwner;
    }

    public String getItemLastEditor()
    {
        return itemLastEditor;
    }

    public void setItemLastEditor(String itemLastEditor)
    {
        this.itemLastEditor = itemLastEditor;
    }

    public long getItemCatId()
    {
        return itemCatId;
    }

    public void setItemCatId(long itemCatId)
    {
        this.itemCatId = itemCatId;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public boolean isItemArchived()
    {
        return itemArchived;
    }

    public void setItemArchived(boolean itemArchived)
    {
        this.itemArchived = itemArchived;
    }

    public boolean isItemApproved()
    {
        return itemApproved;
    }

    public void setItemApproved(boolean itemApproved)
    {
        this.itemApproved = itemApproved;
    }
}