package org.example;

import java.io.IOException;

public class Quiz {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        GameProcess gameProcess = new GameProcess();

        menu.startMenu();
        gameProcess.startQuiz();
    }

    
}
