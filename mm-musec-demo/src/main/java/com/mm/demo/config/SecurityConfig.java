/**
 * 
 */
package com.mm.demo.config;

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

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//we do authentication configuration here for users and their roles
		/*auth.inMemoryAuthentication()
		.withUser("sekhar").password("{noop}1234").roles("ADMIN")
		.and()
		.withUser("hari").password("{pbkdf2}a3f3c12beb4d4fe35fab3269d0b9077c84e8b57128e5aae47664f5179629ab951892faf796078fab").roles("USER")
		.and()
		.withUser("anusha").password("{bcrypt}$2a$10$2kS/BcCKc7HQYCpA6rcP9eRh3g9qaDwEt33lBK943VrtqoAH0pm1W").roles("USER");*/
		
		auth.inMemoryAuthentication()
		.withUser("sekhar").password("1234").roles("ADMIN", "SELLER")
		.and()
		.withUser("ravi").password("12cd").roles("ADMIN")
		.and()
		.withUser("hari").password("abcd").roles("SELLER")
		.and()
		.withUser("anusha").password("ab34").roles("CUSTOMER");
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
