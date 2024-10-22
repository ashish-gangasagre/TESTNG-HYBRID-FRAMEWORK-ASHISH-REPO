package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReporter;
import com.tutorialsninja.qa.utils.utils;

public class Mylisteners implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extentTest;
	 
	
	@Override
	public void onStart(ITestContext context) {
		extentReport=ExtentReporter.GenerateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
	    
	    extentTest=extentReport.createTest(result.getName());
	    extentTest.log(Status.INFO, result.getName()+"start executing");
	    
	    
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, result.getName()+"got succefully executed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		String destinationscreenshotpath = utils.capturescreenshot(driver, result.getName());
	
		extentTest.addScreenCaptureFromPath(destinationscreenshotpath);
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,result.getName()+"test got fail");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+" test skipped ");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
		String pathofextentreport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReports.html";
		File extentreport =new File(pathofextentreport);
		try {
			Desktop.getDesktop().browse(extentreport.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
}
