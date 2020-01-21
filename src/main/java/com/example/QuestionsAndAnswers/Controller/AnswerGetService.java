package com.example.QuestionsAndAnswers.Controller;

import com.example.QuestionsAndAnswers.Domain.QuestionAndAnswer;
import com.example.QuestionsAndAnswers.Repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class AnswerGetService {

    @Autowired
    QuestionAnswerRepository questionAnswerRepository;

    public ResponseEntity<String> getAnswer(String question) {
        if (checkQuestion(question)) {
            return new ResponseEntity("Empty!", HttpStatus.BAD_REQUEST);
        }
        List<String> answer = questionAnswerRepository.getAnswerByQuestion(question);
        if (answer.isEmpty()) {
            return new ResponseEntity("Not Found!", HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity("Answer is : "+answer.get(0), HttpStatus.OK);
    }

    public Boolean checkQuestion(String question) {
        if (StringUtils.isEmpty(question))
            return Boolean.TRUE;

        return Boolean.FALSE;
    }

}
