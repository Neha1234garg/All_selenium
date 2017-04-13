package com.appdirect.Pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import checker.HomePageCheck;
import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;

public class HomePage {
	
	WebDriver driver;
	
	HomePageCheck homechecker;
	
	
	
	Properties prop = new Properties();
	
	ReadDBfile readfromfile= new ReadDBfile();
	
	public HomePage(WebDriver driver){
		
		 this.driver = driver;
		
	}
	
	public HomePage verifyHomePagetitle() throws FileNotFound1, NoSuchElement1, IOException1, IOException
	{
		 homechecker = new HomePageCheck(driver);
				        homechecker.checkTitle().checkEnableOfLogin();
		return new HomePage(driver);	
	}
	

	public LoginPage loginButtonClick() throws FileNotFound1, NoSuchElement1, IOException1, IOException{
		
		prop = readfromfile.getProp();
		String loginclick = prop.getProperty("loginlink_link_Text");
		
		driver.findElement(By.linkText(loginclick)).click();
		Reporter.log("Login button clicked",true);
		return new LoginPage(driver);
		
	}

}
