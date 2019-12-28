package com.orangeHRM.testutil;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;




public class Log {
	
	public static Logger log = Logger.getLogger(Log.class);
	
	public static void info(String message)
	{
	
		PropertyConfigurator.configure("G:\\Selenium_FrameWork\\OrangeHRM\\src\\test\\java\\com\\orangeHRM\\config\\Log4j.properties");
		log.info(message);
	}
}
