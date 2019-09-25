/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nt.application.alphabetizer.service;

import nt.application.alphabetizer.dao.InputStringPersistenceException;
import nt.application.alphabetizer.model.InputString;

/**
 *
 * @author Elnic
 */
public interface AlphabetizerService {
    
    public String returnResults(String string);
    
    public int[] countLetters(String string);
    
    public InputString saveInputString(InputString inputString) throws InputStringPersistenceException;
}
