package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationProperties {

	public static Properties configfile;


	static {

		try { 
			String path = "src/test/resources/propertiesFolder/config.properties";
			FileInputStream input = new FileInputStream(path);

			configfile = new Properties();
			configfile.load(input); // load everything in path (connection)

			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// call value from class:config.properties by passing key to get value
	public static String getProperty(String keyName) {

		return configfile.getProperty(keyName);
	}

}
