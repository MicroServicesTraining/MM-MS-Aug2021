/**
 * 
 */
package com.mm.sbdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.sbdemo.util.PropsUtil;
import com.mm.sbdemo.util.SBDemoPropsUtil;

/**
 * @author USER
 *
 */
@RestController
@RequestMapping(path = "/api/v1/hello")
public class HelloController {

	@Autowired
	private PropsUtil props;
	
	@Autowired
	private SBDemoPropsUtil sbProps;

	/*
	 * @Value(value = "${sbdemo.appname:App name is missing}") private String
	 * appName;
	 * 
	 * @Value("${sbdemo.count}") private long count;
	 * 
	 * @Value("${server.port}") private long port;
	 */

	@GetMapping
	public String sayHello() {
		// return "<h1>"+appName+"</h1>"+"<h2>Hello...!</h2>"+"<h3>Count ::
		// "+count+"</h3>"+"<b> Application is running on port no : "+ port +"</b>";
		return "<h1>" + props.getAppName() + "</h1>" + "<h2>Hello...!</h2>" + "<h3>Count :: " + props.getCount()
				+ "</h3>" + "<b> Application is running on port no : " + props.getPort() + "</b>";
	}
	
	@GetMapping("sbprops")
	public String getSbProps() {
		return "<h1>"
				+ sbProps.getMessage() +"</h1><h2>"
						+ sbProps.getCode()+"</h2>";
	}

}
