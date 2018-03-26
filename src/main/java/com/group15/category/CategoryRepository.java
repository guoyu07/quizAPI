package com.group15.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {


    @RestResource(rel = "title-contains", path = "containsTitle")
    Page<Category> findByTitleContaining(@Param("title") String title, Pageable page);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(@Param("category") Category entity);




}
