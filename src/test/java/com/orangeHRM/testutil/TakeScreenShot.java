package com.orangeHRM.testutil;

import java.io.File;




import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import org.openqa.selenium.io.FileHandler;

import com.orangeHRM.testbase.CRMProBase;

public class TakeScreenShot extends CRMProBase{

	
	public static void getScreenShot(){
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"/ScreenShots/FREECRM_"+CurrentDateAndTime.getDateAndTime()+".png";
		File destination = new File (path);
		try {
			FileHandler.copy(src, destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	

	
}
