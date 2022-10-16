package com.softserve.restapiexample.services;

import com.softserve.restapiexample.dto.RoleDTO;
import com.softserve.restapiexample.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleService {
    List<RoleDTO> findAllRoles();
    void deleteUserRoleById(long id);
    void createRole(Role role);
    Role updateUserRoleById(Role newRole, long id);
    RoleDTO getRoleByUserId(Long id);
}
