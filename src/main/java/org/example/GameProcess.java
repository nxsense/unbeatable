package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameProcess {
    Scanner scanner = new Scanner(System.in);
    Score score = new Score();
    public int startQuiz() throws IOException {
        List<Question> allQuestions = allQuizQuestions();
        int totalScore = 0;
        System.out.println("Let the game started!");
        for (int questionNumber = 0; questionNumber < allQuestions.size(); questionNumber++) {
            System.out.println("Round number " + (questionNumber + 1));
            totalScore += answeringProcess(allQuestions.get(questionNumber));
        }

        System.out.println("Congrats! Your total score is " + totalScore);
        score.saveScore(totalScore);
        return totalScore;
    }

    public List<Question> allQuizQuestions() {
        final int FIRST_POINTS = 10;
        final int SECOND_POINTS = 5;
        final int THIRD_POINTS = 2;
        final int FOURTH_POINTS = 0;
        //final int NUMBER_OF_QUESTIONS = 5;

        List<Question> questionList = new ArrayList<>();

        List<String> possibleAnswers = Arrays.asList("Facebook", "Instagram", "Viber", "Telegram");
        List<Integer> points = Arrays.asList(FIRST_POINTS, SECOND_POINTS, THIRD_POINTS, FOURTH_POINTS);
        questionList.add(new Question("What was Meta Platforms Inc formerly known as?", possibleAnswers, points, "Facebook"));

        possibleAnswers = Arrays.asList("1993", "1994", "1992", "1991");
        points = Arrays.asList(THIRD_POINTS, FOURTH_POINTS, SECOND_POINTS, FIRST_POINTS);
        questionList.add(new Question("What year did ukraine gain independence?", possibleAnswers, points, "1991"));

        return questionList;
    }

    public int answeringProcess(Question question) {
        int score = 0;
        int answer;
        question.questionOutput();
        answer = answerValidation();
        score = question.getPoints().get(answer - 1);
        System.out.println("The right answer is: " + question.getRightAnswer());
        System.out.println("You gained " + score + " more points.");
        return score;
    }

    public int answerValidation() {
        int answer = 0;
        boolean valid = false;
        while (!valid) {
            System.out.println("Enter your answer please: ");
            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
                if (answer < 1 || answer > 4) {
                    System.out.println("Enter valid answer, it should be a number between 1 and 4.");
                } else {
                    valid = true;
                }
            }
        }

        return answer;
    }
}
