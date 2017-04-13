package com.appdirect.Pages;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import checker.SignupPageCheck;
import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;
import utilities.Utilities;

public class SignupPage {
	
	WebDriver driver;
	
	Properties prop = new Properties();
	
	ReadDBfile readfromfile= new ReadDBfile();
	
	Utilities utils= new Utilities();
	
	SignupPageCheck signupchecker = new SignupPageCheck(driver);
	
	
	String user_url=(RandomStringUtils.randomAlphabetic(6)+RandomStringUtils.randomAlphanumeric(3, 6)+"@yopmail.com");
	
	public SignupPage(WebDriver driver)
		{
			this.driver=driver;
		}

	public SignupPage verifySignupPage() throws FileNotFound1, NoSuchElement1, IOException1, IOException
	{
		
		signupchecker = new SignupPageCheck(driver);
	    	signupchecker.checkTitle().checkEnableOfEmail().checkEnableOfSignupBtn().checkVisibilityOfSignupBtn();
		return new SignupPage(driver);	
	}
	
public SignupPage sendUserEmail() throws FileNotFound1, NoSuchElement1, IOException1, IOException{
		
		prop = readfromfile.getProp();
		String signupurl = prop.getProperty("signupurl_xpath");
		
		driver.findElement(By.xpath(signupurl)).sendKeys(user_url);
		Reporter.log("values passed in user url link",true);
		return new SignupPage(driver);
}

	public SignupPage signupButtonClick() throws FileNotFound1, NoSuchElement1, IOException1, IOException{
		
		prop = readfromfile.getProp();
		String signupclick = prop.getProperty("signupclk_xpath");
		
		driver.findElement(By.xpath(signupclick)).click();
		Reporter.log("Login button clicked",true);
		return new SignupPage(driver);
		
	
	}
	
}
