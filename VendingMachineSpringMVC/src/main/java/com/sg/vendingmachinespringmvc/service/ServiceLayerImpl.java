/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.InsufficientInventoryException;
import com.sg.vendingmachinespringmvc.dao.InvalidItemException;
import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Elnic
 */
public class ServiceLayerImpl implements ServiceLayer {

    @Inject
    private VendingMachineDao dao;

    private boolean change = false;

    @Override
    public List<Item> getAllItems() {
        List<Item> items = dao.getAllItems();
        return items;
    }

    @Override
    public void addFunds(BigDecimal amount) {
        dao.addFunds(amount);
    }

    @Override
    public BigDecimal getFunds() {
        return dao.getFunds();
    }

    @Override
    public void setItemId(String id) {
        dao.setItemId(id);
    }

    @Override
    public String getItemId() {
        return dao.getItemId();
    }

    @Override
    public String getMessages() {
        return dao.getMessages();
    }

    @Override
    public Change getChange() {
        return dao.getChange(dao.getFunds());
    }

    @Override
    public void clearFunds() {
        dao.clearFunds();
        change = false;
    }

    @Override
    public void purchaseItem(String id) throws InvalidItemException, InsufficientFundsException, InsufficientInventoryException {

        Item item = dao.getItem(id);
        if (id == null || id.equals("")) {
            throw new InvalidItemException("Please choose an Item");
        } else if (item.getItemInventory() == 0) {
            throw new InsufficientInventoryException("OUT OF STOCK");
        } else if (dao.getFunds().compareTo(item.getItemPrice()) < 0) {
            throw new InsufficientFundsException("Please enter " + item.getItemPrice().subtract(dao.getFunds()));
        } else  {
            item.setItemInventory(item.getItemInventory() - 1);
            dao.setFunds(dao.getFunds().subtract(item.getItemPrice()));
            change = true;
            dao.setMessages("Thank You!");
            getChange();
        }
    }

    @Override
    public boolean showChange() {
        return change;
    }
    
    @Override
    public void clearMessages() {
        dao.clearMessages();
    }

}
