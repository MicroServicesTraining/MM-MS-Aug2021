/**
 * 
 */
package com.mm.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author USER
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//we do authentication configuration here for users and their roles
		
		auth.jdbcAuthentication().passwordEncoder(noOpPasswordEncoder())
		.dataSource(dataSource)
		.usersByUsernameQuery("SELECT username, password, enabled FROM account_holders where username = ?")
		.authoritiesByUsernameQuery("SELECT username, authority from roles where username = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//we do authorization configuration here for protected resource access permission for user roles
		http.authorizeRequests()
				/*
				 * .antMatchers("/products/admin").hasRole("ADMIN")
				 * .antMatchers("/products/admin/newseller").hasRole("ADMIN")
				 * .antMatchers("/products/admin/allsellers").hasRole("ADMIN")
				 */
		.antMatchers("/products/admin/**").hasRole("ADMIN")
		.antMatchers("/products/seller").hasRole("SELLER")
		.antMatchers("/products/customer").hasAnyRole("CUSTOMER", "ADMIN")
		.antMatchers("/products/welcome").permitAll()
		.and().formLogin();
	}
	
	@Bean
	public PasswordEncoder noOpPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}



}
