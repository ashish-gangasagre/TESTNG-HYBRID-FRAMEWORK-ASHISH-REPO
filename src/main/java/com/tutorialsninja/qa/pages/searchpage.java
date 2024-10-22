package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchpage {
	WebDriver driver;

	@FindBy(linkText="HP LP3065")
	private WebElement validhpproduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement noproductmessage;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement meesagefornoproductfound; 
	
	public searchpage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	public boolean diplaystatusofvalihpproduct() {
		 boolean displaystatus = validhpproduct.isDisplayed();
		 return displaystatus;
	}
	public String retrievenoproductmessagetext() {
		String noproductmessagetext=noproductmessage.getText();
		return noproductmessagetext;
	}
	public String retrivenoproductfoundmeessagetext() {
		String noproductfoundtext=meesagefornoproductfound.getText();
		return noproductfoundtext;
	}
}
