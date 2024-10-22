package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountpage {
	
	WebDriver driver;
	
	public accountpage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Edit your account information")
	private WebElement edityouraccountinformation;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountsuccesspageheading;
	
	
	
	public boolean getdisplaystatusofedityouraccountinformation() {
		boolean displaystatus= edityouraccountinformation.isDisplayed();
		return displaystatus;
	}
	
	public String retriveaccountsuccesspageheading() {
		String accountsuccesspageheaddingtext=accountsuccesspageheading.getText();
		return accountsuccesspageheaddingtext;
	}
}
