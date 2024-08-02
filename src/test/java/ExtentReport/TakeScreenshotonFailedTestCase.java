package ExtentReport;

import org.openqa.selenium.By;

import BaseClass.DwsScreenshot;

public class TakeScreenshotonFailedTestCase extends DwsScreenshot
{
	public void loginFunction()
	{
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys("Vsharma2@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Vsharma@2");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.findElement(By.xpath("//a[text()='Log out']"));
	}
}
