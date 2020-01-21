package com.example.QuestionsAndAnswers.Controller;

import com.example.QuestionsAndAnswers.Services.QuestionAnswerSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionSaveController {

    @Autowired
    QuestionAnswerSaveService questionAnswerSaveService;

    @Autowired
    AnswerGetService answerGetService;

    @RequestMapping("/save")
    @PostMapping
    public ResponseEntity<String> saveQuestionAndAnswer(@RequestParam String question, @RequestParam String answer) {
        return questionAnswerSaveService.saveQuestionAnswer(question, answer);
}

@RequestMapping("/get")
    @GetMapping
    public ResponseEntity<String> getAnswerFromQuestion(@RequestParam String question)
{

    return answerGetService.getAnswer(question);
}

}
