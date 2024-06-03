package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement findElement (By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void doubleClick(By locator) {
        actions.doubleClick(findElement(locator)).perform();
    }
    private String generateRandomName() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public boolean soundBarIconDisplayed() {
        WebElement soundBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='sound-bar-play']")));
        return soundBar.isDisplayed();
    }
    public BasePage currentQueuePanel(){
        WebElement queuePanel = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/queue']")));
        queuePanel.click();
        return this;
    }

    public BasePage allSongsPanel(){
        WebElement allSongs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/songs']")));
        allSongs.click();
        return this;
    }
    public BasePage albumsPanel(){
        WebElement albums = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/albums']")));
        albums.click();
        return this;
    }

    public BasePage artistsPanel(){
        WebElement artists = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/artists']")));
        artists.click();
        return this;
    }
    public BasePage favoritesPanel(){
        WebElement favorites = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/favorites']")));
        favorites.click();
        return this;
    }
    public BasePage recentlyPlayedPanel(){
        WebElement recentlyPlayed = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/recently-played']")));
        recentlyPlayed.click();
        return this;
    }

    public BasePage firstPlaylistPanel(){
        WebElement firstPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#playlists :nth-child(3)")));
        firstPlaylist.click();
        return this;
    }

    public BasePage homePanel() {
        WebElement recentlyPlayed = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/home']")));
        recentlyPlayed.click();
        return this;
    }
    public BasePage logoutButton(){
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.control.logout")));
        logout.click();
        return this;
    }
}
