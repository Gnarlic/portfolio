/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

/**
 *
 * @author Elnic
 */
public class InvalidItemException extends Exception{
    public InvalidItemException(String message) {
        super(message);
    }

}
