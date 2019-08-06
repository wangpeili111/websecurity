package com.app.security.bean;

//用户名及密码
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;
@Data
@Entity
public class Users {
	@Id
	private String username;
	@Lob
	private String password;
	private Boolean enabled;



}
