package com.softserve.restapiexample.app.controller.dto;

import lombok.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  private String firstName;
  private String lastName;
  private String userMail;
  private String userNickName;
  private String roleName;
  private Date createdAt;
}
