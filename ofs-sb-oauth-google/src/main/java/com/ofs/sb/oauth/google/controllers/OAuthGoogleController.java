/**
 * 
 */
package com.ofs.sb.oauth.google.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author dorak
 *
 */
@RestController
public class OAuthGoogleController {
	@GetMapping("/")
	public ModelAndView defaultHomePage() {
		System.out.println("defaultHomePage()");
		return new ModelAndView("home");
	}

	@GetMapping("/login")
	public ModelAndView loginPage() {
		System.out.println("loginPage()");
		return new ModelAndView("login");
	}

	@GetMapping("admin")
	public String adminPage() {
		return "<h2>Welcome Admin</h2>";
	}

	@GetMapping("userdata")
	public String userPage() {
		return "<h2>Welcome User</h2>";
	}

	@RequestMapping(value = "/user")
	public Principal user(Principal principal) {
		System.out.println("User Name :: " + principal.getName());
		return principal;
	}
}
