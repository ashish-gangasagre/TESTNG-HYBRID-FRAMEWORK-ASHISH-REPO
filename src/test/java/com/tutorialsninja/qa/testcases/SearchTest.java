package com.tutorialsninja.qa.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.base;
import com.tutorialsninja.qa.pages.homepage;
import com.tutorialsninja.qa.pages.searchpage;

public class SearchTest extends base {
	public SearchTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver=initilizebrowserandopenapplication(prop.getProperty("browser"));
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifysearchwithvalidproduct() {
		
		homepage homp=new homepage(driver);
		homp.enterintosearchbox(dataprop.getProperty("validproduct"));
		homp.clickonsearchbtn();
		
        searchpage serp=new searchpage(driver);
        Assert.assertTrue(serp.diplaystatusofvalihpproduct(),"hp not displayed");
	}
	@Test(priority=2)
	public void searchwithinvlidproduct() {
		
		homepage homp=new homepage(driver);
		homp.enterintosearchbox(dataprop.getProperty("invalidproduct"));
		homp.clickonsearchbtn();
		
		searchpage serp=new searchpage(driver);
		String actualsearchtext=serp.retrievenoproductmessagetext();
		Assert.assertTrue(actualsearchtext.contains(dataprop.getProperty("noproductextinsearch")),"no message displayed for honda");
		
	}
	@Test(dependsOnMethods= {"searchwithinvlidproduct"})
	public void searchwithoutanyproduct() {
		homepage homp=new homepage(driver);
		homp.clickonsearchbtn();
		
		searchpage serp=new searchpage(driver);
		String actualsearchtext=serp.retrievenoproductmessagetext();
		Assert.assertTrue(actualsearchtext.contains(dataprop.getProperty("noproductextinsearch")),"no message displayed for honda");
		
	}

}
