package com.softserve.restapiexample.app.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotBlank
  private String content;
  private int likeCount;
  @CreationTimestamp private Date createdAt;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "article_id", insertable = false, updatable = false)
  private Article article;
}
