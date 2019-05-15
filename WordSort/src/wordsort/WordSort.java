/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Elnic
 */
public class WordSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Boolean bool = true;
        while (bool == true) {
            String inputString;
            String temp;
            StringBuilder sb = new StringBuilder();
            ArrayList<String> stringList = new ArrayList<>();
            System.out.println("===== Welcome to WordSort =====");
            System.out.println("Enter word/sentence, and each word will have its letters rearranged alphabetically.");
            inputString = sc.nextLine().toLowerCase();

            //Divides input string into separate strings when a blank space is encountered.
            //At the end of the loop the final StringBuilder is added to ArrayList<String> stringList
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

            //Creates String[] from ArrayList<String>
            String[] array = stringList.toArray(new String[stringList.size()]);
            //Rearranges the letters for each word in array, to alphabetical order.
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
                //Rebuilds string from sorted letters
                StringBuilder sb1 = new StringBuilder();
                for (String strArray1 : strArray) {
                    sb1.append(strArray1);
                }
                //replaces original string in separated string array with rearranged string
                String newString = new String(sb1);
                array[z] = newString;
                //System.out.println(array[z]);
            }
            System.out.println("\"" + inputString + "\" with each word sorted alphabetically");
            System.out.print("\"");
            for (String array1 : array) {
                System.out.print(array1 + " ");
            }
            System.out.println("\"");
            System.out.println(inputString);
            countLetters(inputString);
            
            Boolean keepGoing = true;
            while (keepGoing == true) {
                System.out.println("Continue? (y/n)");
                String continueProgram = sc.nextLine().toLowerCase();
                if (continueProgram.equals("y") || continueProgram.equals("n")) {
                    switch (continueProgram) {
                        case "y":
                            keepGoing = false;
                            bool = true;
                            break;
                        case "n":
                            keepGoing = false;
                            bool = false;
                            break;
                        default:
                            
                            break;
                    }
                } else {
                    System.out.println("Please enter y or n");
                }
            }
        }
        System.out.println("Goodbye");
    }
    
    private static int[] countLetters(String string) {
       int[] letterCount = new int[26];
       
       for (int lc = 0; lc < 26; lc++) {
           System.out.println(string.charAt(lc));
           int temp = 0;
           int charCount = 0;
           for (int cv = 0; cv < string.length()-1; cv++) {
               if (string.charAt(cv) == charCount+97) {
                   temp++;
               } else {
                   
               }
           }
           charCount++;
           letterCount[lc] = temp;
           System.out.println(Arrays.toString(letterCount));
       }
        
       
        /**for (int w = 0; w < 26; w++) {
            int temp = 0;
            for(int q = 0; q <= string.length()-1; q++) {
                if (string.charAt(q) == 64) {
                    System.out.println("space");
                } else if (string.charAt(q) == q+97) {
                    temp++;
                }
            }
            letterCount[w] = temp;
        }
        System.out.println(letterCount.length);
        for (int m = 0; m < letterCount.length; m ++) {
            System.out.println(letterCount[m]);
        }**/
        
        return letterCount;
    }
    
}
