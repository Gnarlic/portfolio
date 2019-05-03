/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.calculator.service;

import gnarlitronic.ps.calculator.dao.StoredCalculations;
import gnarlitronic.ps.calculator.dao.StoredCalculationsInMemImpl;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Elnic
 */

public class CalculatorServiceImpl implements CalculatorService {

    
    StoredCalculations stocal;
    
    @Inject
    CalculatorServiceImpl(StoredCalculations sc) {
        this.stocal = sc;
    }
    
    @Override
    public double add(double a, double b) {
        stocal.storedCalc(a, "+", b, (a+b));
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        stocal.storedCalc(a, "-", b, (a-b));
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        stocal.storedCalc(a, "*", b, (a*b));
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        stocal.storedCalc(a, "/", b, (a/b));
        return a / b;
    }

    @Override
    public List<String[]> strArray() {
        return stocal.lastTenCalculations();
    }
    
}
