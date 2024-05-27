package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    public AllSongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean getAllSongsPage(){
        WebElement allSongsPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#songsWrapper")));
        return allSongsPage.isDisplayed();
    }
}
