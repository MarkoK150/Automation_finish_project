package pages;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CommonComponentsAndAction {
    WebDriver driver;
    WebDriverWait wdWait;
    int WAIT= Integer.parseInt(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT_TIME"));

    public CommonComponentsAndAction(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void scrollToWebElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",element);
    }

    public void clickElement(WebElement element){
        wdWait=new WebDriverWait(driver,WAIT);
        wdWait.until(ExpectedConditions.visibilityOf(element));
        wdWait.until(ExpectedConditions.elementToBeClickable(element));

        Actions actions=new Actions(driver);
        actions.moveToElement(element).build().perform();

        element.click();
    }

    public void TypeText(WebElement element, String text){
        wdWait=new WebDriverWait(driver,WAIT);
        wdWait.until(ExpectedConditions.visibilityOf(element));
        wdWait.until(ExpectedConditions.elementToBeClickable(element));

        clickElement(element);
        element.clear();
        element.sendKeys(text);
    }

}
