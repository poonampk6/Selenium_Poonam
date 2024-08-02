package BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.crm.listeners1.Register;

public class BaseClass1
{
public static WebDriver driver;
	
	@BeforeClass
	public void preCondition() throws IOException
	{
		String browser=JavaUtility.logindata("browser");
		String url=JavaUtility.logindata("url");
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	
	@BeforeMethod
	public void loginAndRegister() throws IOException
	{
		
//		driver.findElement(By.id("gender-female")).click();
//		String firstname=JavaUtility.logindata("Vikram");
//		String lastname=JavaUtility.logindata("Kumar");
//		String email=JavaUtility.logindata("Vsharma2@gmail.com");
//		String password=JavaUtility.logindata("Vsharma@2");
//		String confirmpassword=JavaUtility.logindata("Vsharma@2");
		
		String username=JavaUtility.logindata("username");
		String password = JavaUtility.logindata("password");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys("vsharma2@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Vsharma@2");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();	
		
	}
	
	@AfterMethod
	public void logout()
	{
		driver.findElement(By.partialLinkText("Log out")).click();
	}
	
	@AfterClass
	public void postCondition()
	{
		//driver.quit();
	}
}
