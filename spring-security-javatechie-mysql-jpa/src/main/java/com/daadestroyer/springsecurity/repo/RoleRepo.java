package com.daadestroyer.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daadestroyer.springsecurity.model.RoleModel;

@Repository
public interface RoleRepo extends JpaRepository<RoleModel, Integer> {

}
