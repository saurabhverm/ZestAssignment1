package drivers;

import browserFactory.ChromeBrowser;
import org.openqa.selenium.WebDriver;

public class DriverInitializer {

    private String browser;

    public DriverInitializer(String browser) {
        this.browser = browser;
    }

    public WebDriver init() throws Exception {

        WebDriver webDriver = null;
        webDriver = new ChromeBrowser().getDriver();

        DriverProvider.setDriver(webDriver);
        return webDriver;
    }

}
