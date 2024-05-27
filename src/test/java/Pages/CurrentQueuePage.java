package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CurrentQueuePage extends BasePage{
    public CurrentQueuePage(WebDriver givenDriver){
        super(givenDriver);
    }


    public boolean getQueuePage(){
        WebElement queuePage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#queueWrapper")));
        return queuePage.isDisplayed();

    }
}
