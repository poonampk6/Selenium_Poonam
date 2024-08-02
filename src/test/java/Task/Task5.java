package Task;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseClass1;
import DWS.Cart;
import DWS.DIgitalDownload;
import DWS.HomePage;

@Listeners(com.crm.listeners1.Basic.class)
	public class Task5 extends BaseClass1
	{

		@Test
		public void highestPrice() throws InterruptedException
		{
			assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
			
			HomePage hPage = new HomePage(driver);
			hPage.digitalDownloads();
			
			DIgitalDownload dd = new DIgitalDownload(driver);
			List<WebElement> pro = dd.products();
			for (WebElement w : pro) {
				w.click();
			}
			
			dd.cart();
			
			Cart c = new Cart(driver);
			
			List<WebElement> price = c.prices();
			
			List<Double> priceList = new ArrayList<Double>();
			
			for(WebElement w:price)
			{
				priceList.add(Double.parseDouble(w.getText()));
			}
			
			int index = priceList.indexOf(Collections.max(priceList));
			driver.findElement(By.xpath("(//td[@class='remove-from-cart']/input)["+(++index)+"]")).click();
			
			Thread.sleep(2000);
			
			c.updateCart();
		}
	}

