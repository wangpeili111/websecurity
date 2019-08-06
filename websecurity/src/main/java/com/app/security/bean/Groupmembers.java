package com.app.security.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="group_members")
public class Groupmembers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String username;
private Integer group_id;

}
