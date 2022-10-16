package com.softserve.restapiexample.mapper;

import com.softserve.restapiexample.app.controller.dto.ArticleDTO;
import com.softserve.restapiexample.app.controller.dto.CommentDTO;
import com.softserve.restapiexample.app.controller.dto.RoleDTO;
import com.softserve.restapiexample.app.controller.dto.UserDTO;
import com.softserve.restapiexample.app.controller.model.Article;
import com.softserve.restapiexample.app.controller.model.Comment;
import com.softserve.restapiexample.app.controller.model.Role;
import com.softserve.restapiexample.app.controller.model.User;

public interface Mapper {
  UserDTO mapUserToDTO(User user);

  ArticleDTO mapArticleToDTO(Article article);

  CommentDTO mapCommentToDTO(Comment comment);

  RoleDTO mapRoleToDTO(Role role);
}
