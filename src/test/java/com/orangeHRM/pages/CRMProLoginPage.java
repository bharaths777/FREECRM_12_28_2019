package com.orangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.testbase.CRMProBase;

public class CRMProLoginPage extends CRMProBase{

	@FindBy(name="username") WebElement uname;
	@FindBy(name="password") WebElement pwd;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']") WebElement loginbtn;
	
	@FindBy(className="img-responsive") WebElement logo;
	
	
	
	public CRMProLoginPage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String validatingLoginPageTitle(){
		
		return driver.getTitle();
	}
	public boolean validatingLogoOfLoginPage(){
		
		boolean flag = logo.isDisplayed();
		return flag;
		
	}
	public CRMProHomePage validatingLogin(String username,String password){
		
		uname.sendKeys(username);
		pwd.sendKeys(password);
		loginbtn.click();
		return new CRMProHomePage();
	}
	
	
	

	
	
	
	
	
	
	
	
}
