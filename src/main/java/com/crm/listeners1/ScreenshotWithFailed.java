package com.crm.listeners1;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.DwsScreenshot;

public class ScreenshotWithFailed extends DwsScreenshot implements ITestListener
{
	ExtentReports report;
	ExtentSparkReporter spark;
	ExtentTest test;
	
	public void onTestStart(ITestResult result)
	{
		String t_name=result.getMethod().getMethodName();
		Reporter.log(t_name+"is executed");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		String t_name=result.getMethod().getMethodName();
		test.log(Status.PASS,t_name+"is success");
	}
	
	public void onTestFailure(ITestResult result)
	{
		String t_name=result.getMethod().getMethodName();
		test.log(Status.FAIL,t_name+"is failure");
		TakesScreenshot ts=(TakesScreenshot) driver;
		String screenshot=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(screenshot);
	}
	public void onTestSkipped(ITestResult result)
	{
		String t_name=result.getMethod().getMethodName();
		test.log(Status.SKIP,t_name+"is skipped");
	}
	
	public void onStart(ITestContext context)
	{
		//create spark reporter
		spark=new ExtentSparkReporter("./Reports/failedTestCase.html");	
		spark.config().setDocumentTitle("SampleReport");
		spark.config().setReportName("Poonam");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.setSystemInfo("os", "Windows-10");
		report.setSystemInfo("Browser","Chrome-10");
		report.attachReporter(spark);
	}
	
	public void onFinish(ITestContext context)
	{
		report.flush();
	}
}
