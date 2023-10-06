package com.onkar.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGeneration {
	 
	public static ExtentReports extentReportGenerator() {
		// TODO Auto-generated method stub
		
		ExtentReports extentReport = new ExtentReports();
		File extentreport =  new File(System.getProperty("user.dir")+"\\test-output\\ExtentsReports\\extentReport.html");
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(extentreport);
		
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setReportName("onkarTestAutomationResultsReport");
		extentSparkReporter.config().setDocumentTitle("onkarAutomationReport");
		extentSparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(extentSparkReporter);
		
		extentReport.setSystemInfo("Application URL", "..www.aaplicationurl.com");
		extentReport.setSystemInfo("Browsername", "..Chrome");
		
		return extentReport;
		
	}
}
