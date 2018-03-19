package com.group15.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.security.AllPermission;

//@  RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long> {
    // We use the repositoryRestResource annotation so that our user repo isn't exported
    // with the api, for example we don't want someone for to /users and see all our users

    User findByUsername(String username);
}
