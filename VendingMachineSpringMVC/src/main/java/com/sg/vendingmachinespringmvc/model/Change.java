/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;

/**
 *
 * @author Elnic
 */
public class Change {
    private BigDecimal numQuarters = new BigDecimal("0");
    private BigDecimal numDimes = new BigDecimal("0");
    private BigDecimal numNickels = new BigDecimal("0");
    private BigDecimal numPennies = new BigDecimal("0");
    
    public BigDecimal getQuarters() {
        return numQuarters;
    }
    
    public BigDecimal getDimes() {
        return numDimes;
    }
    
    public BigDecimal getNickels() {
        return numNickels;
    }
    
    public BigDecimal getPennies() {
        return numPennies;
    }
    
    public void setQuarters(BigDecimal quarters) {
        this.numQuarters = quarters;
    }
    
    public void setDimes(BigDecimal dimes) {
        this.numDimes = dimes;
    }
    
    public void setNickels(BigDecimal nickels) {
        this.numNickels = nickels;
    }
    
    public void setPennies(BigDecimal pennies) {
        this.numPennies = pennies;
    }
}
