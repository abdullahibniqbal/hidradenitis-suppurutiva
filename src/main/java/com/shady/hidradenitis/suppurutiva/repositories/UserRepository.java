package com.shady.hidradenitis.suppurutiva.repositories;

import com.shady.hidradenitis.suppurutiva.auth.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByNameAndPassword(String name, String password);
}
