package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FavoritesPage extends BasePage{
    public FavoritesPage (WebDriver givenDriver) {
        super(givenDriver);
    }


    private By anySong = By.cssSelector("section#favoritesWrapper div.item-container :nth-child(2)");


    public FavoritesPage dblClickAnySong(){
        doubleClick(anySong);
        return this;
    }
    public boolean listOfFavoritesIsDisplayed() {
        WebElement favoritesList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#favoritesWrapper")));
        return favoritesList.isDisplayed();
    }
}
