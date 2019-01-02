/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ""; public boolean changeBool = false;
 *
 *
 * @author Elnic
 */
public class VendingMachineDaoInMemImpl implements VendingMachineDao {

    private Map<String, Item> itemMap = new HashMap<>();

    private BigDecimal funds = new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP);
    private String id = "";
    private String messages = "";

    public VendingMachineDaoInMemImpl() {
        Item item = new Item("1");
        item.setItemName("Khyber Crystal");
        item.setItemInventory(2);
        item.setItemPrice(new BigDecimal(19.77).setScale(2, RoundingMode.HALF_UP));
        this.itemMap.put(item.getId(), item);

        item = new Item("2");
        item.setItemName("Hyperdrive Motivator");
        item.setItemPrice(new BigDecimal(2.25).setScale(2, RoundingMode.HALF_UP));
        item.setItemInventory(0);
        this.itemMap.put(item.getId(), item);

        item = new Item("3");
        item.setItemName("Hydrospanner");
        item.setItemPrice(new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP));
        item.setItemInventory(5);
        this.itemMap.put(item.getId(), item);

        item = new Item("4");
        item.setItemName("Thermal Detonator");
        item.setItemPrice(new BigDecimal(2.35).setScale(2, RoundingMode.HALF_UP));
        item.setItemInventory(8);
        this.itemMap.put(item.getId(), item);

        item = new Item("5");
        item.setItemName("Mynock Repellant");
        item.setItemPrice(new BigDecimal(2.75).setScale(2, RoundingMode.HALF_UP));
        item.setItemInventory(10);
        this.itemMap.put(item.getId(), item);

        item = new Item("6");
        item.setItemName("Restraining Bolt");
        item.setItemPrice(new BigDecimal(4.00).setScale(2, RoundingMode.HALF_UP));
        item.setItemInventory(8);
        this.itemMap.put(item.getId(), item);

        item = new Item("7");
        item.setItemName("Moisture Vaporator");
        item.setItemPrice(new BigDecimal(1.18).setScale(2, RoundingMode.HALF_UP));
        item.setItemInventory(3);
        this.itemMap.put(item.getId(), item);

        item = new Item("8");
        item.setItemName("Tibanna Gas - 300ml");
        item.setItemPrice(new BigDecimal(3.20).setScale(2, RoundingMode.HALF_UP));
        item.setItemInventory(6);
        this.itemMap.put(item.getId(), item);

        item = new Item("9");
        item.setItemName("Vibroblade");
        item.setItemPrice(new BigDecimal(4.50).setScale(2, RoundingMode.HALF_UP));
        item.setItemInventory(9);
        this.itemMap.put(item.getId(), item);
    }

    @Override
    public List<Item> getAllItems() {
        return new ArrayList(itemMap.values());

    }

    @Override
    public String updateItem(String id) {
        Item item = itemMap.get(id);
        if (funds.equals(item.getItemPrice()) || funds.compareTo(item.getItemPrice()) > 0) {
            item.setItemInventory(item.getItemInventory() - 1);
            itemMap.put(item.getId(), item);
            return "success";
        } else {
            return "Please enter sufficient funds";
        }

    }

    @Override
    public Item getItem(String itemId) {
        Item item = itemMap.get(itemId);
        return item;
    }

    @Override
    public void addFunds(BigDecimal amount) {
        this.funds = this.funds.add(amount);
    }

    @Override
    public BigDecimal getFunds() {
        return funds;
    }

    @Override
    public void setItemId(String id) {
        this.id = id;
    }

    @Override
    public String getItemId() {
        return id;
    }

    @Override
    public String getMessages() {
        return messages;
    }

    @Override
    public Change getChange(BigDecimal funds) {
        id = "";
        Change change = new Change();
        BigDecimal returnChange = funds.multiply(new BigDecimal("100"));
        change.setQuarters(returnChange.divide(new BigDecimal("25"), 0, RoundingMode.FLOOR));
        returnChange = returnChange.subtract(change.getQuarters().multiply(new BigDecimal("25")));
        change.setDimes(returnChange.divide(new BigDecimal("10"), 0, RoundingMode.FLOOR));
        returnChange = returnChange.subtract(change.getDimes().multiply(new BigDecimal("10")));
        change.setNickels(returnChange.divide(new BigDecimal("5"), 0, RoundingMode.FLOOR));
        returnChange = returnChange.subtract(change.getNickels().multiply(new BigDecimal("5")));
        change.setPennies(returnChange.divide(new BigDecimal("1"), 0, RoundingMode.FLOOR));
        returnChange = returnChange.subtract(change.getPennies());
        return change;
    }

    @Override
    public void clearFunds() {
        this.funds = new BigDecimal("0.00");
    }

    @Override
    public void clearMessages() {
        messages = "";
    }
    
    @Override
    public void setMessages(String message) {
        this.messages = message;
    }

    @Override
    public void setFunds(BigDecimal amount) {
        this.funds = amount;
    }

}
