package selenium_core;

import org.openqa.selenium.WebDriver;

public interface DriverManagerInterface {
    void createWebDriver(String BROWSER_VERSION);

    void quitWebDriver();

    WebDriver getWebDriver(String BROWSER_VERSION);
}
