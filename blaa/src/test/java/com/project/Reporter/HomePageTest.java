package com.project.Reporter;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.appdirect.Pages.*;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;
import utilities.Utilities;
import utilities.Wait;



public class HomePageTest 
{
	public WebDriver driver;
	LoginPage loginpage;
	public static SignupPage signuppage;
	SelectBrowser browserobj= new SelectBrowser();

	Wait waitobj = new Wait();
	
	Utilities utils = new Utilities();
	
	String url_str;
	
	HomePage homepage;
	
	@BeforeTest
	public void selectBrowser() throws FileNotFound1, NoSuchElement1, IOException1, IOException
	{
		driver = browserobj.browser1();
		url_str = browserobj.returnurl();
		
		utils.maximizewindow(driver);
		Reporter.log("Maximise browser's window",true);
		
		waitobj.waitClass(driver);
		Reporter.log("Wait applied on the driver for 20 seconds");
		
		Reporter.log("Url is passed",true);
		driver.get(url_str);
		Reporter.log("Web application launched",true);
		
	}
	
	@Test 
	public void homePageTesting() throws IOException, FileNotFound1, NoSuchElement1, IOException1
	{	
		
		homepage=new HomePage(driver);
	loginpage =	homepage.verifyHomePagetitle().loginButtonClick();
		
	}
	
	@Test 
	public void loginPageTesting() throws IOException, FileNotFound1, NoSuchElement1, IOException1
	{	
		
		loginpage = new LoginPage(driver);
		signuppage =	loginpage.verifyLoginPagetitle().signupButtonClick();
	}

	
	
}
