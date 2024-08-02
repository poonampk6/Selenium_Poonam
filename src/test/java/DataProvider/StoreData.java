package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StoreData 
{
	@DataProvider(name="data")
	public Object[][] sender()
	{
		Object[][] obj=new Object[2][2];
		obj[0][0]="Poonam";
		obj[0][1]="Nidhi";
		obj[1][0]="Geeta";
		obj[1][1]="Mitali";
		return obj;
	}
	
	@Test(dataProvider="data")
	public void receiver(String data1, String data2)
	{
		System.out.println(data1);
		System.out.println(data2);
	}

}
