package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ArtistsPage extends BasePage{
    public ArtistsPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    private By firstSong = By.cssSelector("#artistWrapper td.title:nth-child(2)");

    public ArtistsPage clickArtistsPage() {
        WebElement artistPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/artists']")));
        artistPage.click();
        return this;
    }
    public boolean artistsListIsDisplayed() {
        WebElement artistsList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.artists.main-scroll-wrap.as-thumbnails")));
        return artistsList.isDisplayed();
    }
    public ArtistsPage doubleClickOnFirstSong(){
        doubleClick(firstSong);
        return this;
    }
    public ArtistsPage clickOnSelectedArtist() {
        WebElement selectedArtist  = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.artists.main-scroll-wrap.as-thumbnails article[title='Lobo Loco'] a[href='#!/artist/12'] ")));
        selectedArtist.click();
        return this;
    }
    public boolean listOfArtistsIsDisplayed() {
        WebElement artistsList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.artists a.name")));
        return artistsList.isDisplayed();
    }
}
