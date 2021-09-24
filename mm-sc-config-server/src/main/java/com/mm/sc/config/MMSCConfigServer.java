/**
 * 
 */
package com.mm.sc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author dorak
 *
 */
@EnableConfigServer
@SpringBootApplication
public class MMSCConfigServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MMSCConfigServer.class, args);
	}

}
