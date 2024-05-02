package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    //WebElements

    private By avatarIcon = By.cssSelector("img[class='avatar']");
    private By notificationMessage = By.cssSelector("div.success.show");
    private By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    private By deleteBtn = By.cssSelector("button.del.btn-delete-playlist");
    private By notificationText = By.cssSelector("div.success.show");
    public WebElement getUserAvatarIcon(){
        return findElement(avatarIcon);
    }

    public WebElement successMessage() {return findElement(notificationText);}

    public WebElement successfullNotifMessage(){return findElement(notificationMessage);}

    public HomePage clickFirstPlayist(){findElement(firstPlaylist).click();
    return this;}
    public HomePage clickDeleteBtn(){findElement(deleteBtn).click();
    return this;}

    public WebElement clickPlayBtn() {
        WebElement playButton = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playButton).perform();
        return wait.until(ExpectedConditions.visibilityOf(playButton));

    }

    public String getNotificationText() {
        WebElement notificationT = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return notificationT.getText();
    }
    public HomePage searchSong(String song) {
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
        search.sendKeys(song);
        return this;
    }

    public HomePage searchArtist  (String artist){
        WebElement searchA = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
        searchA.sendKeys(artist);
        return this;
        }

    public HomePage choosePlaylist() {
        WebElement chooseAnyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Summer2024')]")));
        chooseAnyPlaylist.click();
        return this;

    }

    public HomePage clickAddToBtn(){
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-add-to")));
        addToBtn.click();
        return this;

    }

    public HomePage clickTheFirstSong() {
        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper  td.title")));
        firstSong.click();
        return this;
    }
    public HomePage clickOk(){
        WebElement clickOkButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.ok")));
        clickOkButton.click();
        return this;
    }
    public HomePage clickViewAllBtn() {
        WebElement viewAllSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results section.songs h1 button")));
        viewAllSearch.click();
        return this;
    }
    public void clickAvatorIcon() {
        WebElement avatarIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[class='avatar']")));
        avatarIcon.click();
    }
}
