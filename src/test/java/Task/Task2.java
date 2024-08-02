package Task;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseClass1;
import DWS.DwsLogin;

@Listeners(com.crm.listeners1.Basic.class)
	public class Task2 extends BaseClass1{

		@DataProvider(name = "Credential")
		public Object[][] sender() throws EncryptedDocumentException, IOException
		{
			FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\OneDrive\\Desktop\\AdvanceSelenium\\DWSLogin.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh =wb.getSheet("DWS_L");
			int row = sh.getPhysicalNumberOfRows();
			int col = sh.getRow(0).getPhysicalNumberOfCells();
			
			Object[][] obj = new Object[row][col];
			
			for(int i=0; i<row; i++)
			{
				for(int j=0; j<col; j++)
				{
					obj[i][j] = sh.getRow(i).getCell(j).toString();
				}
			}
			
			return obj;
		}
		
		@Test(dataProvider = "Credential")
		public void login(String email,String password)
		{
			assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
			DwsLogin login = new DwsLogin(driver);
			login.login_link();
			login.username(email);
			login.password(password);
			login.loginBtn();
		}
}
