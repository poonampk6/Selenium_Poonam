package ExtentReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport 
{
	@Test
	public void BasicReport()
	{
		//create spark reporter
		ExtentSparkReporter spark=new ExtentSparkReporter("./Reports/SampleReprt.html");
		//configure the spark reporter
		spark.config().setDocumentTitle("SampleReport");
		spark.config().setReportName("Poonam");
		spark.config().setTheme(Theme.DARK);
		//create the extent report
		ExtentReports report=new ExtentReports();
		//configure extent report
		report.setSystemInfo("os","windows 10");
		report.setSystemInfo("Browser","Chrome-100");
		//attach the spark reporter to the extent report
		report.attachReporter(spark);
		//creating a test case
		ExtentTest test=report.createTest("BasicReport");
		test.log(Status.INFO,"Report is successfully created");
		report.flush();
	}
}
