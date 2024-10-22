package com.tutorialsninja.qa.testcases;




import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.base;
import com.tutorialsninja.qa.pages.accountpage;
import com.tutorialsninja.qa.pages.homepage;
import com.tutorialsninja.qa.pages.registerpage;
import com.tutorialsninja.qa.utils.utils;

public class RegisterTest extends base {
	 public WebDriver driver;
	
	
	
	public RegisterTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setup() {
		
		
		driver=initilizebrowserandopenapplication(prop.getProperty("browser"));
		
		homepage homep = new homepage(driver);
		
		homep.clickonmyaccount();
		homep.selectregisteroption();
	}
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

	
	@Test(priority=1)
	public void verifyingregisteringaccountwithmadatoryfields() {
		registerpage reg = new registerpage(driver);
		
		reg.enterfirstname(dataprop.getProperty("firstname"));
		reg.enterlastname(dataprop.getProperty("lastname"));
		reg.enteremail(utils.generateemailwithtimestamp());
		reg.entertelephone(dataprop.getProperty("telephone"));
		reg.enterpassword(prop.getProperty("validpassword"));
		reg.enterconfrmpass(prop.getProperty("validpassword"));
		reg.clickonprivacychechekbox();
		reg.clickoncontinuebtn();
		
		accountpage accp=new accountpage(driver);
		String actualsuccessheading=accp.retriveaccountsuccesspageheading();
		Assert.assertEquals(actualsuccessheading, dataprop.getProperty("accountsuccessfullycreatedheading"),"account success is not created");
		
		
		
	}
	@Test(priority=3)
	public void verifyingregisteringaccountwithexistingemail() {
           registerpage reg = new registerpage(driver);
		
		reg.enterfirstname(dataprop.getProperty("firstname"));
		reg.enterlastname(dataprop.getProperty("lastname"));
		reg.enteremail(prop.getProperty("validemail"));
		reg.entertelephone(dataprop.getProperty("telephone"));
		reg.enterpassword(prop.getProperty("validpassword"));
		reg.enterconfrmpass(prop.getProperty("validpassword"));
		reg.clickonprivacychechekbox();
		reg.clickoncontinuebtn();
		
		
		String actualprivacypolicy=reg.retrieveduplicateemailworningtext();
		Assert.assertEquals(actualprivacypolicy,dataprop.getProperty("duplicateemailwarnning"), "wornning message not displyed");
		
		
		
	}
	@Test(priority=2)
	public void verifyingregisteringaccountwithallfields() {
        registerpage reg = new registerpage(driver);
		
		reg.enterfirstname(dataprop.getProperty("firstname"));
		reg.enterlastname(dataprop.getProperty("lastname"));
		reg.enteremail(utils.generateemailwithtimestamp());
		reg.entertelephone(dataprop.getProperty("telephone"));
		reg.enterpassword(prop.getProperty("validpassword"));
		reg.enterconfrmpass(prop.getProperty("validpassword"));
		reg.clickonnesletter();
		reg.clickonprivacychechekbox();
		reg.clickoncontinuebtn();
		

		
		accountpage accp=new accountpage(driver);
		String actualsuccessheading=accp.retriveaccountsuccesspageheading();
		Assert.assertEquals(actualsuccessheading, dataprop.getProperty("accountsuccessfullycreatedheading"),"account success is not created");
		
		
		
	}
	@Test(priority=4)
	public void verifyingregisteringaccountwithoutprovidingdetailsfields() {
		
		
   
		registerpage reg = new registerpage(driver);
		reg.clickoncontinuebtn();
		
		String actualprivacypolicy=reg.retriveprivacypolicyerror();
		Assert.assertEquals(actualprivacypolicy,dataprop.getProperty("privacypolicywarnning"), "wornning message not displyed");
		
		String firstnamewarning=reg.retrivefirstnameerrortext();
		Assert.assertTrue(firstnamewarning.contains(dataprop.getProperty("firsnamewarnningg")),"first name warn not displayed");
		
		String lastnamewarnning=reg.retrivelastnameerrortext();
		Assert.assertTrue(lastnamewarnning.contains(dataprop.getProperty("lastnamewarnning")),"last name warn not displayed");
		
		String emailwarningg=reg.retriveemailerroretext();
		Assert.assertEquals(emailwarningg,dataprop.getProperty("emailwarnningg"),"email warning not displayed");
		
		String telephonewarning=reg.retrivetelephoneerroretext();
		Assert.assertTrue(telephonewarning.contains(dataprop.getProperty("telephonewarnningg")),"telephone warning not displayed");
		
		String passwordwarning=reg.retrivepasworderroretext();
		Assert.assertEquals(passwordwarning,dataprop.getProperty("passwordwarnningg"),"password warning not displayed");
		
		
		
	}
	
	
}
