import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CurrentQueueTests extends BaseTest{
  @Test
    public void playedSongsAndTotalTimeAreDisplayedInQueuePage(){

      LoginPage loginPage = new LoginPage(getDriver());
      BasePage basePage = new BasePage(getDriver());
      HomePage homePage = new HomePage(getDriver());
      CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

      loginPage.login();
      homePage.clickPlayBtn().click();
      basePage.currentQueuePanel();
      Assert.assertTrue(currentQueuePage.totalSongsCount().isDisplayed());
  }


  @Test
  public void totalSongCountAndTimeAreDisplayed(){
    LoginPage loginPage = new LoginPage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

    loginPage.login();
    homePage.clickPlayBtn().click();
    basePage.currentQueuePanel();
    Assert.assertTrue(currentQueuePage.totalSongsCount().isDisplayed());
  }

  @Test
  public void idPanelIsCorrectlyDisplayedInQueuePage(){
    LoginPage loginPage = new LoginPage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

    loginPage.login();
    homePage.clickPlayBtn().click();
    basePage.currentQueuePanel();
    Assert.assertTrue(currentQueuePage.idNumberPanel().isDisplayed());
  }

  @Test
  public void titlePanelIsCorrectlyDisplayedInQueuePage(){
    LoginPage loginPage = new LoginPage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

    loginPage.login();
    homePage.clickPlayBtn().click();
    basePage.currentQueuePanel();
    Assert.assertTrue(currentQueuePage.titlePanel().isDisplayed());
  }

  @Test
  public void artistPanelIsCorrectlyDisplayedInQueuePage(){
    LoginPage loginPage = new LoginPage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

    loginPage.login();
    homePage.clickPlayBtn().click();
    basePage.currentQueuePanel();
    Assert.assertTrue(currentQueuePage.artistPanel().isDisplayed());
  }

  @Test
  public void albumPanelIsCorrectlyDisplayedInQueuePage(){
    LoginPage loginPage = new LoginPage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

    loginPage.login();
    homePage.clickPlayBtn().click();
    basePage.currentQueuePanel();
    Assert.assertTrue(currentQueuePage.albumPanel().isDisplayed());
  }

  @Test
  public void timePanelIsCorrectlyDisplayedInQueuePage(){
    LoginPage loginPage = new LoginPage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

    loginPage.login();
    homePage.clickPlayBtn().click();
    basePage.currentQueuePanel();
    Assert.assertTrue(currentQueuePage.timePanel().isDisplayed());
  }

  @Test
  public void dblClickingSongOnHomePageIsNavigatingUserToCurrentQueuePage(){
    LoginPage loginPage = new LoginPage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());
    HomePage homePage = new HomePage(getDriver());

    loginPage.login();
    homePage.doubleClickAnySong();
    Assert.assertTrue(currentQueuePage.queuePageWrapper().isDisplayed());
  }

  @Test
  public void dblClickingSongOnArtistsPageIsNavigatingUserToCurrentlyQueuePage(){
    LoginPage loginPage = new LoginPage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());
    ArtistsPage artistsPage = new ArtistsPage(getDriver());

    loginPage.login();
    basePage.artistsPanel();
    artistsPage.doubleClickAnySong();
    Assert.assertTrue(currentQueuePage.queuePageWrapper().isDisplayed());
  }

  @Test
  public void dblClickingSongOnAlbumsPageIsNavigatingUserToCurrentlyQueuePage(){
    LoginPage loginPage = new LoginPage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());
    AlbumsPage albumsPage = new AlbumsPage(getDriver());

    loginPage.login();
    basePage.albumsPanel();
    albumsPage.dblClickAnySong();
    Assert.assertTrue(currentQueuePage.queuePageWrapper().isDisplayed());
  }

  @Test
  public void dblClickingSongOnAllSongsPageIsNavigatingUserToCurrentQueuePage(){
    LoginPage loginPage = new LoginPage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    AllSongsPage allSongsPage = new AllSongsPage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

    loginPage.login();
    basePage.allSongsPanel();
    allSongsPage.dblClickAnySong();
    Assert.assertTrue(currentQueuePage.queuePageWrapper().isDisplayed());
  }
  @Test
  public void dblClickingSongOnFirstPlaylistPageIsNavigatingUserToCurrentQueuePage(){
    LoginPage loginPage = new LoginPage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    PlaylistPage playlistPage = new PlaylistPage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

    loginPage.login();
    basePage.firstPlaylistPanel();
    playlistPage.dblClickAnySong();
    Assert.assertTrue(currentQueuePage.queuePageWrapper().isDisplayed());
  }

  @Test
  public void dblClickingSongOnFavoritesPageIsNavigatingUserToCurrentQueuePage(){
    LoginPage loginPage = new LoginPage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    FavoritesPage favoritesPage = new FavoritesPage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

    loginPage.login();
    basePage.favoritesPanel();
    favoritesPage.dblClickAnySong();
    Assert.assertTrue(currentQueuePage.queuePageWrapper().isDisplayed());
  }
  @Test
  public void dblClickingSongOnRecetlyPlayedPageIsNavigatingUserToCurrentQueuePage(){
    LoginPage loginPage = new LoginPage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    RecentlyPlayedPage recentlyPlayedPage = new RecentlyPlayedPage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

    loginPage.login();
    basePage.recentlyPlayedPanel();
    recentlyPlayedPage.dblClickAnySong();
    Assert.assertTrue(currentQueuePage.queuePageWrapper().isDisplayed());
  }

  @Test
  public void VerifyShuffleAllButtonShufflesSongsAndSongsAppearsOnCurrentQueuePage(){
    LoginPage loginPage = new LoginPage(getDriver());
    AllSongsPage allSongsPage = new AllSongsPage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

    loginPage.login();
    basePage.allSongsPanel();
    allSongsPage.shuffleButton();
    Assert.assertTrue(currentQueuePage.idNumberPanel().isDisplayed());
  }

  @Test
  public void CurrentlyQueuePageIsEmptyAfterClickingClearBtn(){
    LoginPage loginPage = new LoginPage(getDriver());
    AllSongsPage allSongsPage = new AllSongsPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    BasePage basePage = new BasePage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

    String messageDisplayed = "No songs queued.";

    loginPage.login();
    homePage.clickPlayBtn().click();
    basePage.currentQueuePanel();
    currentQueuePage.clearButton();
    Assert.assertTrue(currentQueuePage.queueNoSongsText().contains(messageDisplayed));
  }

}
