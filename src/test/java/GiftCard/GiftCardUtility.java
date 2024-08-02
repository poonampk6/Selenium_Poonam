package GiftCard;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GiftCardUtility 
{
	public static String loginData(String key) throws IOException
	{
		Properties pro=new Properties();
		FileInputStream fis=new FileInputStream(".\\Configure\\CommonData.properties");
		pro.load(fis);
		String data= pro.getProperty(key);
		return data;
	}


}
