/**
 * 
 */
package com.ofs.sb.oauth2.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author dorak
 *
 */
public class PasswordsEncoderUtility {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("Password :: " + encoder.encode("password"));

	}

}
