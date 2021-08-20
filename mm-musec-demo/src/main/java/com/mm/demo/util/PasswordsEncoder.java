/**
 * 
 */
package com.mm.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * @author USER
 *
 */
public class PasswordsEncoder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PasswordEncoder noOpPasswordEncoder = NoOpPasswordEncoder.getInstance();
		System.out.println(noOpPasswordEncoder.encode("1234"));
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("ab34"));
		Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
		System.out.println(pbkdf2PasswordEncoder.encode("abcd"));
		StandardPasswordEncoder standardPasswordEncoder = new StandardPasswordEncoder();
		System.out.println(standardPasswordEncoder.encode("1234"));
	}

}
