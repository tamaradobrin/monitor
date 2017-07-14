package com.monitor.repository;

import com.monitor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

  User findByUserName(String userName);
}
