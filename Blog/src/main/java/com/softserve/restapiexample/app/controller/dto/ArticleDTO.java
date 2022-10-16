package com.softserve.restapiexample.app.controller.dto;

import lombok.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
  private String articleName;
  private String articleContent;
  private long articleLikeCount;
  private String userNickName;
  private Date createdAt;
}
