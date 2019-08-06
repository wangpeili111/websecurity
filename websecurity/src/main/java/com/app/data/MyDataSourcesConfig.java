package com.app.data;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class MyDataSourcesConfig {

	
	public DataSource setdatasource(DataClass dataClass) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dataClass.getDataname());
		dataSource.setUrl(dataClass.getDataurl());
		dataSource.setUsername(dataClass.getDatausername());
		dataSource.setPassword(dataClass.getDatapassword());
		return dataSource;
	}
	
	public JdbcTemplate setjdbJdbcTemplate(DataClass dataClass) {
		JdbcTemplate jdbcTemplate= new JdbcTemplate(this.setdatasource(dataClass));
		return jdbcTemplate;	
	}
	
	
}
