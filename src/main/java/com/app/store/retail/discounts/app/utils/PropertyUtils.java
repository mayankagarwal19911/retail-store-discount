package com.app.store.retail.discounts.app.utils;



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * 
 * The class PropertyUtils.
 *
 */
public class PropertyUtils {
	
	/** The logger. */
	private final static Logger LOGGER  = java.util.logging.Logger.getLogger( Logger.GLOBAL_LOGGER_NAME);
	
	/** The property. */
	private static Properties properties = loadproperty("application.properties");

	private PropertyUtils(){ }

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
			LOGGER.severe ("properties file not found. "+io);
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
