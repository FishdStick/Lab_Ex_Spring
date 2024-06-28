package com.example.demo.model;

import java.util.List;


public class Question {

    private String questionText;
    private List<String> choices;
    private String correctAnswer;

    public Question(String question, List<String> choices, String correctAnswer) {
        this.questionText = question;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    // Getters and Setters

    //Every getter function gets the values of the parameters when the class is instantiated
    public String getQuestion() {
        return questionText;
    }

    public void setQuestion(String question) {
        this.questionText = question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}
