package com.softserve.restapiexample.service;

import com.softserve.restapiexample.dto.UserDTO;
import com.softserve.restapiexample.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUser();
    void deleteUserById(long id);
    void createUser(User user);
    UserDTO getUserById(Long id);
    User updateUserById(long id, User newUser);
}
