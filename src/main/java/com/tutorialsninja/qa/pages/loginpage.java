package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver driver;
	
	public loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement emailadressfield;

	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(xpath="//*[@value='Login']")
	private WebElement loginbtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailpasswordnotmatchingwarning;


public void enteremail(String emailtext) {
	emailadressfield.sendKeys(emailtext);
}
public void enterpassword(String string) {
	passwordfield.sendKeys(string);
}
public void clickonloginbtn() {
	loginbtn.click();
}
public String retrieveemailpasswordnotmatchingwarningmessagetext() {
	String warningtext=emailpasswordnotmatchingwarning.getText();
	return warningtext;
}


}
