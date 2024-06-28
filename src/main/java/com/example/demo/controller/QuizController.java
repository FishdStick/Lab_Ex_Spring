package com.example.demo.controller;
import com.example.demo.model.Question;
import com.example.demo.model.StudentQuiz;
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
    private StudentQuiz studentQuiz;

    //I need this to redirect properly into the appropriate links
    @GetMapping("/quiz")
    public String showQuiz(Model model) {
        List <Question> questions = quizService.getShuffledQuestions();
        studentQuiz.setQuestions(questions);
        model.addAttribute("questions", questions);
        return "quiz";
    }

    @PostMapping("/submitQuiz")
    public String submitQuiz(@RequestParam List<String> answers, Model model) {
        int score = quizService.calculateScore(studentQuiz.getQuestions(), answers);
        studentQuiz.setScore(score);
        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String showGrades(Model model) {
        model.addAttribute("score", studentQuiz.getScore());
        model.addAttribute("questions", studentQuiz.getQuestions());
        return "grades";
    }

}
