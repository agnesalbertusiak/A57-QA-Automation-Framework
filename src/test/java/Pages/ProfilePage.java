package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver givenDriver){
        super(givenDriver);
    }

    private By profileName = By.cssSelector("a.view-profile>span");
    public ProfilePage provideCurrentPassword(String password) {
        WebElement currentPassword = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='current_password']")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
        return this;

    }

    public ProfilePage provideProfileName(String newProfileName){
        WebElement profileName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='inputProfileName']")));
        profileName.clear();
        profileName.sendKeys(newProfileName);
        return this;
    }

    public ProfilePage clickOnSaveBtn(){
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btn-submit']")));
        saveBtn.click();
        return this;
    }

    public WebElement actualProfileName(){return findElement(profileName);
    }
   //WebElement actualProfileName = getDriver().findElement(By.cssSelector("a.view-profile>span"));
   public String generateRandomName(){
       return UUID.randomUUID().toString().replace("-","");
   }
}
