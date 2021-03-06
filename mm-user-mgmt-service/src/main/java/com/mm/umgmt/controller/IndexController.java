/**
 * 
 */
package com.mm.umgmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author USER
 *
 */
@RestController
public class IndexController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@GetMapping("/")
	public ModelAndView getIndexPage(Model model) {
		LOGGER.info("in getIndexPage()");
		return new ModelAndView("index"); // prefix+viewname+suffix  /view/index.jsp
	}
	
}
