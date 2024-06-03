package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage{
    public PlaylistPage(WebDriver givenDriver){
        super(givenDriver);
    }

    private By anySong = By.cssSelector("section#playlistWrapper tr.song-item :nth-child(2)");

    private By playlist = By.cssSelector("section#playlists :nth-child(3)");

    String newPlaylistName = "Summer2024";
    public PlaylistPage enterNewPlaylistName() {
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        inputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        inputField.sendKeys(newPlaylistName);
        inputField.sendKeys(Keys.ENTER);
        return this;
    }
    public PlaylistPage doubleClickPlaylist() {
        WebElement dblClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(dblClick).perform();
        return this;
    }

    public PlaylistPage dblClickAnySong(){
        doubleClick(anySong);
        return this;
    }
}
