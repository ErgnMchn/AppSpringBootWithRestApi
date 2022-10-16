package com.softserve.restapiexample.services;

import com.softserve.restapiexample.dto.UserDTO;
import com.softserve.restapiexample.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<UserDTO> findAllUser();
    void deleteUserById(long id);
    public void createUser(User user);
    UserDTO getUserById(Long id);
    User updateUserById(long id, User newUser);
}
