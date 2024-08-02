package GiftCard;

import org.openqa.selenium.By;

import GIftCard.DwsBaseClass;

public class DemoShopGitCard extends DwsBaseClass
{
	public static void main(String[] args) throws InterruptedException 
	{
		preCondition("Chrome");
		Login();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
		driver.findElement(By.xpath("//input[@name='giftcard_2.RecipientName']")).sendKeys("Poonam");
		driver.findElement(By.xpath("//input[@name='giftcard_2.RecipientEmail']")).sendKeys("Kumar@gmail.com");
		driver.findElement(By.xpath("//input[@name='giftcard_2.SenderName']")).clear();
		driver.findElement(By.xpath("//input[@name='giftcard_2.SenderName']")).sendKeys("Poonam");
		driver.findElement(By.xpath("//input[@name='giftcard_2.SenderName']")).clear();
		driver.findElement(By.xpath("//input[@name='giftcard_2.SenderName']")).sendKeys("Kumar@gmail.com");
		driver.findElement(By.xpath("//textarea[@name='giftcard_2.Message']")).sendKeys("Thank You");
		driver.findElement(By.xpath("//input[@name='addtocart_2.EnteredQuantity']")).clear();
		driver.findElement(By.xpath("//input[@name='addtocart_2.EnteredQuantity']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
		
		postCondition();
	}
}
