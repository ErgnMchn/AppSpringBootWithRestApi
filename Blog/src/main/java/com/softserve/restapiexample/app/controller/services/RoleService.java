package com.softserve.restapiexample.app.controller.services;

import com.softserve.restapiexample.app.controller.dto.RoleDTO;
import com.softserve.restapiexample.app.controller.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {
    List<RoleDTO> findAllRoles();
    void deleteUserRoleById(long id);
    void createRole(Role role);
    Role updateUserRoleById(Role newRole, long id);
    RoleDTO getRoleByUserId(Long id);
}
