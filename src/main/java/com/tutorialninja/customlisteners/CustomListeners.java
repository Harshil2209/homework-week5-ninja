package com.tutorialninja.customlisteners;

public class CustomListeners implements ITestListener {
    public ExtentSparkReporter reporter;
    public ExtentReports reports;
    public static ExtentTest test;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = reports.createTest(iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(Status.PASS, "TEST CASE PASSED IS " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        test.log(Status.FAIL, "TEST FAILED IS " + iTestResult.getName());
        test.log(Status.FAIL, "TEST FAILED IS " + iTestResult.getThrowable());
        String screenshotPath = takeScreenShot(iTestResult.getName());
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.log(Status.SKIP, "TEST SKIPPED IS " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extent.html");
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Tutorials Ninja");
        reporter.config().setTheme(Theme.DARK);
        reports = new ExtentReports();
        reports.attachReporter(reporter);

        reports.setSystemInfo("User Name", System.getProperty("user.name"));
        reports.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        reports.setSystemInfo("Machine", "Windows 10 " + "64 Bit Professional");
        reports.setSystemInfo("Selenium", "4.15.0");
        reports.setSystemInfo("Maven", "4.0.0");
        reports.setSystemInfo("Java Version", "17.0.8");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        reports.flush();
    }


}
