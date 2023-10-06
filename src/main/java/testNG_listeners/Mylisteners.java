package testNG_listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.onkar.utilities.ExtentReportGeneration;
import com.onkar.utilities.Utils;

public class Mylisteners implements ITestListener {

	ExtentReports extentreport;
	ExtentTest extenttest;

	@Override
	public void onStart(ITestContext context) {
		extentreport = ExtentReportGeneration.extentReportGenerator();
		System.out.println("..Test execution started");
	}

	@Override
	public void onTestStart(ITestResult result) {
		extenttest = extentreport.createTest("..Test" + result.getName() + " created");
		extenttest.log(Status.INFO, "..Test" + result.getName() + " started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.log(Status.PASS, "..Test" + result.getName() + " passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		String destinationScreenshotPath = Utils.captureScreenshot(driver, result.getName());

		extenttest.addScreenCaptureFromPath(destinationScreenshotPath);
		extenttest.log(Status.INFO, "..Test" + result.getThrowable() + " failed");
		extenttest.log(Status.FAIL, "..Test" + result.getName() + " failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extenttest.log(Status.INFO,result.getThrowable());
		extenttest.log(Status.SKIP, "..Test" + result.getName() + " skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();
		System.out.println("..Test execution finished");
	}

}
