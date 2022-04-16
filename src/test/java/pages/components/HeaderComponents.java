package pages.components;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.CommonComponentsAndAction;

public class HeaderComponents extends CommonComponentsAndAction {
    WebDriver driver;

    public HeaderComponents(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()=\"Contact us\"]")
    public WebElement contactUsButton;

    public void clickContactButton() {
        clickElement(contactUsButton);
    }

    @FindBy(css = "div[class=\"header_user_info\"] a")
    public WebElement signInButton;

    public void clickSignInButton() {
        clickElement(signInButton);
    }

    @FindBy(css = "[class=\"header_user_info\"] a[title=\"Log me out\"]")
    public WebElement signOutButton;

    public void clickSignOutButton() {
        clickElement(signOutButton);
    }

    @FindBy(xpath = "//div[@class=\"header_user_info\"]/a")
    public WebElement myAccount;

    public void clickButtonMyAccount(){
        clickElement(myAccount);
    }

    @FindBy(css = "[id=\"searchbox\"] input[placeholder=\"Search\"]")
    public WebElement searchField;

    public void enterProductInSearchField(String product) {
        TypeText(searchField, product);
        searchField.sendKeys(Keys.ENTER);
    }

    public void clickItemMenu(String category, String item) {

        WebElement menuCategory = driver.findElement(By.xpath("//div[@id=\"block_top_menu\"]//a[text()='" + category + "']"));
        WebElement menuItem = driver.findElement(By.xpath("//div[@id=\"block_top_menu\"]/ul/li/a[text()='" + category + "']/..//a[text()='" + item + "']"));


        Actions actions = new Actions(driver);
        actions.moveToElement(menuCategory).moveToElement(menuItem).click().build().perform();
    }


    public void clickDressesButton(String item) {
        WebElement dressesButton = driver.findElement(By.xpath("//ul[@class=\"sf-menu clearfix menu-content sf-js-enabled sf-arrows\"]/li[2]"));
        WebElement dressesItemButton = driver.findElement(By.xpath("//ul[@class=\"sf-menu clearfix menu-content sf-js-enabled sf-arrows\"]/li[2]//a[text()='"+item+"']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(dressesButton).moveToElement(dressesItemButton).click().build().perform();
    }

    @FindBy(xpath = "//div[@id=\"block_top_menu\"]/ul/li[3]//a")
    public WebElement tShirtButton;

    public void clickTShirtButton(){
        clickElement(tShirtButton);
    }

    @FindBy(css = "span[class=\"cat-name\"]")
    public WebElement tittlePage;

    @FindBy(css = "a[title=\"View my shopping cart\"]")
    public WebElement buttonCart;

    public void clickShoppingCart() {
        clickElement(buttonCart);
    }

}
