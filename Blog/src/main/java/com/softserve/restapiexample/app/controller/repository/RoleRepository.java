package com.softserve.restapiexample.app.controller.repository;

import com.softserve.restapiexample.app.controller.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
