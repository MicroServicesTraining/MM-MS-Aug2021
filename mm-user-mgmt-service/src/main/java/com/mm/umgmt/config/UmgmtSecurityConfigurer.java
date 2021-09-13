/**
 * 
 */
package com.mm.umgmt.config;

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
public class UmgmtSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication().withUser("sekhar").password("1234").roles(
		 * "ADMIN", "SELLER").and()
		 * .withUser("ravi").password("12cd").roles("ADMIN").and().withUser("hari").
		 * password("abcd")
		 * .roles("SELLER").and().withUser("anusha").password("ab34").roles("CUSTOMER");
		 */
		
		auth.jdbcAuthentication().passwordEncoder(noOpPasswordEncoder())
		.dataSource(dataSource)
		.usersByUsernameQuery("SELECT username, password, enabled FROM account_holders where username = ?")
		.authoritiesByUsernameQuery("SELECT username, authority from roles where username = ?");
	}


	@Override
	public void configure(HttpSecurity http) throws Exception {
		http 
			.csrf() 
			.disable()
			.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/seller").hasRole("SELLER")
			.antMatchers("/customer").hasRole("CUSTOMER")
			.antMatchers("/").hasAnyRole("ADMIN", "SELLER", "CUSTOMER")
			.and()
			.formLogin().loginPage("/login").permitAll();

	}

	@Bean
	public PasswordEncoder noOpPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
