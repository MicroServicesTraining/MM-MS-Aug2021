/**
 * 
 */
package com.mm.sbdemo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author USER
 *
 */
@Configuration
@ConfigurationProperties(prefix = "sbdemo")
public class PropsUtil {
	
	//@Value(value = "${sbdemo.appname:App name is missing}")
	private String appName;
	
	//@Value("${sbdemo.count}")
	private long count;
	
	//@Value("${server.port}")
	private long port;

	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * @return the count
	 */
	public long getCount() {
		return count;
	}

	/**
	 * @return the port
	 */
	public long getPort() {
		return port;
	}

	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(long count) {
		this.count = count;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(long port) {
		this.port = port;
	}
	
}
