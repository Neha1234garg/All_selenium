package com.project.Reporter;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.appdirect.Pages.LoginPage;
import com.appdirect.Pages.SignupPage;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;


public class SignUpTest {
	
	SignupPage signuppage;
	
	
	@Test 
	public void passingUserEmail() throws IOException, FileNotFound1, NoSuchElement1, IOException1
	{	
			this.signuppage= HomePageTest.signuppage;
			signuppage.verifySignupPage().sendUserEmail();
			Reporter.log("Email is passed to email field",true);
	}
	
	@Test  (dependsOnMethods = { "passingUserEmail" })
	public void validEmail() throws IOException, FileNotFound1, NoSuchElement1, IOException1
	{	
			
			signuppage.signupButtonClick();
			Reporter.log("Click action performed on main Signup Button",true);
	}
	

}
