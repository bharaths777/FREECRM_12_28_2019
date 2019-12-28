package com.orangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.testbase.CRMProBase;

public class CRMProHomePage extends CRMProBase{
	
	
	public CRMProHomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//td[contains(text(),'User: bharath kumar')]") WebElement user;
	
	

}
