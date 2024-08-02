package BaseCLassForVTiger;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import BaseClass.PropertyUtility;

public class BaseClass 
{
public static WebDriver driver;
	
//	@Parameters({"browser","url"})
	@BeforeClass
	public void preCondition() throws IOException
	{
		String browser = PropertyUtility.getInputData("browser");
		String url = PropertyUtility.getInputData("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
//		driver.findElement(By.partialLinkText("Log in")).click();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(PropertyUtility.getInputData("username"));
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PropertyUtility.getInputData("password"));
		driver.findElement(By.id("submitButton")).click();
		//driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	}
	
	@AfterMethod
	public void logout()
	{
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
	}
	
	@AfterClass
	public void postCondition()
	{
		driver.quit();
	}
}
