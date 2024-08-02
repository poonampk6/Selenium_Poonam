package Bikes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SuzukiAccess 
{
	@Test(groups="Smoke")
	public void Suzuki() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.suzukimotorcycle.co.in/product-details/all-new-access-125-bluetooth-enabled");
		Thread.sleep(2000);
		driver.close();
	}

}
