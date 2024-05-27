package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlbumsPage extends BasePage{
    public AlbumsPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean getAlbumsPage(){
        WebElement albums = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#albumsWrapper")));
        return albums.isDisplayed();

    }
}
