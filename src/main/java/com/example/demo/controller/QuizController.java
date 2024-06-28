package com.example.demo.controller;
import com.example.demo.model.Question;
import com.example.demo.model.QuizModel;
import com.example.demo.model.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuizModel quizModel;

    //I need this to redirect properly into the appropriate links
    @GetMapping("/quiz")
    public String showQuiz(Model model) {
        List <Question> shuffledQuestions = quizService.getShuffledQuestions();
        quizModel.setQuestions(shuffledQuestions);
        model.addAttribute("questions", shuffledQuestions);
        return "quiz";
    }

    @PostMapping("/submitQuiz")
    public String submitQuiz(@RequestParam List<String> answers) {
        int score = quizService.calculateScore(quizModel.getQuestions(), answers);
        quizModel.setScore(score);
        return "submitQuiz";
    }

    @GetMapping("/grades")
    public String showGrades(Model model) {
        model.addAttribute("score", quizModel.getScore());
        model.addAttribute("questions", quizModel.getQuestions());
        return "grades";
    }

}
