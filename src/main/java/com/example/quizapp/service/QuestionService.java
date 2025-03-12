package com.example.quizapp.service;

import com.example.quizapp.Dao.QuestionRepo;
import com.example.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private QuestionService questionService;
    @Autowired
    private QuestionRepo questionRepo;
    public ResponseEntity<List<Question>> getAllquestions() {
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getByCategory(String category) {

        try {
            return new ResponseEntity<>(questionRepo.findByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addquestion(Question question) {
   questionRepo.save(question);
   try{
       return new ResponseEntity<>("success",HttpStatus.CREATED);
   } catch (Exception e) {
       e.printStackTrace();
   }
   return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
    }
}
