package listners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.ExtentReportManager;
import util.ScreenshotUtil;

public class MyEventListner implements ITestListener {
    public  static final Logger logger= LogManager.getLogger(MyEventListner.class);
    private ExtentReports extentReports;
    private ExtentTest test;
    String filename=System.getProperty("user.dir")+"/test-output/ExtentReport.html";



    @Override
    public void onStart(ITestContext context) {
      extentReports=ExtentReportManager.createInstance(filename);
      logger.info("Test Suite Started"+context.getName());
    }


    @Override
    public void onTestStart(ITestResult result) {
        String testName=result.getMethod().getMethodName();
        test=extentReports.createTest(testName);
        logger.info("Test started:"+ testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Passed");
        logger.info("Test Passed:"+result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName=result.getName();
        Object currentClass=result.getInstance();
        WebDriver driver= ((BaseTest) currentClass).driver;


        String screenshotPath=ScreenshotUtil.takeScreenshot(driver,testName);
        test.log(Status.FAIL,"Test failed:"+result.getThrowable().getMessage());
        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            logger.error("Failed to attach screenshot to report");
        }
        logger.error("test failed"+ testName);





    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP,"Test Skipped:"+ result.getThrowable().getMessage());
        logger.warn("Test skipped:"+ result.getMethod().getMethodName());
    }



    @Override
    public void onFinish(ITestContext context) {
        if (extentReports != null) {

            extentReports.flush();
        }
        logger.info("Test suite finished: "+ context.getName());
    }
}
