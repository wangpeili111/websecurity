package com.app.data;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DataClass {

	@Id
	private String idname;
	private String dataname;
	private String dataurl;
	private String datausername;
	private String datapassword;

	DataClass(String idname, String dataname, String dataurl, String datausername, String datapassword) {

		this.idname = idname;
		this.dataname = dataname;
		this.dataurl = dataurl;
		this.datausername = datausername;
		this.datapassword = datapassword;

	}

}
