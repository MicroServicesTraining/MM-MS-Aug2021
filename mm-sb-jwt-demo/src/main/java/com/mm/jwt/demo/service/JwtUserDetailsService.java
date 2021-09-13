/**
 * 
 */
package com.mm.jwt.demo.service;


import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author dorak
 *
 */
@Component
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// here we need to write db access code to get userdetails
		if ("demouser".equals(username)) {
			return new User("demouser", "$2a$10$SnDgXPsjfV0NaMil2bdtaOfxp3yP8Qse/YFLDtcq6PoUI4Ct49hEO",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}