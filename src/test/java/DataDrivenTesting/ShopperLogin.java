package DataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShopperLogin 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		String email=ShopperJavaUtility.loginData("email");
		String password=ShopperJavaUtility.loginData("password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.shoppersstack.com/");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		
		Thread.sleep(2000);
		driver.quit();	
	}
}
