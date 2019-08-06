package com.app.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.data.DataServices;
import com.app.mybatis.db1.UserMapping;
import com.app.mybatis.db2.UserSecondMapping;
import com.app.security.bean.Users;

@RestController
@RequestMapping("/mybatis")

public class WebRest {

	@Autowired
	private DataServices dataservices;
	@Autowired
	private UserSecondMapping userSecondMapping;
	@Autowired
	private UserMapping userMapping;

	@GetMapping("/{id}")
	public User alluser(@PathVariable int id) {
		dataservices.config();
		return userSecondMapping.findUserById(id);
	}

	@GetMapping("/all")
	public Iterable<User> getall() {
		dataservices.config();
		return userSecondMapping.findall();
	}

	@GetMapping("/test")
	public Object test() {
		JdbcTemplate jdbcTemplate = dataservices.config();
		return jdbcTemplate.queryForList("select * from student");

	}

	@GetMapping("/primary")
	public List<Users> primaryUser() {
		dataservices.config();
		return userMapping.findall();
	}

}
