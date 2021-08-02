/**
 * 
 */
package com.mm.sbdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author USER
 *
 */
@Controller
@ResponseBody
@RequestMapping("/api/v1/demo")
public class DemoController {
	
	@RequestMapping(path = "/welcome", method = {RequestMethod.GET})
	public String showWelcome() {
		return "<h1>Welcome To SpringBoot</h1>";
	}

}
