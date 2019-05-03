/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.calculator.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Elnic
 */
public class StoredCalculationsInMemImpl implements StoredCalculations {

    private static ArrayList<String[]> str = new ArrayList<>();

    @Override
    public void storedCalc(double a, String operand, double b, double c) {
        String[] nc = new String[4];
        nc[0] = Double.toString(a);
        nc[1] = operand;
        nc[2] = Double.toString(b);
        nc[3] = Double.toString(c);
        str.add(nc);
    }

    @Override
    public List<String[]> lastTenCalculations() {
        List<String[]> str1 = new ArrayList<>();
        if (str.size() > 10) {
         str1 = str.subList(str.size()-10, str.size());
         return str1;
        } else {
            return str;
        }
    }

}
