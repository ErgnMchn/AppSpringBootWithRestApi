package com.softserve.restapiexample.repository;

import com.softserve.restapiexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
}
