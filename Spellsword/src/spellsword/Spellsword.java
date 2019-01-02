/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellsword;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Elnic
 */
public class Spellsword {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        Scanner scan = new Scanner(System.in);

        int health = 100;
        int attack = 10;
        int enemyHealth = 100;
        int chance = 0;
        int kp = 1;
        String name;
        System.out.println("Please enter your name");
        name = scan.nextLine();
        System.out.println("Welcome, " + name + ", prepare for combat.");
        String[] spells = {"fireball", "freeze ray", "lightning"};

        Random ran = new Random();
        
        while (kp == 1) {
        while (enemyHealth > 0) {
            System.out.println("You see a troll. Attack(1) with sword or spell(2)?");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    chance = ran.nextInt(100) + 1;
                    if (chance > 20) {
                        enemyHealth = enemyHealth - attack;
                        System.out.println("enemy health: " + enemyHealth);
                        System.out.println("Your Health: " + health);
                        break;
                    } else {
                        health = health - 15;
                        System.out.println("Your Health: " + health);
                        System.out.println("enemy health: " + enemyHealth);
                        break;
                    }
                case 2:
                    System.out.println("Pick a spell: 1." + spells[0]);
                    System.out.println("2. " + spells[1]);
                    System.out.println("3. " + spells[2]);
                    choice = Integer.parseInt(scan.nextLine());
                    chance = ran.nextInt(100) + 1;
                    switch (choice) {
                        case 1:
                            if (chance > 50) {
                                enemyHealth = enemyHealth - 25;
                                break;
                            } else {
                                health = health - 10;
                                break;
                            }
                        case 2:
                            if (chance > 65) {
                                enemyHealth = enemyHealth - 30;
                                break;
                            } else {
                                health = health - 10;
                                break;
                            }
                        case 3:
                            if (chance > 80) {
                                enemyHealth = enemyHealth - 40;
                                break;
                            } else {
                                health = health - 10;
                                break;
                            }
                    }
                    System.out.println("Enemy Health: " + enemyHealth);
                    System.out.println("Your Health: " + health);

            }
        }
        if (health > 0 && enemyHealth <= 0) {
            System.out.println("You Win!");
        } else {
            System.out.println("You Lose");
        }
            System.out.println("press 1 to keep playing, or 2 to quit. Your health will be reset.");
            health = 100;
            enemyHealth = 100;
            kp = Integer.parseInt(scan.nextLine());
    }
        
    }

}
