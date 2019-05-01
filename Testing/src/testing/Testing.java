/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Elnic
 */
public class Testing {

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
                System.out.println(array[z]);
            }
            System.out.println("\"" + inputString + "\" with each word sorted alphabetically");
            for (String array1 : array) {
                System.out.print(array1 + " ");
            }
            System.out.println("");
            
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
}
