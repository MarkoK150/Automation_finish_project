package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.CommonComponentsAndAction;

import java.util.Random;

public class FooterComponents extends CommonComponentsAndAction {
    WebDriver driver;

    public FooterComponents(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String randomText(int num){
        String[] chars={"q","w","e","r","t","y","u","i","o","p","a",};
        String result ="";

        Random r = new Random();

        for (int i=0; i<num; i++){
            result += chars[r.nextInt(10)];
        }

        return result;
    }

    @FindBy(css = "input[id=\"newsletter-input\"]")
    public WebElement newsletterField;

    public void enterEmailForNewsletter(String email){
        TypeText(newsletterField,randomText(5)+email);
        newsletterField.sendKeys(Keys.ENTER);
    }

    @FindBy(css = "p[class=\"alert alert-danger\"]")
    public WebElement errorMsgNewsletter;

    @FindBy(css = "p[class=\"alert alert-success\"]")
    public WebElement successMsgNewsletter;


    public void clickButtonInfoFooter(String item){
        WebElement infoItem=driver.findElement(By.xpath("//div[@class=\"footer-container\"]//section[@id=\"block_various_links_footer\"]//a[@title='"+item+"']"));

        clickElement(infoItem);
    }
}
