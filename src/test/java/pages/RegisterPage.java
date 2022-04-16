package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.components.FooterComponents;
import pages.components.HeaderComponents;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class RegisterPage extends CommonComponentsAndAction{
    WebDriver driver;
    public HeaderComponents headerComponents;
    public FooterComponents footerComponents;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerComponents=new HeaderComponents(driver);
        footerComponents=new FooterComponents(driver);
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


    @FindBy(css = "input[id=\"email\"]")
    public WebElement emailForSignInField;

    public void enterEmailForSignIn() throws IOException {
        Path path = Paths.get("src/main/resources/doc.txt");

        String address = Files.readAllLines(path).get(0);

        TypeText(emailForSignInField,address);
    }

    @FindBy(css = "input[id=\"passwd\"]")
    public WebElement passwordForSignInField;

    public void enterPasswordForSignIn() throws IOException {
        Path path = Paths.get("src/main/resources/doc.txt");

        String pass = Files.readAllLines(path).get(1);

        TypeText(passwordForSignInField,pass);

    }

    @FindBy(css = "button[id=\"SubmitLogin\"]")
    public WebElement signInButton;

    public void clickSignInButton(){
        clickElement(signInButton);
    }


    @FindBy(css = "[id=\"email_create\"]")
    public WebElement enterEmailForNewAccountField;

    public void enterEmailForCreateAccount(String email){
        TypeText(enterEmailForNewAccountField,randomText(5)+email);
        enterEmailForNewAccountField.sendKeys(Keys.ENTER);
    }


    public void enterEmailForNewAccountField1() throws IOException {
        Path path = Paths.get("src/main/resources/email.txt");

        String address = Files.readAllLines(path).get(0);
        TypeText(enterEmailForNewAccountField,address);

        enterEmailForNewAccountField.sendKeys(Keys.ENTER);
    }

    @FindBy(css = "[id=\"customer_firstname\"]")
    public WebElement firstNameField;

    public void enterFirstName(String firstName){
        TypeText(firstNameField,firstName);
    }

    @FindBy(css = "[id=\"customer_lastname\"]")
    public WebElement lastNameField;

    public void enterLastName(String lastName){
        TypeText(lastNameField,lastName);
    }

    @FindBy(css = "[id=\"passwd\"]")
    public WebElement passwordField;

    public void enterPassword() throws IOException {

        Path path = Paths.get("src/main/resources/pass.txt");

        String read = Files.readAllLines(path).get(0);

        passwordField.sendKeys(read);



    }

    @FindBy(css = "[id=\"address1\"]")
    public WebElement myAddressField;

    public void enterMyAddress(String myAddress){
        TypeText(myAddressField,myAddress);
    }

    @FindBy(css = "[id=\"city\"]")
    public WebElement cityField;

    public void enterCity(String city){
        TypeText(cityField,city);
    }

    @FindBy(css = "[id=\"id_state\"]")
    public WebElement stateField;

    public void selectState(String state){
        Select select=new Select(stateField);
        select.selectByVisibleText(state);
    }

    @FindBy(css = "[id=\"postcode\"]")
    public WebElement zipCodeField;

    public void enterZipCode(String zipCode){
        TypeText(zipCodeField,zipCode);
    }

    @FindBy(css = "[id=\"phone_mobile\"]")
    public WebElement phoneNumberField;

    public void enterPhoneNumber(String phoneNumber){
        TypeText(phoneNumberField,phoneNumber);
    }

    @FindBy(css = "[id=\"alias\"]")
    public WebElement addressAliasField;

    public void enterAddressAlias(String addressAlias){
        TypeText(addressAliasField,addressAlias);
    }

    @FindBy(css = "button[id=\"submitAccount\"]")
    public WebElement registerButton;

    public void clickRegisterButton(){
        clickElement(registerButton);
    }

    @FindBy(css = "[class=\"alert alert-danger\"] p")
    public WebElement errorMsgRegisterForm;

    @FindBy(css = "[id=\"create_account_error\"] li")
    public WebElement errorMsgEmailRegister;
}

