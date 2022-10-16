package com.softserve.restapiexample.app.controller.repository;

import com.softserve.restapiexample.app.controller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
}
