package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlbumsPage extends BasePage{
    public AlbumsPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    private By anySong = By.cssSelector("section#albumsWrapper :nth-child(4)");

    public AlbumsPage dblClickAnySong(){
        doubleClick(anySong);
        return this;
    }
    public boolean getAlbumsPage(){
        WebElement albums = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#albumsWrapper")));
        return albums.isDisplayed();

    }
}
