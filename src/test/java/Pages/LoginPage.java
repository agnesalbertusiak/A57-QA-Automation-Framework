package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //WebElements POM Page Object Model

    private By emailField = By.cssSelector("[type='email']");
    private By passwordField = By.cssSelector("[type='password']");
    private By loginBtn = By.cssSelector("button[type='submit']");
    private By fillOutEmail = By.cssSelector("[placeholder='Password']");
    public WebElement getFillOutEmailMesssage() {return findElement(fillOutEmail);}


    //Page Factory
    @FindBy(css = "[type='email']")
    WebElement emailF;
    @FindBy (css ="[type='password']")
    WebElement passwordF;
    @FindBy(css = "button[type='submit']")
    WebElement loginButton;


    //Helper method

    public LoginPage provideEmail(String email){

        findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password){

        findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtn(){

        findElement(loginBtn).click();
        return this;
    }

    public LoginPage login(){
        provideEmail("agnes.albertusiak@testpro.io");
        providePassword("4Ameryka4aska!");
        clickLoginBtn();
        return this;
    }

    //Methods using Page Factory
    public LoginPage clickSubmitBnt(){
        loginButton.click();
        return  this;
    }

    public LoginPage enterEmail(String email){
        emailF.sendKeys(email);
        return this;
    }
    public LoginPage enterPassword(String password){
        passwordF.sendKeys(password);
        return this;
    }
    public LoginPage registrationLinkClick() {
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='registration']")));
        registrationLink.click();
        return this;
    }
    public String getPasswordNotificationMessage() {
        String validationMessage = passwordF.getAttribute("validationMessage");
        return validationMessage;
    }

    public String getEmailNotificationMessage(){
        String validationMessage = emailF.getAttribute("validationMessage");
        return validationMessage;
    }
}
