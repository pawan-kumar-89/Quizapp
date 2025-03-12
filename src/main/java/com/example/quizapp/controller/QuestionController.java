package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/allquestions")
    public ResponseEntity<List<Question>> getAllquestion(){
        //return "Hi ,here is all question";
        return questionService.getAllquestions();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
       return questionService.getByCategory(category);
    }
    @PostMapping("/add")
    public ResponseEntity<String>  addquestion(@RequestBody  Question question){
        return questionService.addquestion(question);
    }
}
