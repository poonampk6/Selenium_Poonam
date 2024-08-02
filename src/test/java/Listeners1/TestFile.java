package Listeners1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.listeners1.BaseClass;
@Listeners(com.crm.listeners1.Basic.class)

public class TestFile extends BaseClass
{
	@Test
	public void main1()
	{
		String expectedResult="https://demowebshop.tricentis.com/";
		String actualResult=driver.getCurrentUrl();
		assertEquals(expectedResult,actualResult);
		Reporter.log("main1",true);
	}
	@Test
	public void main2()
	{
		String expectedResult="https://demowebshop.tricentis.com";
		String actualResult=driver.getCurrentUrl();
		assertEquals(expectedResult,actualResult);
		Reporter.log("main2",true);
	}
}
