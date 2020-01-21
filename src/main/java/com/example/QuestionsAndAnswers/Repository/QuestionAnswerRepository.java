package com.example.QuestionsAndAnswers.Repository;

import com.example.QuestionsAndAnswers.Domain.QuestionAndAnswer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAnswerRepository extends CrudRepository<QuestionAndAnswer,Long> {


    @Query(value  = "select * from question_and_answer where question = ?1", nativeQuery = true)
    List<QuestionAndAnswer> getQuesionAnswerByQuestion(String question);

    @Query(value  = "select answer from question_and_answer where question = ?1", nativeQuery = true)
    List<String> getAnswerByQuestion(String question);


}
