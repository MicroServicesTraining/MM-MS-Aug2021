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
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author dorak
 *
 */
@RestController
public class FacebookOAuthController {
	
	private FacebookConnectionFactory factory = new FacebookConnectionFactory("452491612605440",
			"c9ac9f76b5f6a480009b703baa09c7ef");

	
	@GetMapping("/")
	public ModelAndView defaultIndexPage() {
		System.out.println("defaultIndexPage()");
		return new ModelAndView("index");
	}
	
	@GetMapping(value = "/facebooklogin")
	public RedirectView loginWithFacebook() {

		OAuth2Operations operations = factory.getOAuthOperations();
		OAuth2Parameters params = new OAuth2Parameters();

		params.setRedirectUri("http://localhost:8084/of/userinfo");
		params.setScope("email,public_profile");

		String url = operations.buildAuthenticateUrl(params);
		System.out.println("The URL is" + url);
		//return "redirect:" + url;
		return new RedirectView(url);

	}
	
	@GetMapping(value = "/userinfo")
	public ModelAndView loadUserInfo(@RequestParam("code") String authorizationCode) {
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
