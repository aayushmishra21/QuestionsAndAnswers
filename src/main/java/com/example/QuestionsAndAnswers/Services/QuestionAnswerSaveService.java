package com.example.QuestionsAndAnswers.Services;

import com.example.QuestionsAndAnswers.Domain.QuestionAndAnswer;
import com.example.QuestionsAndAnswers.Repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class QuestionAnswerSaveService {

    @Autowired
    QuestionAnswerRepository questionAnswerRepository;

    public ResponseEntity<String> saveQuestionAnswer(String question, String answer) {
        if (checkQuestionAndAnswerForErrors(question, answer)) {
            return new ResponseEntity("Empty!", HttpStatus.BAD_REQUEST);
        }
        List<QuestionAndAnswer> questionAndAnswers = questionAnswerRepository.getQuesionAnswerByQuestion(question);
        if (questionAndAnswers.isEmpty()) {
            questionAnswerRepository.save(new QuestionAndAnswer(question, answer));
            return new ResponseEntity("Saved!", HttpStatus.OK);
        } else if (questionAndAnswers.get(0).getAnswer().equals(answer)) {
            return new ResponseEntity("Already Exists!", HttpStatus.BAD_REQUEST);
        } else {
            questionAndAnswers.get(0).setAnswer(answer);
            questionAnswerRepository.save(questionAndAnswers.get(0));
            return new ResponseEntity("Updated!", HttpStatus.OK);
        }
    }


    public Boolean checkQuestionAndAnswerForErrors(String question, String answer) {
         if (StringUtils.isEmpty(question) || StringUtils.isEmpty(answer))
            return Boolean.TRUE;

        return Boolean.FALSE;
    }

}
