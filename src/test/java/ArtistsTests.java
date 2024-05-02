import Pages.ArtistsPage;
import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArtistsTests extends BaseTest{

    @Test
    public void userIsAbleToSeeArtistsInTheApp() {

        LoginPage loginPage = new LoginPage(getDriver());
        ArtistsPage artistsPage = new ArtistsPage(getDriver());

        loginPage.login();
        artistsPage.clickArtistsPage();
        Assert.assertTrue(artistsPage.artistsListIsDisplayed());

    }

    @Test
    public void userIsAbleToPlayASongOfSelectedArtist(){

        LoginPage loginPage = new LoginPage(getDriver());
        ArtistsPage artistsPage = new ArtistsPage(getDriver());
        BasePage basePage = new BasePage(getDriver());

        loginPage.login();
        artistsPage.clickArtistsPage().clickOnSelectedArtist().doubleClickOnFirstSong();

        Assert.assertTrue(basePage.soundBarIconDisplayed());
    }

    @Test
    public void userIsAbleToFindArtistsByUsingSearchField(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ArtistsPage artistsPage = new ArtistsPage(getDriver());

        loginPage.login();
        homePage.searchArtist("Lobo Loco");

        Assert.assertTrue(artistsPage.listOfArtistsIsDisplayed());;
    }




}
