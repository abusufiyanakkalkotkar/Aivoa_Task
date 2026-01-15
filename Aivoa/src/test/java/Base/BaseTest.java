package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utils.ExtentManager;
import Utils.ScreenshotUtil;

import java.lang.reflect.Method;
import java.nio.file.Paths;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setUp(Method method) {
        // Report setup
        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());

        // Playwright setup
        try {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            context = browser.newContext();
            context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
            page = context.newPage();
        } catch (Exception e) {
            test.fail("Failed to initialize browser: " + e.getMessage());
            throw new RuntimeException("Browser initialization failed", e);
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Reporting logic
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());

            // Capture screenshot only if page was created successfully
            if (page != null) {
                String screenshotPath = ScreenshotUtil.takeScreenshot(page, result.getName());
                System.out.println("Screenshot saved at: " + screenshotPath);

                // Use relative path for ExtentReports
                test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        } else {
            test.skip("Test skipped");
        }

        // Stop tracing and save trace file
        if (context != null) {
            String traceName = "trace_" + result.getName() + ".zip";
            context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));
            System.out.println("Trace saved as: " + traceName);
        }

        // Browser cleanup
        try {
            if (browser != null) {
                browser.close();
            }
            if (playwright != null) {
                playwright.close();
            }
        } catch (Exception e) {
            System.err.println("Error during cleanup: " + e.getMessage());
        }

        // Flush extent reports (consider moving this to @AfterSuite)
        extent.flush();
    }
}