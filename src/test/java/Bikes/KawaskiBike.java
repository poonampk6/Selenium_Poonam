package Bikes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class KawaskiBike 
{
	@Test(groups="Smoke")
	public void Kawaski() throws InterruptedException
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://kawasaki-india.com/");
	Thread.sleep(2000);
	driver.close();
	}
}
