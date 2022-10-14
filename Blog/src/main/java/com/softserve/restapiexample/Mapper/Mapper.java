package com.softserve.restapiexample.Mapper;

import com.softserve.restapiexample.dto.ArticleDTO;
import com.softserve.restapiexample.dto.CommentDTO;
import com.softserve.restapiexample.dto.RoleDTO;
import com.softserve.restapiexample.dto.UserDTO;
import com.softserve.restapiexample.model.Article;
import com.softserve.restapiexample.model.Comment;
import com.softserve.restapiexample.model.Role;
import com.softserve.restapiexample.model.User;

public interface Mapper {
    UserDTO mapUserToDTO(User user);
    ArticleDTO mapArticleToDTO(Article article);
    CommentDTO mapCommentToDTO(Comment comment);
    RoleDTO mapRoleToDTO(Role role);
}
