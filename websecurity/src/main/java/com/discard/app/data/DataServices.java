package com.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataServices {

	@Autowired
	private MyDataSourcesConfig dataSourcesConfig;


	public JdbcTemplate config() {
		DataClass dataClass = new DataClass("mybatis", "com.mysql.jdbc.Driver",
				"jdbc:mysql://127.0.0.1:3306/test1?userSSL=true&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
				"root", "123456");
		dataSourcesConfig.setdatasource(dataClass);
		return dataSourcesConfig.setjdbJdbcTemplate(dataClass);
	}

}
