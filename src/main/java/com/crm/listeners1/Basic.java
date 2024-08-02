package com.crm.listeners1;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import BaseClass.BaseClass1;


public class Basic extends BaseClass1 implements ITestListener 
{
	@Override
	public void onTestStart(ITestResult result)
	{
		String name=result.getMethod().getMethodName();
		Reporter.log(name,true);
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("onTestSuccess",true);
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		LocalDateTime Date=LocalDateTime.now();
		String time=Date.toString().replace(":", "-");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/Dws"+time+".png");
		try
		{
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Reporter.log("onTestFailure",true);
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("onTestSkipped",true);
	}
	@Override
	public void onStart(ITestContext context)
	{
		Reporter.log("onStart",true);
	}
	@Override
	public void onFinish(ITestContext context)
	{
		Reporter.log("onFinish",true);
	}
}
