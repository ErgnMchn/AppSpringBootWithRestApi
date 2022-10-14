package com.softserve.restapiexample.repository;

import com.softserve.restapiexample.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
