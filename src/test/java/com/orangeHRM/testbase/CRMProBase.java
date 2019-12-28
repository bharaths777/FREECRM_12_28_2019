package com.orangeHRM.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.orangeHRM.testutil.CRMProTestUtil;
import com.orangeHRM.testutil.CurrentDateAndTime;

public class CRMProBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public FileInputStream fis ;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public CRMProBase(){
		
		try {
			fis = new FileInputStream("G:\\Selenium_FrameWork\\OrangeHRM\\src\\test\\java\\com\\orangeHRM\\config\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		
	}
	
	public static void  intialize(){
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")){
			String absolutePath = System.getProperty("user.dir");
			String path = absolutePath +"/BrowserDrivers"+"\\chromedriver.exe";
	
			driver = new ChromeDriver();
			
		}
		else{
			System.out.println("browser is wrong .....");
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(CRMProTestUtil.PAGE_LOAD, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(CRMProTestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);	
	}
	@BeforeSuite
	public void setup(){
		
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FREECRM_"+CurrentDateAndTime.getDateAndTime()+ ".html"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}


}
