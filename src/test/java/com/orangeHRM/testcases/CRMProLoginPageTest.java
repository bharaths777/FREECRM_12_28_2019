package com.orangeHRM.testcases;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.orangeHRM.pages.CRMProHomePage;
import com.orangeHRM.pages.CRMProLoginPage;
import com.orangeHRM.testbase.CRMProBase;
import com.orangeHRM.testutil.CustomListener;
import com.orangeHRM.testutil.Log;
import com.orangeHRM.testutil.TakeScreenShot;


@Listeners(CustomListener.class)
public class CRMProLoginPageTest extends CRMProBase{
	
public CRMProLoginPage loginpage;

	
	public CRMProLoginPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
	
		
		intialize();
	Log.info("Application launched.....");
		loginpage = new CRMProLoginPage();
		

	}
	@Test(priority=1)
	public void validateLogo(){
		Log.info("Login Page logo validation");
		test = extent.createTest("Login Page Logo Validation");
		boolean flag = loginpage.validatingLogoOfLoginPage();
		Assert.assertTrue(flag);
		test.info("Login Page Logo Validation Successfull....");
		Log.info("login page logo validation successfull...");
	}
	@Test(priority=2)
	public void validateTitle(){
		//test = extent.createTest("Login Page Title Validation");

		test.info("Login page title validation");
		String actualTitle =loginpage.validatingLoginPageTitle();
		String expectedTitle = "CRMPRO. - CRM software for customer relationship management, sales, and support.";

		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
		test.info("Login Page Title Verified Sccessfully....");
		
		
	}
	
	
	@Test(priority=3)
	public void validateLogin(){
		//test = extent.createTest("Login  Validation");

		 loginpage.validatingLogin(prop.getProperty("username"), prop.getProperty("password"));
		test.info("Login Sccessfull.....");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		
	/*	if(result.getStatus() == ITestResult.FAILURE) {
			TakeScreenShot.getScreenShot();
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
            
            
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }*/
		
		driver.quit();
		extent.flush();
	}

}
