package com.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import com.cloud.config.AppConfig;

@Configuration
@ComponentScan
//开启@Repositories注解
@EnableJpaRepositories
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Import(value={AppConfig.class})
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class Application {

	public static void main(String[] args) {
		SecurityContextHolder.getContext()
				.setAuthentication(new UsernamePasswordAuthenticationToken("user", "123456",
						AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER")));
		
		SpringApplication application = new SpringApplication(Application.class);
		
		application.run(args);
	}

}
