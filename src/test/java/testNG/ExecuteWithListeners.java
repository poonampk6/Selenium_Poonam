package testNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.crm.listeners1.ReportWithMultipleTestCase.class)
public class ExecuteWithListeners
{
	@Test
	public void Dominos()
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://pizzaonline.dominos.co.in/");
	Reporter.log("My stomach is hungry",true);
	}
	
	@Test(timeOut=1000)
	public void rcb()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.royalchallengers.com/");
		Reporter.log("Rcb hungry for cup",true);
	}
	@Test(dependsOnMethods = "rcb")
	public void csk()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.chennaisuperkings.com/ ");
		Reporter.log("when thala will retire",true);
	}
}
