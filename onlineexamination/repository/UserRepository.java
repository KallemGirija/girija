package com.cg.onlineexamination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamination.entity.User;

@Repository

public interface UserRepository extends JpaRepository<User, Integer>{

}
