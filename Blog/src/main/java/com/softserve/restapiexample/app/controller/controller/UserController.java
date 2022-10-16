package com.softserve.restapiexample.app.controller.controller;

import com.softserve.restapiexample.app.controller.dto.UserDTO;
import com.softserve.restapiexample.app.controller.exception.ErrorResponse;
import com.softserve.restapiexample.app.controller.exception.FieldErrorMessage;
import com.softserve.restapiexample.app.controller.exception.UserAlreadyExistException;
import com.softserve.restapiexample.app.controller.exception.UserNotFoundException;
import com.softserve.restapiexample.app.controller.model.User;
import com.softserve.restapiexample.app.controller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
  @Autowired private UserService userService;

  @GetMapping()
  public List<UserDTO> findAllUsers() {
    return userService.findAllUser();
  }

  @PostMapping
  public void createUser(@Valid @RequestBody User user) {
    userService.createUser(user);
  }

  @GetMapping("/{id}")
  public UserDTO getUserById(@PathVariable Long id) {

    return userService.getUserById(id);
  }

  @PutMapping("/{id}")
  public User updateUser(@RequestBody User user, @PathVariable long id) {
    return userService.updateUserById(id, user);
  }

  @DeleteMapping("/{id}")
  public void deleteUserById(@PathVariable Long id) {
    userService.deleteUserById(id);
  }

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(value = UserAlreadyExistException.class)
  public ErrorResponse handleUserAlreadyExistException(UserAlreadyExistException e) {
    return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
  }

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(value = UserNotFoundException.class)
  public ErrorResponse handleUserNotFoundException(UserNotFoundException e) {
    return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  List<FieldErrorMessage> validationExceptionHandler(MethodArgumentNotValidException e) {
    List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
    List<FieldErrorMessage> fieldErrorMessages =
        fieldErrors.stream()
            .map(
                fieldError ->
                    new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()))
            .collect(Collectors.toList());
    return fieldErrorMessages;
  }
}
