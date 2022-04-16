package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.components.FooterComponents;
import pages.components.HeaderComponents;

public class ContactUsPage extends CommonComponentsAndAction{
    WebDriver driver;
    public HeaderComponents headerComponents;
    public FooterComponents footerComponents;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerComponents=new HeaderComponents(driver);
        footerComponents=new FooterComponents(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "select[name=\"id_contact\"]")
    public WebElement subjectHeading;

    public void chooseSubjectHeading(String option){
        Select select=new Select(subjectHeading);
        select.selectByVisibleText(option);
    }

    @FindBy(css = "#email")
    public WebElement emailField;

    public void enterEmail(String email){
        TypeText(emailField,email);
    }

    @FindBy(css = "#id_order")
    public WebElement orderedReferenceField;

    public void enterOrderedReference(String orderedReference){
        TypeText(orderedReferenceField,orderedReference);
    }

    @FindBy(css = "input[name=\"fileUpload\"]")
    public WebElement attachFileField;



    @FindBy(css = "#message")
    public WebElement messageField;

    public void enterTextMessage(String textMessage){
        TypeText(messageField,textMessage);
    }

    @FindBy(css = "#submitMessage")
    public WebElement sendButton;

    public void clickSendButton(){
        clickElement(sendButton);
    }

    @FindBy(xpath = "//p[@class=\"alert alert-success\"]")
    public WebElement messageSuccessfullySent;

    @FindBy(css = "div[class=\"alert alert-danger\"] li")
    public WebElement contactFormErrorMsg;


}

