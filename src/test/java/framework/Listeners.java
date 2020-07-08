package framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener {

	private Logger log = LogManager.getLogger(Listeners.class.getName());
	ExtentTest test;
	ExtentReports extentReports = ExtentReport.getExtentReports();
	ThreadLocal<ExtentTest> threadTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String testMethodName = result.getMethod().getMethodName();
		test = extentReports.createTest(testMethodName);
		threadTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testMethodName = result.getMethod().getMethodName();
		threadTest.get().log(Status.PASS, testMethodName + " passed successfully");
	}


	@Override
	public void onTestFailure(ITestResult result) {
		
		String testMethodName = result.getMethod().getMethodName();

		threadTest.get().fail(result.getThrowable());
		
		try {
			
			WebDriver driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			String screenshotPath = takeScreenshot(driver, testMethodName);
			threadTest.get().addScreenCaptureFromPath(screenshotPath, testMethodName);
		} catch(Exception e){
			log.error(e.getLocalizedMessage());
		}
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
		extentReports.flush();

	}
}



