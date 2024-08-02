package com.crm.listeners1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
@Listeners(com.crm.listeners1.ReportWithMultipleTestCase.class)

public class ReportWithMultipleTestCase implements ITestListener
{
	ExtentReports report;
	ExtentSparkReporter spark;
	ExtentTest test;

	public void onTestStart(ITestResult result)
	{
		String t_name=result.getMethod().getMethodName();
		Reporter.log(t_name+" is executed");
		test=report.createTest(t_name);
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
	}
	
	public void onTestSkipped(ITestResult result)
	{
		String t_name=result.getMethod().getMethodName();
		test.log(Status.SKIP,t_name+"is skipped");
	}
	
	public void onStart(ITestContext context)
	{
		spark=new ExtentSparkReporter("./Reports/SampleReport.html");
		spark.config().setDocumentTitle("Sample Report");
		spark.config().setReportName("Poonam");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser","Chrome-100");
		report.attachReporter(spark);
	}
	
	public void onFinish(ITestContext context)
	{
		report.flush();
	}

}
