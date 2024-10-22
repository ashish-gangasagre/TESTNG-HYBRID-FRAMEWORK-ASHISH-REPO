package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerpage {

	WebDriver driver;
	
	public registerpage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	} 
	@FindBy(id="input-firstname")
	private WebElement firstnamef;
	
	@FindBy(id="input-lastname")
	private WebElement lasttnamef;
	
	@FindBy(xpath="//*[@id='input-email']")
	private WebElement emailf;
	
	
	@FindBy(id="input-telephone")
	private WebElement telephonef;
	
	@FindBy(id="input-password")
	private WebElement passwordf;
	
	@FindBy(id="input-confirm")
	private WebElement passworconfrmf;
	
	@FindBy(xpath="//*[text()='Yes']")
	private WebElement yesnewsletteroption;
	
	@FindBy(name="agree")
	private WebElement privacycheckbox;
	
	@FindBy(xpath="//*[@value='Continue']")
	private WebElement continubtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateemailadresswornning;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacypolicywarningerror;
	
	@FindBy(xpath="//*[text()='First Name must be between 1 and 32 characters!']")
	private WebElement firstnameerrortext;
	
	@FindBy(xpath="//*[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement lastnameerrortext;
	
	@FindBy(xpath="//*[text()='E-Mail Address does not appear to be valid!']")
	private WebElement emailerroretext;
	
	@FindBy(xpath="//*[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement telephoneerroretext;
	
	@FindBy(xpath="//*[text()='Password must be between 4 and 20 characters!']")
	private WebElement passworderroretext;
	
	public void enterfirstname(String firstn) {
		firstnamef.sendKeys(firstn);
	}
    public void enterlastname(String lastn) {
    	lasttnamef.sendKeys(lastn);
    }
    public void enteremail(String emaill) {
    	emailf.sendKeys(emaill);
    }
    public void entertelephone(String telepho) {
    	telephonef.sendKeys(telepho);
    }
    public void enterpassword(String pass) {
    	passwordf.sendKeys(pass);
    }
    public void enterconfrmpass(String confrmpass) {
    	passworconfrmf.sendKeys(confrmpass);
    }
    public void clickonnesletter() {
    	yesnewsletteroption.click();
    }
   public void clickonprivacychechekbox() {
	   privacycheckbox.click();
   }
   public void clickoncontinuebtn() {
	   continubtn.click();
   }

   public String retrieveduplicateemailworningtext() {
	   String duplicateworningtext=duplicateemailadresswornning.getText();
	   return duplicateworningtext;
   }
   public String retriveprivacypolicyerror() {
	   String privacypolicytext=privacypolicywarningerror.getText();
	   return privacypolicytext;
   }
   public String retrivefirstnameerrortext() {
	   String firstnameerrortextt=firstnameerrortext.getText();
	   return firstnameerrortextt;
   }
   public String retrivelastnameerrortext() {
	   String lastnameerroretextt=lastnameerrortext.getText();
	return lastnameerroretextt;
	   
   }
   public String retriveemailerroretext() {
	   String emailerroretextt=emailerroretext.getText();
	   return emailerroretextt;
	   
   }
   public String retrivetelephoneerroretext() {
	   String telephoneerroretextt =telephoneerroretext.getText();
	   return telephoneerroretextt;
   }
   public String retrivepasworderroretext() {
	   String passworderroretextt=passworderroretext.getText();
	return passworderroretextt;
   }
   
   
}
