package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuestionWrapper;
import com.example.quizapp.model.Response;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
@PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int noOfQuestions,@RequestParam String title){
   // return new ResponseEntity<>("I am here", HttpStatus.OK) ;
return quizService.createQuiz(category,noOfQuestions,title);
}
@GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable Integer id){
     return  quizService.getQuizQuestions(id);
}
@PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response){
    return quizService.calculateResult(id,response);
}
}
