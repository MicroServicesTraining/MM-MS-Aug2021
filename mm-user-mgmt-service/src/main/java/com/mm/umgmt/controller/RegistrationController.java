/**
 * 
 */
package com.mm.umgmt.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author USER
 *
 */
@RestController
public class RegistrationController {
	@GetMapping("/registration")
	public ModelAndView getRegistrationPage(Model model) {
		return new ModelAndView("registration");
	}
}
