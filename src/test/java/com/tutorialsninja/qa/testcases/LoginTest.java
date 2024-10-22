package com.tutorialsninja.qa.testcases;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseclass.base;
import com.tutorialsninja.qa.pages.accountpage;
import com.tutorialsninja.qa.pages.homepage;
import com.tutorialsninja.qa.pages.loginpage;
import com.tutorialsninja.qa.utils.utils;

public class LoginTest extends base {
	
	public WebDriver driver;
	
	
	public LoginTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		
		driver=initilizebrowserandopenapplication(prop.getProperty("browser"));
		
		homepage home=new homepage(driver);
		home.clickonmyaccount();
		home.selectloginoption();

	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	@Test(priority = 1,dataProvider="validcredentialssupplier")
	public void verifyloginwithvalidcredentials(String email,String password) {
		
		loginpage loginp=new loginpage(driver);
		
		loginp.enteremail(email);
		loginp.enterpassword(password);
		loginp.clickonloginbtn();
	
		accountpage acountpage=new accountpage(driver);
		Assert.assertTrue(acountpage.getdisplaystatusofedityouraccountinformation(),"EDIT YOUR INFORMATION OPTION IS NOT DISPLAYED");
		
	}
	@DataProvider(name="validcredentialssupplier")
	public Object[][] supplytestdata() {
		Object[][] data = utils.gettestdatafromexcel("Login");
	    return data;
	}
	
	@Test(priority = 2)
	public void verifyloginwithinvalidcredentials() {
		loginpage loginp=new loginpage(driver);
		
		loginp.enteremail(utils.generateemailwithtimestamp());
		loginp.enterpassword(dataprop.getProperty("invalidpassword"));
		loginp.clickonloginbtn();
		
		
		
		String actualwarningmessage=loginp.retrieveemailpasswordnotmatchingwarningmessagetext();
		String expectedwarningmessage=dataprop.getProperty("emailpasswordnomatchwarning");
		Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage),"Expected Warning is not reflecting");
		
		
		
	}
	@Test(priority=3)
	public void verifyloginwithinvalidemailandvalidpassword() {
		loginpage loginp=new loginpage(driver);
		
		loginp.enteremail(utils.generateemailwithtimestamp());
		loginp.enterpassword(dataprop.getProperty("validpassword"));
		loginp.clickonloginbtn();
		
       
		String actualwarningmessage=loginp.retrieveemailpasswordnotmatchingwarningmessagetext();
		String expectedwarningmessage=dataprop.getProperty("emailpasswordnomatchwarning");
		Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage),"Expected Warning is not reflecting");
		
		
		
	}
	@Test(priority=4)
	public void verifyloginwithvalidemailandinvalidpassword() {
		
		loginpage loginp=new loginpage(driver);
		
		loginp.enteremail(prop.getProperty("validemail"));
		loginp.enterpassword(dataprop.getProperty("invalidpassword"));
		loginp.clickonloginbtn();
	
		String actualwarningmessage=loginp.retrieveemailpasswordnotmatchingwarningmessagetext();
		String expectedwarningmessage=dataprop.getProperty("emailpasswordnomatchwarning");
		Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage),"Expected Warning is not reflecting");
		

	
	}
	@Test(priority=5)
	public void verifyloginwithoutcredentails() {
		
		loginpage loginp=new loginpage(driver);
		
		loginp.clickonloginbtn();
		
		String actualwarningmessage=loginp.retrieveemailpasswordnotmatchingwarningmessagetext();
		String expectedwarningmessage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage),"Expected Warning is not reflecting");
		
		
	
	}
	
	
	
	
}
