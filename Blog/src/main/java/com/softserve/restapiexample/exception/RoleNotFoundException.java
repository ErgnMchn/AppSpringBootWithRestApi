package com.softserve.restapiexample.exception;

public class RoleNotFoundException extends RuntimeException {
  private String message;

  public RoleNotFoundException(String message) {
    super(message);
    this.message = message;
  }
}
