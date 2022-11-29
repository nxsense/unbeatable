package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Score {
    Scanner scanner = new Scanner(System.in);

    public List<Player> scoresTable() throws IOException {
        List<Player> playerList = new ArrayList<>();
        BufferedReader scoresFile = new BufferedReader(new FileReader("scoreTable.csv"));
        File file = new File("scoreTable.csv");
        Scanner sc = new Scanner(file);
        long playersNumber = scoresFile.lines().count();
        String score = "";

       // List<String> lines = scoresFile.lines().collect(Collectors.toList());
        while (sc.hasNextLine()){
        for (int i = 0; i < playersNumber; i++) {
            score = sc.nextLine();
            playerList.add(new Player(score.split(",")[0], Integer.parseInt(score.split(",")[1])));
        } }

        scoresFile.close();
        return playerList;
    }


    public void saveScore(int totalScore) throws IOException {
        System.out.println("Input your name for saving your progress: ");
        String name = scanner.nextLine();


        try{
            PrintWriter scoreSaving = new PrintWriter(new FileWriter("scoreTable.csv", true));
            scoreSaving.println(name + "," + totalScore);
            scoreSaving.close();
        } catch (IOException e){
            System.out.println("Problem while saving the score");
        }
        finally {
            System.out.println("Your score has been successfully saved to the score table.");
        }
    }



    public void showScore() throws IOException {
        List<Player> playerList = scoresTable().stream().sorted(Player::compareTo).collect(Collectors.toList());
        System.out.println("SCORE TABLE");
        System.out.println();
        System.out.println("-----------------------------");

        for (Player player: playerList) {
            System.out.println();
            System.out.println(player.getName() + " -- " + player.getScore());
            System.out.println("-----------------------------");
        }
    }
}
