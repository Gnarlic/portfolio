/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nt.application.alphabetizer.service;

import java.util.ArrayList;

/**
 *
 * @author Elnic
 */
public class AlphabetizerServiceImpl implements AlphabetizerService {

    @Override
    public String returnResults(String inputString) {

        String[] stray;
        String temp;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> stringList = new ArrayList<>();
        

        for (int p = 0; p <= inputString.length() - 1; p++) {

            if (inputString.charAt(p) == 0x20) {
                String separatedString = new String(sb);
                sb.setLength(0);
                stringList.add(separatedString);
            } else {
                sb.append(inputString.charAt(p));
                if (p == inputString.length() - 1) {
                    String finalSeparatedString = new String(sb);
                    stringList.add(finalSeparatedString);
                }
            }
        }
        
        String[] array = stringList.toArray(new String[stringList.size()]);
        stray = array;
        for (int z = 0; z <= array.length - 1; z++) {
                String string = array[z];
                String[] strArray = new String[string.length()];
                //Breaks word down into array composed of individual characters
                for (int i = 0; i <= array[z].length() - 1; i++) {
                    strArray[i] = String.valueOf(string.charAt(i));
                }

                //sorts array of characters alphabetically by comparing char values
                for (int i = 0; i <= string.length(); i++) {
                    for (int j = i + 1; j < string.length(); j++) {

                        if (strArray[i].compareTo(strArray[j]) > 0) {
                            temp = strArray[i];
                            strArray[i] = strArray[j];
                            strArray[j] = temp;
                        }
                    }
                }
                //Rebuilds inputString from sorted letters
                StringBuilder sb1 = new StringBuilder();
                for (String strArray1 : strArray) {
                    sb1.append(strArray1);
                }
                //replaces original inputString in separated inputString array with rearranged inputString
                String newString = new String(sb1);
                array[z] = newString;
                //System.out.println(array[z]);
            }
        StringBuilder sb2 = new StringBuilder();
        String str;
        for (String arrayz : array) {
            sb2.append(arrayz);
            sb2.append(" ");
        }
        str = new String(sb2);
        return str;
    }

    @Override
    public int[] countLetters(String string) {
        int[] letterCount = new int[26];
        int temp = 0;
        for (int lc = 0; lc < 26; lc++) {
            temp = 0;
            //loops through string and checks for character
            for (int cv = 0; cv < string.length(); cv++) {
                if (string.charAt(cv) == lc + 97) {
                    temp++;
                } else {

                }
            }
            letterCount[lc] = temp;
        }

        return letterCount;
    }

}
