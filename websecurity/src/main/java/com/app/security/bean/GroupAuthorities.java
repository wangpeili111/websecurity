package com.app.security.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "group_authorities")
public class GroupAuthorities {
	@Id
	private Integer group_id;
	private String authority;

}
