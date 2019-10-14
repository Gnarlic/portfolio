/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.console;

/**
 *
 * @author Elnic
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Elnic
 */
public class HangmanConsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        String string = "";
        String confirm = "n";
        String validString = "n";

        System.out.println("*** Hangman ***");
        while (confirm.equals("n")) {
            System.out.println("Please enter a word for hangman");
            string = sc.nextLine().toLowerCase();
            while (validString.equals("n")) {
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) < 97 || string.charAt(i) > 122) {
                        System.out.println("Please enter only letters");
                        string = sc.nextLine().toLowerCase();
                        validString = "n";
                        break;
                    } else {
                        validString = "y";
                    }
                }
            }
            System.out.println(string + " <-- is this correct? (y/n)");
            confirm = sc.nextLine();
            if (confirm.equals("y")) {
                System.out.println("Ok");
            } else {
                confirm = "n";
            }

        }

        System.out.println("Now I'll try to guess the word");
        String[] charArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int pl = 97;

        char[] chars = new char[string.length()];
        ArrayList<Integer> guessList = new ArrayList<>();
        ArrayList<Character> correctGuesses = new ArrayList<>();
        ArrayList<Character> wrongCharacters = new ArrayList<>();
        //System.out.println(guessList.size());
        int incorrectGuesses = 0;
        //System.out.println(incorrectGuesses);

        while (incorrectGuesses <10) {
            if (incorrectGuesses >= 1500) {
                break;
            }
            int charGuess = 0;
            int randomNum = 0;
            
            //generate char number for guess and redo if already guessed in guessList ArrayList
            while (charGuess == 0) {
                randomNum = ran.nextInt(26);
//                System.out.println(guessList);
//                System.out.println(randomNum);
                int tracking = 0;
                if (guessList.size() >= 1) {
                    for (int guessListNum : guessList) {
                        //if no guesses yet first number is added
                        if (randomNum == guessListNum) {
                            charGuess = 0;
                            //System.out.println(charArray[randomNum] + ": Letter already guessed!");
                            tracking ++;
                            break;
                        }
                    }
                    if (tracking < 1) {
                        charGuess = 1;
                            guessList.add(randomNum);
                            //System.out.println(charArray[randomNum] + " added");
                    }
                } else if (guessList.size() < 1) {
                    guessList.add(randomNum);
                    charGuess = 1;
                    //System.out.println(charArray[randomNum] + " added");
                    //if number has already been guessed, a new number will be generated
                }
                if (guessList.size() >= 26) {
                    charGuess = 1;
                }
            }
            //pick char from array based on randomNum value
            //System.out.println("loop ended");
            char a = charArray[randomNum].charAt(0);
            //System.out.println(a);
            int charExistsInString = 0;
            for (int j = 0; j < string.length(); j++) {

                if (string.charAt(j) == (a)) {
                    chars[j] = string.charAt(j);
                    //System.out.println(chars);
                    correctGuesses.add(a);
                    charExistsInString ++;
                }
            }
            if (charExistsInString > 0) {
                
            } else if (charExistsInString == 0) {
                wrongCharacters.add(a);
                incorrectGuesses ++;
            }
        }

        if (incorrectGuesses >= 10) {
            System.out.println("I AM LOSER");
        } else {
            System.out.println("I AM WINNER");
        }
        System.out.println("I guessed these letters wrong: " + wrongCharacters);
        System.out.println("I guessed these letters correct: " + correctGuesses);
        System.out.println(chars);
        System.out.println("end");

    }

}
