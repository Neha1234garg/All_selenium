package checker;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.appdirect.Pages.ReadDBfile;
import com.appdirect.Pages.SignupPage;
import com.google.common.base.Verify;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;

public class SignupPageCheck 
{
	WebDriverWait wait;
	
	Properties prop = new Properties();
	
	ReadDBfile readfromfile= new ReadDBfile();
	
	WebDriver driver;
	
	public SignupPageCheck(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public SignupPageCheck checkEnableOfEmail() throws FileNotFound1, NoSuchElement1, IOException1, IOException
	{
			
			prop= readfromfile.getProp();
			
			String signupclick = prop.getProperty("signupurl_xpath");
			driver.findElement(By.xpath(signupclick)).isEnabled();
			Reporter.log("Signup Element is Visible",true);
			return new SignupPageCheck(driver);	
	}

	public SignupPageCheck checkEnableOfSignupBtn() throws FileNotFound1, NoSuchElement1, IOException1, IOException
	{
			
			prop= readfromfile.getProp();
			
			String signupclick = prop.getProperty("signupclk_xpath");
			driver.findElement(By.xpath(signupclick)).isEnabled();
			Reporter.log("Signup Element is Visible",true);
			return new SignupPageCheck(driver);	
	}
	
	public SignupPage checkVisibilityOfSignupBtn() throws FileNotFound1, NoSuchElement1, IOException1, IOException
	{
			
			prop= readfromfile.getProp();
			
			String signupclick = prop.getProperty("signupclk_xpath");
			driver.findElement(By.xpath(signupclick)).isDisplayed();
			Reporter.log("Signup Element is displayed",true);
			return new SignupPage(driver);	
	}


	public SignupPageCheck checkTitle() throws FileNotFound1, NoSuchElement1, IOException1, IOException	
	{
			Assert.assertEquals("Sign Up for AppDirect", driver.getTitle(), "Strings are not matching");
			return new SignupPageCheck(driver);
		
	}

}

