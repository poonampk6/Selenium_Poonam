package POM;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.listeners1.Register;


public class Registration 
{
	@Test
	public void main()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		Register r =new Register(driver);
		r.Registration_link();
		r.femaleRadioButton();
		r.FirstName("Poonm");
		r.LastName("Kumar");
		r.Email("poonam.kumar.pk6@gmail.com");
		r.Password("Poonam@12");
		r.ConfirmPassword("Poonam@12");
		r.register_button();
	}
}
