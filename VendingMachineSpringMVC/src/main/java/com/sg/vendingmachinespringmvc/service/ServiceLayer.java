/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.InsufficientInventoryException;
import com.sg.vendingmachinespringmvc.dao.InvalidItemException;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Elnic
 */
public interface ServiceLayer {
    
    public List<Item> getAllItems();
    
    public void addFunds(BigDecimal amount);
    
    public BigDecimal getFunds();
    
    public void setItemId(String id);
    
    public String getItemId();
    
    public String getMessages();
    
    public Change getChange();
    
    public void clearFunds();
    
    public void purchaseItem(String id) throws InvalidItemException, InsufficientFundsException, InsufficientInventoryException;
    
    public boolean showChange();
    
    public void clearMessages();
}
