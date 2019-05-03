/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.calculator.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elnic
 */
public interface StoredCalculations {
    
    void storedCalc(double a, String operand, double b, double c);
    
    public List<String[]> lastTenCalculations();
    
}
