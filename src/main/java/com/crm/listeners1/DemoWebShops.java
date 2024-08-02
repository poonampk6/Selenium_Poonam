package com.crm.listeners1;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.crm.listeners1.BasicListeners.class)

public class DemoWebShops extends ExtentReportBaseClass
{
	String rss="https://demowebshop.tricentis.com/news/rss/1";
	@Test()
	public void facebook() throws InterruptedException
	{
		launch();
		Actions act=new Actions(driver);
       	WebElement facebookpage = driver.findElement(By.linkText("Facebook"));
		act.scrollToElement(facebookpage);
		facebookpage.click();

		String facebookurl="https://www.facebook.com/nopCommerce";
		Set<String> mchild = driver.getWindowHandles();
		for (String s : mchild) {
		driver.switchTo().window(s);	
		String mUrl=driver.getCurrentUrl();		
		if (facebookurl.equals(mUrl))
		{
		WebElement create_account = driver.findElement(By.xpath("//span[text()='Create new account']"));	
		create_account.click();	    
	    Set<String> childSeceond = driver.getWindowHandles();			
	    for (String string : childSeceond) {
		driver.switchTo().window(string);
		}	    
	    Thread.sleep(2000);    
	    driver.findElement(By.name("firstname")).sendKeys("vishal");
	    driver.findElement(By.name("lastname")).sendKeys("sharma");
		driver.findElement(By.name("reg_email__")).sendKeys("Vsharma2@gmail.com");
	    driver.findElement(By.name("reg_passwd__")).sendKeys("Vsharma@2");
	    Thread.sleep(2000);
		WebElement bday_DropDown = driver.findElement(By.name("birthday_day"));
	    Select ref=new Select(bday_DropDown);
					ref.selectByVisibleText("14");
					WebElement birthMonth = driver.findElement(By.id("month"));
				     Select ref2=new Select(birthMonth);
				     ref2.selectByIndex(0);
				     WebElement birthYear = driver.findElement(By.id("year"));
				     Select ref3=new Select(birthYear);
				     ref3.selectByValue("2003");
				     Thread.sleep(2000);
				     driver.findElement(By.xpath("//label[text()='Male']")).click();
				}
			}
		postCondition();
	}
	@Test()
	public void twitter() throws InterruptedException
	{
   	launch();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
       	WebElement facebookpage = driver.findElement(By.linkText("Facebook"));
       	act.scrollToElement(facebookpage);
       	driver.findElement(By.linkText("Twitter")).click();
        Set<String> parent = driver.getWindowHandles();
        for (String x : parent) {
        	driver.switchTo().window(x);
        	Thread.sleep(2000);        	
        }
      //  driver.findElement(By.xpath("//span[text()='Log in']")).click();
		postCondition();
	}
	@Test()
	public void digitalDownload() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Digital downloads')]")).click();
		List<WebElement> addtocart = driver.findElements(By.xpath("//input[@value='Add to cart']"));
		for (WebElement add : addtocart) 
		{
			add.click();
			Thread.sleep(1000);
		}
		driver.findElement(By.className("cart-label")).click();
		List<WebElement> remove = driver.findElements(By.xpath("//input[@name='removefromcart']"));
		for (WebElement removecart : remove) 
		{
     		removecart.click();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("//input[@name='updatecart']")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		postCondition();
	}
	@Test()
	public void xlinks() throws InterruptedException
	{	
		launch();
		Actions act=new Actions(driver);
       	WebElement facebookpage = driver.findElement(By.linkText("Facebook"));
       	act.scrollToElement(facebookpage);
       	List<WebElement> alllinks = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
       	for (WebElement web : alllinks) {
			web.click();
			if(driver.getCurrentUrl().equals(rss))
			{
				driver.navigate().back();
			}
		}
       	postCondition();
	}
	@Test
	public void gifts()
	{
		System.out.println("Pending");
	}
}