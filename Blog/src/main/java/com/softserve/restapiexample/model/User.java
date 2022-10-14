package com.softserve.restapiexample.model;

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
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank private String firstName;
  @NotBlank private String lastName;
  @NotBlank private String userMail;
  @NotBlank private String userPassword;
  @NotBlank private String userNickName;
  @CreationTimestamp private Date createdAt;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", nullable = false, updatable = false)
  private List<Article> articles = new ArrayList<>();

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "role_id", insertable = false, updatable = false)
  private Role role;
}
