package com.example.demo.model;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class QuizService {

    public List<Question> getShuffledQuestions(){
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question("Who delivered the Gettysburg Address?",
                Arrays.asList("Abraham Lincoln", "George Washington", "Paul Revere", "Joseph Smith"),
                "Abraham Lincoln"));

        questions.add(new Question("What's big, lives in the sea, and has pointy teeth?",
                Arrays.asList("Shark", "Jelly Fish", "Turtle", "Barracuda"),
                "Shark"));

        questions.add(new Question("Who is the son of Mary?",
                Arrays.asList("Joseph", "Jesus", "Matthew", "Boris"),
                "Jesus"));

        questions.add(new Question("Where does Santa live?",
                Arrays.asList("North Western Pole", "Fireplace", "North Pole", "Chimney"),
                "North Pole"));

        questions.add(new Question(" Which is the heaviest?",
                Arrays.asList("Feathers", "Aluminum", "Steel", "Titanium"),
                "Steel"));

        Collections.shuffle(questions);
        questions.forEach(question -> Collections.shuffle(question.getChoices()));

        return questions;
    }

    public int calculateScore(List<Question> questions, List<String> userAnswers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getCorrectAnswer().equals(userAnswers.get(i))) {
                score++;
            }
        }
        return score;
    }

    //Needs to use the length of the list as total questions
    //Needs to use the score from the calculateScore() function
    public int computePercentage(int score, int totalQuestions) {

        if (totalQuestions == 0) {
            return 0;
        }
        return (int) ((score / (double) totalQuestions) * 100);
    }

}
