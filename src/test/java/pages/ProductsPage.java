package pages;

import io.cucumber.java.en_old.Ac;
import jdk.nashorn.internal.runtime.regexp.joni.ast.CClassNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.components.FooterComponents;
import pages.components.HeaderComponents;

import java.util.concurrent.TimeUnit;

public class ProductsPage extends CommonComponentsAndAction{
    WebDriver driver;
    public HeaderComponents headerComponents;
    public FooterComponents footerComponents;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerComponents=new HeaderComponents(driver);
        footerComponents=new FooterComponents(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class=\"cat-name\"]")
    public WebElement tittleText;

    @FindBy(css = "[class=\"top-pagination-content clearfix\"] div[class=\"product-count\"]")
    public WebElement resultProductSearch;

    @FindBy(css = "[class=\"heading-counter\"]")
    public WebElement resultNonExistentProduct;

    @FindBy(css = "div[class=\"product-image-container\"]")
    public WebElement product;

    @FindBy(xpath = "//ul[@class=\"product_list grid row\"]/li//span[text()=\"Add to cart\"]")
    public WebElement buttonAddToCartProduct;

    public void clickButtonAddToCartProduct(){
        Actions actions=new Actions(driver);
        actions.moveToElement(product).moveToElement(buttonAddToCartProduct).click().build().perform();

    }

    @FindBy(xpath = "//div[@class=\"button-container\"]//a/span[text()=\"More\"]")
    public WebElement buttonMore;

    public void clickButtonMoreOnProduct(){
        Actions actions=new Actions(driver);
        actions.moveToElement(product).moveToElement(buttonMore).click().build().perform();
    }

    @FindBy(xpath = "//p[@id=\"quantity_wanted_p\"]//i[@class=\"icon-plus\"]")
    public WebElement quantityUp;

    public void clickQuantityUp(){
        clickElement(quantityUp);
    }

    @FindBy(xpath = "//p[@id=\"add_to_cart\"]/button")
    public WebElement addToCartAfterMore;

    public void clickAddToCartAfterMore(){
        clickElement(addToCartAfterMore);
    }

    @FindBy(xpath = "//div[@id=\"layer_cart\"]//a[@title=\"Proceed to checkout\"]")
    public WebElement buttonProceedToCheckout;

    public void clickButtonProceed(){
        clickElement(buttonProceedToCheckout);
    }

    @FindBy(xpath = "//p[@class=\"cart_navigation clearfix\"]//a[@title=\"Proceed to checkout\"]")
    public WebElement buttonProceedToCheckoutStep2;

    public void clickButtonProceedStep2(){
        clickElement(buttonProceedToCheckoutStep2);
    }

    @FindBy(xpath = "//p[@class=\"cart_navigation clearfix\"]//button[@name=\"processAddress\"]")
    public WebElement buttonProceedToCheckoutStep3;

    public void clickButtonProceedStep3(){
        clickElement(buttonProceedToCheckoutStep3);
    }

    @FindBy(css = "p[class=\"checkbox\"] label")
    public WebElement checkboxAgree;

    public void clickCheckboxAgree(){
        clickElement(checkboxAgree);
    }

    @FindBy(xpath = "//p[@class=\"cart_navigation clearfix\"]//button[@name=\"processCarrier\"]")
    public WebElement buttonProceedToCheckoutStep4;

    public void clickButtonProceedStep4(){
        clickElement(buttonProceedToCheckoutStep4);
    }

    @FindBy(css = "[class=\"cart_description\"] a")
    public WebElement nameProductInCart;

    @FindBy(xpath = "//div[@id=\"HOOK_PAYMENT\"]//a[@title=\"Pay by check.\"]")
    public WebElement payByCheck;

    public void clickPayByCheck(){
        clickElement(payByCheck);
    }

    @FindBy(xpath = "//div[@id=\"HOOK_PAYMENT\"]//a[@title=\"Pay by bank wire\"]")
    public WebElement payByBankWire;

    public void clickPayByBankWire(){
        clickElement(payByBankWire);
    }

    @FindBy(css = "button[class=\"button btn btn-default button-medium\"]")
    public WebElement buttonIConfirmByOrdered;

    public void clickButtonIConfirmByOrdered(){
        clickElement(buttonIConfirmByOrdered);
    }

    @FindBy(xpath = "//p[@class=\"alert alert-success\"][text()=\"Your order on My Store is complete.\"]")
    public WebElement messageAboutPayment;

    public void filtersForProduct(String nameFilter,String optionFilter){
        String xpathFilters="//form[@id=\"layered_form\"]/div/div/div[@class=\"layered_subtitle_heading\"]//span[text()='"+nameFilter+"']/..//../ul/li//a[text()='"+optionFilter+"']";

        WebElement filters=driver.findElement(By.xpath(xpathFilters));

        clickElement(filters);

    }

    @FindBy(css = "span[title=\"Continue shopping\"]")
    public WebElement buttonContinueShopping;

    public void clickButtonContinueShopping(){
        clickElement(buttonContinueShopping);
    }

    @FindBy(css = "span[id=\"summary_products_quantity\"]")
    public WebElement numberProductInCart;

    @FindBy(css = "i[class=\"icon-trash\"]")
    public WebElement buttonTrash;

    public void clickButtonTrash(){
        clickElement(buttonTrash);
    }

    @FindBy(css = "p[class=\"alert alert-warning\"]")
    public WebElement msgCartEmpty;


    public void clickButtonBreadcrumbs(String item){
        WebElement itemBreadcrumbs=driver.findElement(By.xpath("//div[@class=\"breadcrumb clearfix\"]//a[@title='"+item+"']"));
        clickElement(itemBreadcrumbs);
    }

    @FindBy(xpath = "//ul[@class=\"display hidden-xs\"]//a[@title=\"Grid\"]")
    public WebElement viewGrid;

    public void clickGrid(){
        clickElement(viewGrid);
    }

    @FindBy(xpath = "//ul[@class=\"display hidden-xs\"]//a[@title=\"List\"]")
    public WebElement viewList;

    public void clickList(){
        clickElement(viewList);
    }

    @FindBy(xpath = "//ul[@class=\"product_list row list\"]/li[1]//span[text()=\"Add to cart\"]")
    public WebElement listViewAddToCart;

    @FindBy(xpath = "//ul[@class=\"product_list row list\"]/li//div[@class=\"wishlist\"]/a")
    public WebElement wishList;

    public void clickWishList(){
        clickElement(wishList);
    }

    @FindBy(xpath = "//a[@title=\"Close\"]")
    public WebElement turnOffMsgAddWishlist;

    public void clickTurnOffMsgAddWishlist(){
        clickElement(turnOffMsgAddWishlist);
    }

    @FindBy(xpath = "//div/p[@class=\"fancybox-error\"]")
    public WebElement msgAddWishlist;


    }





