package Bikes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BMWBike 
{
	@Test(groups="Smoke")
	public void Kawaski() throws InterruptedException
{
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("https://www.bmw-motorrad.in/en/models/sport/digital-nsc-sports.html?tl=sea-goog-RRCA-pro-ccy-G31R-text-.-.-.-91f94d83fc9b&gad_source=1&gclid=CjwKCAjwnK60BhA9EiwAmpHZw27iVLxtXUCJiLg0fMWINyR1Ds57gsIiQIoGUro9nNvDdvZPMtWyaBoCiggQAvD_BwE");
Thread.sleep(2000);
driver.close();
}

}
