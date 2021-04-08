package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {

	@Bean
	public JndiObjectFactoryBean createJOFB() {
		JndiObjectFactoryBean jofb =new JndiObjectFactoryBean();
		jofb.setJndiName("java:/comp/env/DsJndi");
		return jofb;
	}
	
	/*@Bean
	public JdbcTemplate createJT() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource((DataSource) createJOFB().getObject());
		return null;
	}*/
	@Bean
	public  JdbcTemplate  createSJC() {
		return new JdbcTemplate((DataSource) createJOFB().getObject());
	}
}
