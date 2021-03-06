package com.group15.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {
    // CrudRepository is automatically creating the create read update delete operations for us
    Page<Question> findByCategoryTitle(String title, Pageable pageable);



}
