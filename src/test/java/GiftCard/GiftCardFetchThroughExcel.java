package GiftCard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

import GIftCard.DwsBaseClass;

public class GiftCardFetchThroughExcel extends DwsBaseClass
{
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException 
	{
		static String Rname;
		static String Remail;
		static String Sname;
		static String Semail;
		static String message;
		static String qty;
		
		FileInputStream fis=new FileInputStream("C:\\Users\\POONAM\\Desktop\\GiftCard.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet("Sheet1");
		Rname=sheet.getRow(0).getCell(0).toString();
		Remail=sheet.getRow(0).getCell(1).toString();
		Sname=sheet.getRow(0).getCell(2).toString();
		Semail=sheet.getRow(0).getCell(3).toString();
		message=sheet.getRow(0).getCell(6).toString();
		qty=sheet.getRow(0).getCell(7).toString();

		System.out.println(Rname);
		System.out.println(Remail);
		System.out.println(Sname);
		System.out.println(Semail);
		System.out.println(message);
		System.out.println(qty);
		
		preCondition("Chrome");
		Login();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
		driver.findElement(By.xpath("//input[@name='giftcard_2.RecipientName']")).sendKeys(Rname);
		driver.findElement(By.xpath("//input[@name='giftcard_2.RecipientEmail']")).sendKeys(Remail);
		driver.findElement(By.xpath("//input[@name='giftcard_2.SenderName']")).clear();
		driver.findElement(By.xpath("//input[@name='giftcard_2.SenderName']")).sendKeys(Sname);
		driver.findElement(By.xpath("//input[@name='giftcard_2.SenderName']")).clear();
		driver.findElement(By.xpath("//input[@name='giftcard_2.SenderName']")).sendKeys(Semail);
		driver.findElement(By.xpath("//textarea[@name='giftcard_2.Message']")).sendKeys(message);
		driver.findElement(By.xpath("//input[@name='addtocart_2.EnteredQuantity']")).clear();
		driver.findElement(By.xpath("//input[@name='addtocart_2.EnteredQuantity']")).sendKeys(qty);
		driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
		postCondition();
	}
}
