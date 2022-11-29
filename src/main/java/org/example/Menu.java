package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Score score = new Score();
    public void startMenu() throws IOException {
        System.out.println();
        System.out.println("Hi! Welcome to UNBEATABLE! <3");
        System.out.println();
        menuOptions();
        System.out.println();

        boolean valid = false;

        while (!valid){
            System.out.println("Enter your choice: ");
            int flag = scanner.nextInt();
            if(flag == 1){
                rulesOutput();
                menuOptions();
            }
            else if (flag == 2){
                valid = true;
            }
            else if(flag == 3){
                score.showScore();
                menuOptions();
            }
            else System.out.println("Enter a valid option.");
        }
    }

    public void rulesOutput(){
        System.out.println();
        System.out.println("Quiz rules: ");
        System.out.println();
        System.out.println("1) There are 5 different questions.");
        System.out.println("2) Each question has 4 options and only one of them is correct.");
        System.out.println("3) Depending on how close your answer was to the truth, you can get 10, 5, 2 or 0 points.");
        System.out.println();
    }

    public void menuOptions(){
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("1. Rules");
        System.out.println("2. Start the game");
        System.out.println("3. Show the score table");
        System.out.println();
    }
}
