package com.app.data;



import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

public class DataBean {
    @Bean(name = "db1")
   // application.properteis中对应属性的前缀
    public DataSource dataSource1() {
    	
        return DataSourceBuilder.create().build();
    }
}
