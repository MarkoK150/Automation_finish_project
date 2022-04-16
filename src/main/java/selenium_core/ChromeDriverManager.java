package selenium_core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements DriverManagerInterface {
WebDriver driver;

    @Override
    public void createWebDriver(String BROWSER_VERSION) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver"+BROWSER_VERSION+".exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("start-maximized");
        this.driver=new ChromeDriver(options);

    }

    @Override
    public void quitWebDriver() {
        if (driver!=null){
            driver.quit();
            driver=null;
        }

    }

    @Override
    public WebDriver getWebDriver(String BROWSER_VERSION) {
        if (driver==null){
            createWebDriver(BROWSER_VERSION);
        }
        return driver;
    }
}
