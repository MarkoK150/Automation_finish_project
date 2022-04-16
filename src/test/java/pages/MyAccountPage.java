package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.components.FooterComponents;
import pages.components.HeaderComponents;

public class MyAccountPage extends CommonComponentsAndAction{
    WebDriver driver;
    public HeaderComponents headerComponents;
    public FooterComponents footerComponents;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerComponents=new HeaderComponents(driver);
        footerComponents=new FooterComponents(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li[@class=\"lnk_wishlist\"]/a")
    public WebElement buttonMyWishlist;

    public void clickButtonMyWishlist(){
        clickElement(buttonMyWishlist);
    }

    @FindBy(xpath = "//table[@class=\"table table-bordered\"]//td[@class=\"bold align_center\"]")
    public WebElement numProductInWishlist;
}

