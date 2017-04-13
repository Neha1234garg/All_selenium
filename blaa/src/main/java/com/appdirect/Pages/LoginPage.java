package com.appdirect.Pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import checker.LoginPageCheck;
import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;
import utilities.Utilities;

public class LoginPage {
	
	WebDriver driver;
	
	LoginPageCheck loginchecker = new LoginPageCheck(driver);
	
	Utilities utils = new Utilities();
	
	Properties prop = new Properties();
	
	ReadDBfile readfromfile= new ReadDBfile();
	
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver)
	{	
		this.driver=driver;
	}
	
	public LoginPage verifyLoginPagetitle() throws FileNotFound1, NoSuchElement1, IOException1, IOException
	{
		
		prop= readfromfile.getProp();
		String signupclick = prop.getProperty("signuplink_xpath");
	    wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signupclick)));
	    Reporter.log("waiting for the signup click",true);
		
		
		loginchecker = new LoginPageCheck(driver);
				loginchecker.checkTitle().checkEnableOfLogin().checkVisibilityOfLogin();
		return new LoginPage(driver);	
	}
	

	public SignupPage signupButtonClick() throws FileNotFound1, NoSuchElement1, IOException1, IOException{
		
		prop = readfromfile.getProp();
		String signupclick = prop.getProperty("signuplink_xpath");
		
		driver.findElement(By.xpath(signupclick)).click();
		Reporter.log("Login button clicked",true);
		return new SignupPage(driver);
		
	}	
	}
