package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FavoritesPage extends BasePage{
    public FavoritesPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean listOfFavoritesIsDisplayed() {
        WebElement favoritesList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#favoritesWrapper")));
        return favoritesList.isDisplayed();
    }
}
