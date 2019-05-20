/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nt.application.alphabetizer.service;

/**
 *
 * @author Elnic
 */
public interface AlphabetizerService {
    
    public String returnResults(String string);
    
    public int[] countLetters(String string);
    
}
