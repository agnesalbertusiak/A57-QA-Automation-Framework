import pages.ArtistsPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
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
