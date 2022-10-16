package com.softserve.restapiexample.app.controller.dto;

import lombok.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

  private String content;
  private int likeCount;
  private String userNickName;
  private Date createdAt;
}
