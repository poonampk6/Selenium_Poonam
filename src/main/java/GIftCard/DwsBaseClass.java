package GIftCard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DwsBaseClass 
{
	public static WebDriver driver;

	public static void preCondition(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	public static void Login()
	{
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys("vsharma2@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Vsharma@2");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	public static void postCondition()
	{
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		//driver.quit();
		
	}
	
}
