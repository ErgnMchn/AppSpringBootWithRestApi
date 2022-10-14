package com.softserve.restapiexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotBlank
  private String roleName;
  @CreationTimestamp private Date createdAt;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "role_id", nullable = false, updatable = false)
  private List<User> users = new ArrayList<>();
}
