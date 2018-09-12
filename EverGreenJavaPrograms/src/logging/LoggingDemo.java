package logging;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggingDemo {

	/*
	 * Log level hierarchy
		OFF
		FATAL
		ERROR
		WARN
		INFO
		DEBUG
		TRACE
		ALL
	*/
	
	public static final Logger logger = Logger.getLogger(LoggingDemo.class);
	
	public static void init(){
		
		//For Basic configuration - This will simply print the logs on console
		//BasicConfigurator.configure();
		
		// Configure method expects absolute path for log4j.properties
		//PropertyConfigurator.configure("D:\\Workspace\\Workspace\\learning\\EverGreenJavaPrograms\\src\\logging\\log4j.properties");
		
		// If we want to load properties file from classpath/jar. For example if file
		// is present in same folder then simply give name. If file is present in src
		// then give /filename as stream name
		/*Properties props = new Properties();
		try {
			props.load(LoggingDemo.class.getResourceAsStream("log4j.properties"));
			PropertyConfigurator.configure(props);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		// If we want to load from specific folder
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("src/logging/log4j.properties"));
			PropertyConfigurator.configure(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		init();
		logger.info("Hello");
	}

}
