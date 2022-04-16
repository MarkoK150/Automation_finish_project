package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.Reporter;
import pages.ContactUsPage;
import pages.MyAccountPage;
import pages.ProductsPage;
import pages.RegisterPage;
import pages.components.FooterComponents;
import pages.components.HeaderComponents;

import java.io.IOException;

public class TestSteps extends BaseTest {
    String BROWSER = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER");
    String BROWSER_VERSION = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER_VERSION");
    String WAIT_TIME = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT_TIME");

    @Before
    public void setUp(){
        init(BROWSER,BROWSER_VERSION,WAIT_TIME);
    }

    @After
    public void tearDown() throws IOException {
        takeScreenshot("Fiel."+System.currentTimeMillis());
        quit();
    }


    @Given("I have open Automation practice site")
    public void iHaveOpenAutomationPracticeSite() {
        driver.get("http://automationpractice.com/index.php");
    }


    @And("I click on ContactUs button")
    public void iClickOnContactUsButton() {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        headerComponents.clickContactButton();
    }

    @And("Subject Heading - choose option {string}")
    public void subjectHeadingChooseOption(String option) {
        ContactUsPage contactUsPage=new ContactUsPage(driver);
        contactUsPage.chooseSubjectHeading(option);
    }


    @And("I enter email address {string}")
    public void iEnterEmailAddress(String email) {
        ContactUsPage contactUsPage=new ContactUsPage(driver);
        contactUsPage.enterEmail(email);
    }

    @And("I enter ordered reference {string}")
    public void iEnterOrderedReference(String orderedReference) {
        ContactUsPage contactUsPage=new ContactUsPage(driver);
        contactUsPage.enterOrderedReference(orderedReference);
    }



    @And("I write message {string}")
    public void iWriteMessage(String textMessage) {
        ContactUsPage contactUsPage=new ContactUsPage(driver);
        contactUsPage.enterTextMessage(textMessage);
    }

    @When("I click Send button")
    public void iClickSendButton() {
        ContactUsPage contactUsPage=new ContactUsPage(driver);
        contactUsPage.clickSendButton();
    }

    @Then("Check displayed message after send message {string}")
    public void checkDisplayedMessageAfterSendMessage(String messageContactUs) {
        ContactUsPage contactUsPage=new ContactUsPage(driver);
        Assert.assertEquals(contactUsPage.messageSuccessfullySent.getText().trim(),messageContactUs.trim());
    }



    @Then("Check displayed error message {string}")
    public void checkDisplayedErrorMessage(String messageContactUs) {
        ContactUsPage contactUsPage=new ContactUsPage(driver);
        Assert.assertEquals(contactUsPage.contactFormErrorMsg.getText().trim(),messageContactUs.trim());
    }


    @And("I click Sign In Button")
    public void iClickSignInButton() {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        headerComponents.clickSignInButton();
    }

    @And("I enter email address for create new account {string}")
    public void iEnterEmailAddressForCreateNewAccount(String email) {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.enterEmailForCreateAccount(email);
    }

    @And("I enter First Name {string}")
    public void iEnterFirstName(String firstName) {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.enterFirstName(firstName);
    }

    @And("I enter Last Name {string}")
    public void iEnterLastName(String lastName) {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.enterLastName(lastName);
    }



    @And("I enter address {string}")
    public void iEnterAddress(String myAddress) {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.enterMyAddress(myAddress);
    }

    @And("I enter City {string}")
    public void iEnterCity(String city) {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.enterCity(city);
    }

    @And("I chose State {string}")
    public void iChoseState(String state) {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.selectState(state);
    }


    @And("I enter zip code {string}")
    public void iEnterZipCode(String zipCode) {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.enterZipCode(zipCode);
    }

    @And("I enter phone number {string}")
    public void iEnterPhoneNumber(String phoneNumber) {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.enterPhoneNumber(phoneNumber);
    }

    @And("I enter address alias {string}")
    public void iEnterAddressAlias(String addressAlias) {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.enterAddressAlias(addressAlias);
    }

    @When("I click Register button")
    public void iClickRegisterButton() {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.clickRegisterButton();
    }

    @Then("I have open My account page {string}")
    public void iHaveOpenMyAccountPage(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @And("I enter password")
    public void iEnterPassword() throws IOException {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.enterPassword();
    }

    @Then("Check show message {string}")
    public void checkShowMessage(String messageError) {
        RegisterPage registerPage=new RegisterPage(driver);
        Assert.assertEquals(registerPage.errorMsgRegisterForm.getText().trim(),messageError);
    }


    @Then("Check show message error {string}")
    public void checkShowMessageError(String errorMsg) {
        RegisterPage registerPage=new RegisterPage(driver);
        Assert.assertEquals(registerPage.errorMsgEmailRegister.getText().trim(),errorMsg);
    }



    @And("Click Sign out button")
    public void clickSignOutButton() {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        headerComponents.clickSignOutButton();
    }

    @Then("Check message {string}")
    public void checkMessage(String msg) {
        RegisterPage registerPage=new RegisterPage(driver);
        Assert.assertEquals(registerPage.errorMsgEmailRegister.getText().trim(),msg);
    }

    @And("I enter e-mail address")
    public void iEnterEMailAddress() throws IOException {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.enterEmailForNewAccountField1();
    }


    @When("I click item {string} in category {string}")
    public void iClickItemInCategory(String item, String category) {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        headerComponents.clickItemMenu(category,item);
    }

    @Then("Check tittle text {string}")
    public void checkTittleText(String tittleText) {
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertEquals(productsPage.tittleText.getText().trim(),tittleText);
    }

    @And("I enter product name {string} in search field")
    public void iEnterProductNameInSearchField(String product) {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        headerComponents.enterProductInSearchField(product);
    }

    @Then("Check results {string}")
    public void checkResults(String result) {
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertEquals(productsPage.resultProductSearch.getText().trim(),result.trim());
    }

    @Then("Check results for not-existing product {string}")
    public void checkResultsForNotExistingProduct(String result) {
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertEquals(productsPage.resultNonExistentProduct.getText().trim(),result.trim());
    }

    @And("I enter email address for SignIn")
    public void iEnterEmailAddressForSignIn() throws IOException {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.enterEmailForSignIn();
    }

    @And("I enter password for SignIn")
    public void iEnterPasswordForSignIn() throws IOException {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.enterPasswordForSignIn();
    }

    @And("I click button for SignIn")
    public void iClickButtonForSignIn() {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.clickSignInButton();
    }

    @And("I add to cart product")
    public void iAddToCartProduct() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickButtonAddToCartProduct();
    }

    @And("I click button Proceed to checkout")
    public void iClickButtonProceedToCheckout() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickButtonProceed();
    }

    @And("I continue shopping and I click Proceed to checkout")
    public void iContinueShoppingAndIClickProceedToCheckout() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickButtonProceedStep2();
    }

    @And("Click button Proceed to checkout again")
    public void clickButtonProceedToCheckoutAgain() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickButtonProceedStep3();
    }


    @And("Click I agree to the terms of service and click proceed to checkout")
    public void clickIAgreeToTheTermsOfServiceAndClickProceedToCheckout() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickCheckboxAgree();
        productsPage.clickButtonProceedStep4();
    }

    @And("Before paying, I check the product {string}in the cart and choose Pay by check \\(payment method)")
    public void beforePayingICheckTheProductInTheCartAndChoosePayByCheckPaymentMethod(String product) {
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertEquals(productsPage.nameProductInCart.getText().trim(),product.trim());
        productsPage.clickPayByCheck();
    }

    @When("I click button confirm my order")
    public void iClickButtonConfirmMyOrder() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickButtonIConfirmByOrdered();
    }

    @Then("check displayed message about payment {string}")
    public void checkDisplayedMessageAboutPayment(String msg) {
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertEquals(productsPage.messageAboutPayment.getText().trim(),msg.trim());
    }

    @And("I chose product and click button more")
    public void iChoseProductAndClickButtonMore() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickButtonMoreOnProduct();
    }


    @And("Quantity product change to two and I click button Add to cart")
    public void quantityProductChangeToTwoAndIClickButtonAddToCart() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickQuantityUp();
        productsPage.clickAddToCartAfterMore();
    }

    @And("In filter {string} I click {string}")
    public void inFilterIClick(String nameFilter, String optionFilter) throws InterruptedException {

        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.filtersForProduct(nameFilter,optionFilter);
        Thread.sleep(4000);
    }

    @And("I choose Pay by check \\(payment method)")
    public void iChoosePayByCheckPaymentMethod() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickPayByCheck();
    }


    @And("I click button Continue shopping")
    public void iClickButtonContinueShopping() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickButtonContinueShopping();
    }

    @And("I click to Shopping cart")
    public void iClickToShoppingCart() {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        headerComponents.clickShoppingCart();
    }

    @And("I check number product in cart {string}")
    public void iCheckNumberProductInCart(String numProduct) {
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertEquals(productsPage.numberProductInCart.getText().trim(),numProduct.trim());
    }

    @When("I delete product in cart")
    public void iDeleteProductInCart() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickButtonTrash();
    }

    @Then("Check Shopping cart {string}")
    public void checkShoppingCart(String msg) {
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertEquals(productsPage.msgCartEmpty.getText().trim(),msg.trim());
    }

    @When("I enter email address i filed Newsletter {string}")
    public void iEnterEmailAddressIFiledNewsletter(String email) {
        FooterComponents footerComponents=new FooterComponents(driver);
        footerComponents.enterEmailForNewsletter(email);
    }

    @Then("Check displayed message about Newsletter {string}")
    public void checkDisplayedMessageAboutNewsletter(String msg) {
        FooterComponents footerComponents=new FooterComponents(driver);
        Assert.assertEquals(footerComponents.successMsgNewsletter.getText().trim(),msg.trim());
    }

    @Then("Check displayed error message about Newsletter {string}")
    public void checkDisplayedErrorMessageAboutNewsletter(String msg) {
        FooterComponents footerComponents=new FooterComponents(driver);
        Assert.assertEquals(footerComponents.errorMsgNewsletter.getText().trim(),msg.trim());
    }


    @When("I hover button Dresses and click to item {string}")
    public void iHoverButtonDressesAndClickToItem(String item) {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        headerComponents.clickDressesButton(item);
    }

    @Then("Check tittle text on open page {string}")
    public void checkTittleTextOnOpenPage(String tittle) {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        Assert.assertEquals(headerComponents.tittlePage.getText().trim(),tittle.trim());
    }

    @When("I click button T-Shirt")
    public void iClickButtonTShirt() {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        headerComponents.clickTShirtButton();
    }


    @And("I click {string} on breadcrumbs")
    public void iClickOnBreadcrumbs(String item) {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickButtonBreadcrumbs(item);
    }

    @Then("I have open Home Page {string}")
    public void iHaveOpenHomePage(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @When("I click button SignOut")
    public void iClickButtonSignOut() {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        clickSignOutButton();
    }

    @Then("I have open Authentication page {string}")
    public void iHaveOpenAuthenticationPage(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @And("I click on button {string} in footer")
    public void iClickOnButtonInFooter(String item) {
        FooterComponents footerComponents=new FooterComponents(driver);
        footerComponents.clickButtonInfoFooter(item);
    }

    @And("I chose List option in function View")
    public void iChoseListOptionInFunctionView() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickList();
    }

    @And("Check the List option is turned on")
    public void checkTheListOptionIsTurnedOn() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.listViewAddToCart.isDisplayed();
    }



    @And("I click on button Add to Wishlist first Product")
    public void iClickOnButtonAddToWishlistFirstProduct() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickWishList();
    }


    @And("I go to My Account Page")
    public void iGoToMyAccountPage() {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        headerComponents.clickButtonMyAccount();
    }

    @When("I click button My Wishlist")
    public void iClickButtonMyWishlist() {
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.clickButtonMyWishlist();
    }

    @Then("I check number product in Wishlist {string}")
    public void iCheckNumberProductInWishlist(String numProduct) {
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        Assert.assertEquals(myAccountPage.numProductInWishlist.getText().trim(),numProduct.trim());
    }

    @And("I turn off message")
    public void iTurnOffMessage() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.clickTurnOffMsgAddWishlist();
    }

    @Then("I check displayed message about Wishlist {string}")
    public void iCheckDisplayedMessageAboutWishlist(String msg) {
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertEquals(productsPage.msgAddWishlist.getText().trim(),msg.trim());
    }
}
