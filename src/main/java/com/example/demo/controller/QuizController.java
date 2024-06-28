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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public String submitQuiz(@RequestParam Map<String, String> params, Model model) {

        List<String> answers = new ArrayList<>();
        List<String> questions = new ArrayList<>();

        // Extract answers and questions from params
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey().startsWith("answers[")) {
                answers.add(entry.getValue());
            } else if (entry.getKey().startsWith("questions[")) {
                questions.add(entry.getValue());
            }
        }
        int score = quizService.calculateScore(quizModel.getQuestions(), answers);
        quizModel.setScore(score);
        model.addAttribute("score", score);
        model.addAttribute("questions", questions);
        return "submitQuiz";
    }

    @GetMapping("/grades")
    public String showGrades(Model model) {
        model.addAttribute("score", quizModel.getScore());
        model.addAttribute("questions", quizModel.getQuestions());
        return "viewStudentGrades";
    }

}
