/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Elnic
 */
public class Item {
    private String id;
    private String itemName;
    private BigDecimal itemPrice;
    private int itemInventory;
    
    public Item(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public void setItemName(String name) {
        this.itemName = name;
    }
    
    public BigDecimal getItemPrice() {
        return itemPrice;
    }
    
    public void setItemPrice(BigDecimal price) {
        this.itemPrice = price;
    }
    
    public int getItemInventory() {
        return itemInventory;
    }
    
    public void setItemInventory(int itemCount) {
        this.itemInventory = itemCount;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.itemName);
        hash = 71 * hash + Objects.hashCode(this.itemPrice);
        hash = 71 * hash + this.itemInventory;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.itemInventory != other.itemInventory) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemPrice, other.itemPrice)) {
            return false;
        }
        return true;
    }

    
}
