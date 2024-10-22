package com.tutorialsninja.qa.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {

	
	WebDriver driver;

	public homepage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	@FindBy(xpath="(//span[text()='My Account'])[1]")
     private WebElement myaccountdropmenu;
	
	@FindBy(linkText="Login")
	private WebElement loginoption;
	
	@FindBy(partialLinkText ="Regist")
	private WebElement register;
	
	@FindBy(name="search")
	private WebElement searchbox;
	
    @FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchbtn;
	
	public void clickonmyaccount() {
		myaccountdropmenu.click();
	  	
	}
	public void selectloginoption() {
		loginoption.click();
	}
	
	public void selectregisteroption() {
		register.click();
	}
	
	public void enterintosearchbox(String str) {
		searchbox.sendKeys(str);
	}
	public void clickonsearchbtn() {
		searchbtn.click();
	}
	
	
	
}
