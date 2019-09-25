/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nt.application.alphabetizer.dao;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import nt.application.alphabetizer.model.InputString;

/**
 *
 * @author Elnic
 */
public class StringInputDaoImpl implements InputStringDao {

    public static final String RESULTS_FILE = "past.txt";

    @Override
    public InputString storeInputString(InputString inputString) throws InputStringPersistenceException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(RESULTS_FILE, true));
        } catch (IOException e) {
            System.out.println("hey");
            throw new InputStringPersistenceException("Could not save results to file.", e);
        }
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + inputString.getString());
        out.flush();
        out.close();
        return inputString;
    }

}
