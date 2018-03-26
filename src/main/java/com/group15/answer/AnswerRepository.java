package com.group15.answer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

    Answer findByQuestionTitle(String title);

}
