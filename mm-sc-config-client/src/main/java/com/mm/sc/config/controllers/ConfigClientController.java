/**
 * 
 */
package com.mm.sc.config.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dorak
 *
 */
@RefreshScope
@RestController
public class ConfigClientController {
	
	@Value("${sb.sample.message}")
    private String greetingMessage;

    @GetMapping("/showMessage")
    public String showConfig() {
        String configInfo = "<h1>Message From Cloud Config :: " + greetingMessage +"</h1>";
               
        return configInfo;
    }
	
}
