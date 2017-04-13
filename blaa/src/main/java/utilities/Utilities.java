package utilities;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.project.Reporter.HomePageTest;

//import Framework.Selenium.TestCore;
//import helper.SelectBrowser;

public class Utilities 
{
    	
    	WebDriver driver;
    	
		public void commonCheckTitle(WebDriver driver)
		{
			System.out.println(driver.getTitle());
    		Assert.assertEquals("Log In | AppDirect", driver.getTitle(), "Strings are not matching");
    	}
		public void maximizewindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
}
    	

