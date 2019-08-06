package com.app.security.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.security.bean.Users;

public interface UserCrud extends JpaRepository<Users, String>{
boolean existsByUsername(String username);
}
