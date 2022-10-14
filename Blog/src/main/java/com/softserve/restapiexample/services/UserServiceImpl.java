package com.softserve.restapiexample.services;

import com.softserve.restapiexample.Mapper.Mapper;
import com.softserve.restapiexample.dto.UserDTO;
import com.softserve.restapiexample.exception.UserAlreadyExistException;
import com.softserve.restapiexample.exception.UserNotFoundException;
import com.softserve.restapiexample.model.User;
import com.softserve.restapiexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
  @Autowired private UserRepository userRepository;

  @Autowired private Mapper mapper;

  public List<UserDTO> findAllUser() {

    List<User> users = userRepository.findAll();

    if (!users.isEmpty()) {
      return userRepository.findAll().stream()
          .map(user -> mapper.mapUserToDTO(user))
          .collect(Collectors.toList());
    } else {
      throw new UserNotFoundException("User Not Found");
    }
  }

  public void deleteUserById(long id) {
    User user = userRepository.findById(id).orElse(null);
    if (user == null) {
      throw new UserNotFoundException("NO USER PRESENT WITH ID =" + id);
    } else {
      userRepository.delete(user);
    }
  }

  public void createUser(User user) {
    User existingUser = userRepository.findById(user.getId()).orElse(null);
    if (existingUser == null) {
      userRepository.save(user);
    } else {

      throw new UserAlreadyExistException("User is already exist!!");
    }
  }

  public UserDTO getUserById(Long id) {

    Optional<User> user = userRepository.findById(id);

    if (user.isPresent()) {
      UserDTO userDTO = mapper.mapUserToDTO(user.get());
      return userDTO;
    } else {
      throw new UserNotFoundException("NO USER PRESENT WITH ID =" + id);
    }
  }

  public User updateUserById(long id, User newUser) {
    User existingUser = userRepository.findById(id).orElse(null);
    if (existingUser == null) {
      throw new UserNotFoundException("No Such User Exists!!");
    } else {

      existingUser.setFirstName(newUser.getFirstName());
      existingUser.setLastName(newUser.getLastName());
      existingUser.setUserMail(newUser.getUserMail());
      existingUser.setUserPassword(newUser.getUserPassword());
      existingUser.setUserNickName(newUser.getUserNickName());
      return userRepository.save(existingUser);
    }
  }
}
