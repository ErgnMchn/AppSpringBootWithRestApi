package com.softserve.restapiexample.service;

import com.softserve.restapiexample.dto.RoleDTO;
import com.softserve.restapiexample.model.Role;

import java.util.List;

public interface RoleService {
    List<RoleDTO> findAllRoles();
    void deleteUserRoleById(long id);
    void createRole(Role role);
    Role updateUserRoleById(Role newRole, long id);
    RoleDTO getRoleByUserId(Long id);
}
