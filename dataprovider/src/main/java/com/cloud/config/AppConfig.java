package com.cloud.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class AppConfig{
	

	//云环境下数据库自动配置
	@Configuration
    @Profile("cloud")
	static  class CloudConfiguration {

        @Bean
        public DataSource dataSource() {
        	System.out.println("cloud....................................");
            CloudFactory cloudFactory = new CloudFactory();
            Cloud cloud = cloudFactory.getCloud();
            String serviceID = cloud.getServiceInfos().get(0).getId();
            return cloud.getServiceConnector(serviceID, DataSource.class, null);
        	//return connectionFactory().dataSource();
        }
    }

	//本地环境下手动配置
    @Configuration
    @Profile("default")
    static class LocalConfiguration {
    	@Autowired
    	private Environment env;

    @Bean
        public DataSource dataSource() {
    	System.out.println("local....................................");
    	    org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
    	    ds.setUrl(env.getProperty("db.url"));
    	    ds.setDriverClassName(env.getProperty("db.driverClassName"));
    	    ds.setUsername(env.getProperty("db.username"));
    	    ds.setPassword(env.getProperty("db.password"));
            return ds;
        }
    }

}
