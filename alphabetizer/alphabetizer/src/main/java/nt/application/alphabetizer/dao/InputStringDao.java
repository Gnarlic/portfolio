/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nt.application.alphabetizer.dao;

import nt.application.alphabetizer.model.InputString;

/**
 *
 * @author Elnic
 */
public interface InputStringDao {
    
    InputString storeInputString(InputString inputString) throws InputStringPersistenceException;
    
}
