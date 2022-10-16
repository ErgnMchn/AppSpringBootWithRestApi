package com.softserve.restapiexample.mapper;

import com.softserve.restapiexample.dto.ArticleDTO;
import com.softserve.restapiexample.dto.CommentDTO;
import com.softserve.restapiexample.dto.RoleDTO;
import com.softserve.restapiexample.dto.UserDTO;
import com.softserve.restapiexample.model.Article;
import com.softserve.restapiexample.model.Comment;
import com.softserve.restapiexample.model.Role;
import com.softserve.restapiexample.model.User;

public class MapperImpl implements Mapper {
  public UserDTO mapUserToDTO(User user) {

    return new UserDTO(
        user.getFirstName(),
        user.getLastName(),
        user.getUserMail(),
        user.getUserNickName(),
        user.getRole().getRoleName(),
        user.getCreatedAt());
  }

  public ArticleDTO mapArticleToDTO(Article article) {

    return new ArticleDTO(
        article.getArticleName(),
        article.getArticleContent(),
        article.getArticleLikeCount(),
        article.getUser().getUserNickName(),
        article.getArticleCreatedAt());
  }

  public CommentDTO mapCommentToDTO(Comment comment) {
    return new CommentDTO(
        comment.getContent(),
        comment.getLikeCount(),
        comment.getArticle().getUser().getUserNickName(),
        comment.getCreatedAt());
  }

  public RoleDTO mapRoleToDTO(Role role) {
    return new RoleDTO(role.getRoleName(), role.getCreatedAt());
  }
}
