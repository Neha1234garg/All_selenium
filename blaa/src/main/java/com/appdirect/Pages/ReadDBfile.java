package com.appdirect.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import exceptionhandling.FileNotFound1;
import exceptionhandling.IOException1;
import exceptionhandling.NoSuchElement1;

public class ReadDBfile {
	
	
	 Properties prop = new Properties();
	 FileInputStream input = null;
	 public Properties getProp() throws FileNotFound1, NoSuchElement1, IOException1, IOException{
		 try {
			input = new FileInputStream(new File("db.properties"));
			prop.load(input);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return prop;
			
			
	 }
	
	
}
	
	


