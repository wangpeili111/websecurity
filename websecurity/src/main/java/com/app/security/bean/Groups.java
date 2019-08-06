package com.app.security.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class Groups {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	private String groupname;

}
