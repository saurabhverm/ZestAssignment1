package testCases;

import drivers.DriverInitializer;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import pages.AmazonHomePage;
import pages.FlipkartHomePage;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    protected AmazonHomePage amazonHomePage;
    protected FlipkartHomePage flipkartHomePage;
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Exception {
        driver = new DriverInitializer("chrome").init();
        amazonHomePage = new AmazonHomePage();
        flipkartHomePage = new FlipkartHomePage();
    }

    protected void navigateTo(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
