package com.app.security.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.security.bean.Authorities;

public interface AuthorCrud extends JpaRepository<Authorities, String>{

}
