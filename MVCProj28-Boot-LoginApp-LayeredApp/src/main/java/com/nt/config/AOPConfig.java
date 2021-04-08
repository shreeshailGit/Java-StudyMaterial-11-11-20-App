package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


@Configuration

public class AOPConfig {
	 @Autowired
	  private DataSource ds;


	@Bean
	public DataSourceTransactionManager createDTM() {
		return new DataSourceTransactionManager(ds);
	}

}
