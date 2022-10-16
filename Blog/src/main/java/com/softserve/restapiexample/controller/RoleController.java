package com.softserve.restapiexample.controller;

import com.softserve.restapiexample.dto.RoleDTO;
import com.softserve.restapiexample.exception.ErrorResponse;
import com.softserve.restapiexample.exception.RoleNotFoundException;
import com.softserve.restapiexample.model.Role;
import com.softserve.restapiexample.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
  @Autowired private RoleService roleService;

  @GetMapping
  public List<RoleDTO> findAllRoles() {
    return roleService.findAllRoles();
  }

  @PostMapping
  public void createRole(@RequestBody Role role) {
    roleService.createRole(role);
  }

  @GetMapping("/{id}")
  public RoleDTO getUserRoleById(@PathVariable("id") long id) {
    return roleService.getRoleByUserId(id);
  }

  @PutMapping("/{id}")
  public Role updateRoleById(@PathVariable Role role, @RequestBody long id) {

    return roleService.updateUserRoleById(role, id);
  }

  @DeleteMapping("/{id}")
  public void deleteUserRoleById(@PathVariable Long id) {
    roleService.deleteUserRoleById(id);
  }

  @ExceptionHandler(value = RoleNotFoundException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ErrorResponse handleRoleNotFoundException(RoleNotFoundException e) {
    return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
  }
}
