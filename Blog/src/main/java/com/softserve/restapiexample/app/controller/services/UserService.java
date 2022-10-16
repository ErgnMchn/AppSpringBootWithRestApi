package com.softserve.restapiexample.app.controller.services;

import com.softserve.restapiexample.app.controller.dto.UserDTO;
import com.softserve.restapiexample.app.controller.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUser();
    void deleteUserById(long id);
    void createUser(User user);
    UserDTO getUserById(Long id);
    User updateUserById(long id, User newUser);
}
