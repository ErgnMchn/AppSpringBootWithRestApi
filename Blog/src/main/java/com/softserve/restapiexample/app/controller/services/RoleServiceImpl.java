package com.softserve.restapiexample.app.controller.services;

import com.softserve.restapiexample.app.controller.dto.RoleDTO;
import com.softserve.restapiexample.app.controller.exception.RoleNotFoundException;
import com.softserve.restapiexample.app.controller.model.Role;
import com.softserve.restapiexample.app.controller.repository.RoleRepository;
import com.softserve.restapiexample.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
  @Autowired private RoleRepository roleRepository;

  @Autowired private Mapper mapper;

  public List<RoleDTO> findAllRoles() {
    List<Role> roles = roleRepository.findAll();

    if (!roles.isEmpty()) {

      return roleRepository.findAll().stream()
          .map(role -> mapper.mapRoleToDTO(role))
          .collect(Collectors.toList());
    } else {

      throw new RoleNotFoundException("Role Not Found");
    }
  }

  public void deleteUserRoleById(long id) {
    Role role = roleRepository.findById(id).orElse(null);
    if (role == null) {

      throw new RoleNotFoundException("NO ROLE PRESENT WITH ID =" + id);
    } else {

      roleRepository.delete(role);
    }
  }

  public void createRole(Role role) {

    roleRepository.save(role);
  }

  public Role updateUserRoleById(Role newRole, long id) {
    Role existingRole = roleRepository.findById(id).orElse(null);
    if (existingRole == null) {

      throw new RoleNotFoundException("No Such Role Exists!!");
    } else {

      existingRole.setRoleName(newRole.getRoleName());
      existingRole.setCreatedAt(newRole.getCreatedAt());

      return roleRepository.save(existingRole);
    }
  }

  public RoleDTO getRoleByUserId(Long id) {

    RoleDTO roleDTO =
        roleRepository.findById(id).map(role -> mapper.mapRoleToDTO(role)).orElse(null);

    if (roleDTO != null) {

      return roleDTO;

    } else {

      throw new RoleNotFoundException("NO ROLE PRESENT WITH ID =" + id);
    }
  }
}
