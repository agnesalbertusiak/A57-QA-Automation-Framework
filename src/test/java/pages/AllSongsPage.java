package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    public AllSongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    private By anySong = By.cssSelector("section#songsWrapper :nth-child(8)");
    private By shuffleBtn = By.cssSelector("section#songsWrapper button.btn-shuffle-all");



    public AllSongsPage shuffleButton(){
    findElement(shuffleBtn).click();
    return this;
    }
    public AllSongsPage dblClickAnySong(){
        doubleClick(anySong);
        return this;
    }

    public boolean getAllSongsPage(){
        WebElement allSongsPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#songsWrapper")));
        return allSongsPage.isDisplayed();
    }
}
