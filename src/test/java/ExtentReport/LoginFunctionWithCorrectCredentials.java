package ExtentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LoginFunctionWithCorrectCredentials 
{
	@Test
	public void CorrectCredentials() throws InterruptedException
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./Reports/LoginDemoShop.html");
		//configure the spark reporter
		spark.config().setDocumentTitle("SampleReport");
		spark.config().setReportName("Poonam");
		spark.config().setTheme(Theme.DARK);
		//create the extent report
		ExtentReports report=new ExtentReports();
		//configure extent report
		report.setSystemInfo("os","windows 10");
		report.setSystemInfo("Browser","Chrome-100");
		//attach the spark reporter to the extent report
		report.attachReporter(spark);
		//creating a test case
		ExtentTest test=report.createTest("CorrectCredentials");
		test.log(Status.INFO,"Report is successfully created");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys("Vsharma2@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("Password")).sendKeys("Vsharma@2");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		WebElement compoll =driver.findElement(By.xpath("//strong[text()='Community poll']"));
		if(compoll.isDisplayed())
		{
			test.log(Status.INFO,"Commnity poll is displayed");
		}
		else
		{
			test.log(Status.INFO,"Commnity poll is not displayed");
		}
		report.flush();
		
	}

}
