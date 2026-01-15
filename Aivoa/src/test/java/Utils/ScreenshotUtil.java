package Utils;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String takeScreenshot(Page page, String testName) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:i:ss").format(new Date());
        String path = "surefire-reports/screenshots/" + testName + "_" + timestamp + ".jpg";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        return path;
    }
}