package com.baseclass;


import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.pages.homepage;
import com.tutorialsninja.qa.utils.utils;

public class base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	public homepage home;
	public base() {
		
		prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.roperties");
		
		dataprop=new Properties();
		File datapropfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\testdata.properties");
		
		try {
		FileInputStream datafis= new FileInputStream(datapropfile);
		dataprop.load(datafis);
           } 
		catch (Throwable e) {
			
			e.printStackTrace();
			
		}
		try {
			FileInputStream fis = new FileInputStream(propfile);
			prop.load(fis);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public WebDriver initilizebrowserandopenapplication(String browsername)  {
		
		

		if(browsername.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("edge")) {
			driver=new EdgeDriver();
		}
	    
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utils.PAGE_LOAD_TIME));
		//driver.get(prop.getProperty("url"));
		
		
		return driver;
	}

}
