package testNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleTestCases 
{
	@Test(priority=2, invocationCount = 5, threadPoolSize = 5)
	public void dws() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		driver.close();
	}
	@Test(priority=1,invocationCount = 4,threadPoolSize = 0)
	public void Csk() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.chennaisuperkings.com/");
		Thread.sleep(2000);
		driver.close();
	}
	@Test(priority=3,invocationCount = 0,threadPoolSize = 2)
	public void rcb() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.diageoindia.com/en/brands/brand-explorer/royal-challenge-whisky");
		Thread.sleep(2000);
		driver.close();
	}
}
