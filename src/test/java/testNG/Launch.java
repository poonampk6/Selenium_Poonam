package testNG;

import org.testng.annotations.Test;

public class Launch 
{
	public static void main(String[] args)
	{
		System.out.println("Im main");
	}
	
	@Test
	public void main()
	{
		System.out.println("Im testng");
	}
}
