package com.group15.answer;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

    Answer findByQuestionTitle(String title);
}
