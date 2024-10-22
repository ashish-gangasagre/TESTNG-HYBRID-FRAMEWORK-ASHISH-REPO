package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports GenerateExtentReport() {
		
		ExtentReports extentreport=new ExtentReports();
		
		File extentreportfile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReports.html");
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(extentreportfile);
		
    	sparkreporter.config().setTheme(Theme.DARK);
    	sparkreporter.config().setReportName("ASHISH Test automation Results Report");
    	sparkreporter.config().setDocumentTitle("Ashish gangasgre test report");
    	sparkreporter.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
    	
    	extentreport.attachReporter(sparkreporter);
    	
    	Properties configprop=new Properties();
    	File configpropfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.roperties");
    	
		try {
			FileInputStream fis = new FileInputStream(configpropfile);
			configprop.load(fis);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
    
    	extentreport.setSystemInfo("Application URL", configprop.getProperty("url"));
    	extentreport.setSystemInfo("browser name", configprop.getProperty("browser"));
    	extentreport.setSystemInfo("email", configprop.getProperty("validemail"));
    	extentreport.setSystemInfo("password", configprop.getProperty("validpassword"));
    	extentreport.setSystemInfo("oprating system", System.getProperty("os.name"));
    	extentreport.setSystemInfo("Username", System.getProperty("user.name"));
    	extentreport.setSystemInfo("java version", System.getProperty("java.version"));
    	
    	return extentreport;
    	
	}
}
