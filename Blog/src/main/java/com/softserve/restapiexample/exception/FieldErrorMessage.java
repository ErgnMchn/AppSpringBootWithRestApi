package com.softserve.restapiexample.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FieldErrorMessage {
  private String field;
  private String message;
}
