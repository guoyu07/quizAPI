package com.group15.question;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {
    // CrudRepository is automatically creating the create read update delete operations for us
}
