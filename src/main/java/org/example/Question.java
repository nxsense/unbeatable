package org.example;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> answers;
    private List<Integer> points;
    private String rightAnswer;

    public Question(String questionText, List<String> answers, List<Integer> points, String rightAnswer) {
        this.questionText = questionText;
        this.answers = answers;
        this.points = points;
        this.rightAnswer = rightAnswer;
    }

    public Question() {
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public List<Integer> getPoints() {
        return points;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public void questionOutput(){
        System.out.println(questionText);
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(i+1 + ". " + answers.get(i));
        }
    }
}
