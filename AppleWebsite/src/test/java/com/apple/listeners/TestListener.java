package com.apple.listeners;

import com.apple.reports.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = null;

        try {
            driver = (WebDriver) currentClass.getClass().getSuperclass().getDeclaredField("driver").get(currentClass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String screenshotPath = captureScreenshot(driver, result.getMethod().getMethodName());
        test.get().fail(result.getThrowable(),
		    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    private String captureScreenshot(WebDriver driver, String methodName) {
        if (driver == null) return "Driver was null";

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + methodName + "_" + timestamp + ".png";

        try {
            File destFile = new File(screenshotPath);
            destFile.getParentFile().mkdirs(); // Ensure folder exists
            Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
