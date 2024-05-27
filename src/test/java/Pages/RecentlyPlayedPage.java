package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RecentlyPlayedPage extends BasePage{
    public RecentlyPlayedPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean getRecentlyPlayedPage(){
        WebElement recentlyPlayedPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#recentlyPlayedWrapper")));
        return recentlyPlayedPage.isDisplayed();
    }
}
