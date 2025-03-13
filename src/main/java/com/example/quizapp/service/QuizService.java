package com.example.quizapp.service;

import com.example.quizapp.Dao.QuestionRepo;
import com.example.quizapp.Dao.QuizRepo;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuestionWrapper;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
     @Autowired
     private QuizRepo quizRepo;
     @Autowired
     private QuestionRepo questionRepo;
     public ResponseEntity<String> createQuiz(String category, int noOfQuestions, String title) {
        List<Question> questions=questionRepo.findRandomQuestionsByCategory(category,noOfQuestions);

        Quiz quiz = new Quiz();

        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
    Optional<Quiz> quiz=quizRepo.findById(id);
    List<Question> questionsFromDb=quiz.get().getQuestions();
    List<QuestionWrapper> questionForUser= new ArrayList<>();
     for(Question q:questionsFromDb){
         QuestionWrapper qw=new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
      questionForUser.add(qw);
     }

    return new ResponseEntity<>(questionForUser,HttpStatus.OK);
     }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
   Quiz quiz=quizRepo.findById(id).get();
    List<Question> questions=quiz.getQuestions();
    int right=0;
    int i=0;
    for(Response res:response){
        if(res.getResponse().equals(questions.get(i).getRightAnswer()))
            right++;
        i++;
    }
    return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
