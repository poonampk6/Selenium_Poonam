package Numbers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class EvenOdd 
{
	public class CheckEvenOddForExcelData {
		public void main(String[] args) throws EncryptedDocumentException, IOException {
			
			int row = 0;
			for( ; ; )
			{
				try {
					String fetched= EvenOddJavaUtility.getData("EvenOdd", row, 0);
					
					if(fetched!=" ")
					{
						checkEvenOdd((int)Double.parseDouble(fetched));
						row++;
					}else {
						break;
					}
				}catch(NullPointerException n)
				{
					break;
				}
			}
		}
		
		public void checkEvenOdd(int num)
		{
			if(num%2==0)
			{
				System.out.println("Even : "+num);
				System.out.println();
			}else {
				System.out.println("Odd : "+num);
				System.out.println();
			}
		}
	}
}
