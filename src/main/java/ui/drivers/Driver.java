package ui.drivers;

import org.openqa.selenium.WebDriver;
import ui.config.ConfigProvider;

public class Driver {
    private Driver() {
    }

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigProvider.BROWSER.toLowerCase()){
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFireFoxWebDriver();
                    break;
                    case "edge":
                    driver = EdgeWebDriver.loadEdgeWebDriver();
                    break;
                    case "safari":
                    driver = SafariWebDriver.loadSafariWebDriver();
                default:
                    throw new IllegalArgumentException("You provided wrong Driver name");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                driver = null;

            }
        } catch (Exception e) {
            System.out.println("Error while closing driver");
        }
    }
}


