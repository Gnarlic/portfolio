/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Elnic
 */
public interface VendingMachineDao {
    
    public List<Item> getAllItems();
    
    public String updateItem(String id);
    
    public Item getItem(String itemId);

    public void addFunds(BigDecimal amount);

    public BigDecimal getFunds();

    public void setItemId(String id);
    
    public String getItemId();

    public String getMessages();

    public Change getChange(BigDecimal funds);
    
    public void clearFunds();
    
    public void clearMessages();
    
    public void setMessages(String message);

    public void setFunds(BigDecimal amount);
}
