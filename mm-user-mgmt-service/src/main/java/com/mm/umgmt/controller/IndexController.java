/**
 * 
 */
package com.mm.umgmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author USER
 *
 */
@RestController
public class IndexController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@GetMapping("/")
	public String getIndexPage(Model model) {
		LOGGER.info("in getIndexPage()");
		return "index";
	}
	
}
