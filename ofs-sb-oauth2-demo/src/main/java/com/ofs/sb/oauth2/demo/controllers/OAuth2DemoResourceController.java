/**
 * 
 */
package com.ofs.sb.oauth2.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dorak
 *
 */
@RestController
public class OAuth2DemoResourceController {
	@GetMapping("/")
	public String getIndexPage() {
		return "<h1>Home Page</h1>";
	}
}
