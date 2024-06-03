package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RecentlyPlayedPage extends BasePage{
    public RecentlyPlayedPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    private By anySong = By.cssSelector("section#recentlyPlayedWrapper table.items :nth-child(9)");

    public RecentlyPlayedPage dblClickAnySong(){
        doubleClick(anySong);
        return this;
    }

    public boolean getRecentlyPlayedPage(){
        WebElement recentlyPlayedPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#recentlyPlayedWrapper")));
        return recentlyPlayedPage.isDisplayed();
    }
}
