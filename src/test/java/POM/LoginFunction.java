package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


@Test
public class LoginFunction 
{
	public void main()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		DwsLogin ref=new DwsLogin(driver);
		ref.LoginLink();
		ref.Username("NKumar2@gmail.com");
		ref.Password("Nkumar@2");
		ref.LoginBtn();
	}
}
