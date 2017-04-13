package checker;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.appdirect.Pages.LoginPage;
import com.appdirect.Pages.ReadDBfile;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;
import utilities.Utilities;

public class LoginPageCheck {
	
	WebDriverWait wait;
	
	WebDriver driver;
	
	Properties prop = new Properties();
	
	ReadDBfile readfromfile= new ReadDBfile();
	Utilities utils= new Utilities();
	
	public LoginPageCheck(WebDriver driver)
	{
		this.driver=driver;
	}
	
public LoginPageCheck checkEnableOfLogin() throws FileNotFound1, NoSuchElement1, IOException1, IOException
{
		
		prop= readfromfile.getProp();
		
		String signupclick = prop.getProperty("signuplink_xpath");
		driver.findElement(By.xpath(signupclick)).isEnabled();
		Reporter.log("Signup Element is Visible",true);
		return new LoginPageCheck(driver);	
}

public LoginPage checkVisibilityOfLogin() throws FileNotFound1, NoSuchElement1, IOException1, IOException
{
		
		prop= readfromfile.getProp();
		
		String signupclick = prop.getProperty("signuplink_xpath");
		driver.findElement(By.xpath(signupclick)).isDisplayed();
		Reporter.log("Signup Element is displayed",true);
		return new LoginPage(driver);	
}


public LoginPageCheck checkTitle() throws FileNotFound1, NoSuchElement1, IOException1, IOException	
{
		utils.commonCheckTitle(driver);
		return new LoginPageCheck(driver);
	
}

}

