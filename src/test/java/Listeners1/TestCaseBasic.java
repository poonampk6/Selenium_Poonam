package Listeners1;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseClassDws;
@Listeners(com.crm.listeners1.Basic.class)
public class TestCaseBasic extends BaseClassDws 
{
	@Test
	public static void main1()
	{
		String expected_result="https://demowebshop.tricentis.com/";
		String actual_result=driver.getCurrentUrl();
		assertEquals(expected_result,actual_result);
	}
	@Test
	public static void main2()
	{
		String expected_result="https://demowebshop.tricentis.com";
		String actual_result=driver.getCurrentUrl();
		assertEquals(expected_result,actual_result);
	}
}
