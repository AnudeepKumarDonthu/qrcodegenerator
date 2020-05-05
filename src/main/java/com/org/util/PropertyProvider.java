/**
 * 
 */
package com.org.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Anudeep Kumar
 *
 */
@Component
public class PropertyProvider {

	@Autowired
	private Environment environment;

	public String getProperty(String propertyKey) {
		return environment.getProperty(propertyKey);
	}

}
