package BaseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClassDWSPage 
{
	public WebDriver driver;
	@BeforeClass
	public void preCondition()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
	}
	@BeforeMethod
	public void login() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys("vsharma2@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Vsharma@2");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();		
	}
	@AfterMethod
	public void logout()
	{
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
	}
	@AfterClass
	public void postCondition()
	{
		//driver.quit();
	}

}
