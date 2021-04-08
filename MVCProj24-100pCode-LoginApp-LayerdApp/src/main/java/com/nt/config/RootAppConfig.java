package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan(basePackages = {"PersistenceConfig.class,ServiceConfig.class"})
@Import({PersistenceConfig.class,ServiceConfig.class,AOPConfig.class})
public class RootAppConfig {

}
