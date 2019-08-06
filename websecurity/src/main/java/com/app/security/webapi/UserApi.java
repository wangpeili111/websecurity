package com.app.security.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.security.bean.Users;
import com.app.security.crud.UserCrud;

@RestController
@RequestMapping("/api/user")
public class UserApi {
	@Autowired
	UserCrud usercrud;

	@GetMapping("/get")
	public List<Users> getuser() {
		return usercrud.findAll();
	}
	
	@GetMapping("/page")
	public Page<Users> pageuser(){
		return usercrud.findAll(PageRequest.of(0, 20));
	}
}
