package com.xebia.app.store.retail.discounts.app.utils;



import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * The class PropertyUtils.
 *
 */
public class PropertyUtils {
	
	/** The logger. */
	private static final Logger LOGGER = Logger.getLogger(PropertyUtils.class);
	
	/** The property. */
	private static Properties properties = loadproperty("application.properties");

	/**
	 * Load configuration
	 * 
	 * @param fileName
	 * 			filename of config properties
	 * @return return properties
	 * @Description Loads the properties from config properties file.
	 */
	public static Properties loadproperty(String fileName) {
		final Properties prop = new Properties();
		try {
			LOGGER.info("In PropertyUtils file. Reading configuration properties");
			final InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			prop.load(inStream);
			
		}
		catch(final IOException io) {
			LOGGER.error("properties file not found. "+io);
		}
		return prop;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(final String key) {
		return properties.getProperty(key);
	}
}
