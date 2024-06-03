package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CurrentQueuePage extends BasePage{
    public CurrentQueuePage(WebDriver givenDriver){
        super(givenDriver);
    }

    private By songsCountAndTime = By.cssSelector("span[data-test=list-meta]");
    private By idNumber = By.cssSelector("section[id='queueWrapper'] th.track-number");
    private By title = By.cssSelector("section[id='queueWrapper'] th.title");
    private By artist = By.cssSelector("section[id='queueWrapper'] th.artist");
    private By album = By.cssSelector("section[id='queueWrapper'] th.album");
    private By time = By.cssSelector("section[id='queueWrapper'] th.time");
    private By queueWrapper = By.cssSelector("section#queueWrapper");
    private By clearBtn = By.cssSelector("button.btn-clear-queue");
    private By noSongs = By.cssSelector("section#queueWrapper span.jumbo-icon");


    public WebElement noSongsEmpty(){
        return findElement(noSongs);
    }


    public CurrentQueuePage clearButton(){
        findElement(clearBtn).click();
        return this;
    }

    public WebElement queuePageWrapper(){
        return  findElement(queueWrapper);
    }

   public WebElement totalSongsCount(){
       return findElement(songsCountAndTime);
   }

   public WebElement idNumberPanel(){
       return findElement(idNumber);
   }
   public WebElement titlePanel(){
       return findElement(title);
   }

   public WebElement artistPanel(){
       return findElement(artist);
   }

   public WebElement albumPanel(){
       return findElement(album);
   }

   public WebElement timePanel(){
       return findElement(time);
   }

    public boolean getQueuePage(){
        WebElement queuePage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#queueWrapper")));
        return queuePage.isDisplayed();
    }

    public String queueNoSongsText(){
        WebElement noSongs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#queueWrapper div.text")));
        return noSongs.getText();
    }
}
