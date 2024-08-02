package DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderForLoop 
{
	public class StoreData 
	{
		@DataProvider(name="data")
		public Object[][] sender() throws EncryptedDocumentException, IOException
		{
			Object[][] obj=new Object[2][2];
			FileInputStream fis=new FileInputStream("C:\\Users\\POONAM\\Desktop\\login.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sheet=wb.getSheet("login");
			int row=sheet.getPhysicalNumberOfRows();
			int column=sheet.getRow(0).getPhysicalNumberOfCells();
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<column;j++)
				{
					obj[i][j]=sheet.getRow(i).getCell(j).toString();
				}
			}
			return obj;
		}
		
		@Test(dataProvider="data")
		public void receiver(String data1, String data2)
		{
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get("https://demowebshop.tricentis.com/");
			driver.findElement(By.xpath("//a[@class='ico-login']")).click();
			driver.findElement(By.id("Email")).sendKeys(data1);
			driver.findElement(By.id("Password")).sendKeys(data2);
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			driver.close();
		}
		}

}
