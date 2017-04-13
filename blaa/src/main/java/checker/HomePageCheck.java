package checker;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.appdirect.Pages.HomePage;
import com.appdirect.Pages.ReadDBfile;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;
import utilities.Utilities;

public class HomePageCheck {
	
	WebDriverWait wait;
	WebDriver driver;
	Properties prop = new Properties();
	ReadDBfile readfromfile= new ReadDBfile();
	Utilities utils= new Utilities();
	
	public HomePageCheck(WebDriver driver){
		this.driver=driver;
	}
	
	
	public HomePage checkEnableOfLogin() throws FileNotFound1, NoSuchElement1, IOException1, IOException{
		
		prop= readfromfile.getProp();
		
		String loginclick = prop.getProperty("loginlink_link_Text");
		
		driver.findElement(By.linkText(loginclick)).isEnabled();
				Reporter.log("Login Element is Enable",true);
				return new HomePage(driver);	
		
	}	
		
	public HomePageCheck checkTitle() throws FileNotFound1, NoSuchElement1, IOException1, IOException	
	{
		
		Assert.assertEquals("AppDirect", driver.getTitle(), "Strings are not matching");
			return new HomePageCheck(driver);
		
	}
	
public HomePage waitVisibilityConditionByXpath() throws FileNotFound1, NoSuchElement1, IOException1, IOException 
{
	prop= readfromfile.getProp();
	String loginclick = prop.getProperty("loginlink_link_Text");

    wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginclick)));
   Reporter.log("waiting for the login click",true);
   return new HomePage(driver);
}
}

