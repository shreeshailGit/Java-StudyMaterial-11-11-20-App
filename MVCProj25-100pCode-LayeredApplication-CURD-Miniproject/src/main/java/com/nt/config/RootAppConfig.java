package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.nt.service,com.nt.dao")
@Import({PersistenceConfig.class,ServiceConfig.class,AOPConfig.class})
public class RootAppConfig {

}
