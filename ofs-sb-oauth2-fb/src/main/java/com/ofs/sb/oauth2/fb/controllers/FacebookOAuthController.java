/**
 * 
 */
package com.ofs.sb.oauth2.fb.controllers;

import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author dorak
 *
 */
@RestController
public class FacebookOAuthController {
	
	private FacebookConnectionFactory factory = new FacebookConnectionFactory("777008432866350",
			"97de436513f715026ceabb3d7edc07b8");

	
	@GetMapping("/")
	public ModelAndView defaultIndexPage() {
		System.out.println("defaultIndexPage()");
		return new ModelAndView("index");
	}
	
	@GetMapping(value = "/facebooklogin")
	public String loginWithFacebook() {

		OAuth2Operations operations = factory.getOAuthOperations();
		OAuth2Parameters params = new OAuth2Parameters();

		params.setRedirectUri("http://localhost:8084/of/userinfo");
		params.setScope("email,public_profile");

		String url = operations.buildAuthenticateUrl(params);
		System.out.println("The URL is" + url);
		return "redirect:" + url;

	}
	
	@GetMapping(value = "/userinfo")
	public ModelAndView prodducer(@RequestParam("code") String authorizationCode) {
		OAuth2Operations operations = factory.getOAuthOperations();
		AccessGrant accessToken = operations.exchangeForAccess(authorizationCode, "http://localhost:8084/of/userinfo",
				null);

		Connection<Facebook> connection = factory.createConnection(accessToken);
		Facebook facebook = connection.getApi();
		String[] fields = { "id", "email", "first_name", "last_name" };
		User userProfile = facebook.fetchObject("me", User.class, fields);
		ModelAndView model = new ModelAndView("userinfo");
		model.addObject("userprofile", userProfile);
		return model;

	}
	
}
