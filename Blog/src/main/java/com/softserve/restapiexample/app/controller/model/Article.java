package com.softserve.restapiexample.app.controller.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotBlank
  private String articleName;
  @NotBlank
  private String articleContent;
  private long articleLikeCount;
  @CreationTimestamp private Date articleCreatedAt;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  private User user;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "article_id", nullable = false, updatable = false)
  private List<Comment> comments = new ArrayList<>();
}
