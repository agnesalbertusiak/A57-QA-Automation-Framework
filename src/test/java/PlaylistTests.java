import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest {

    @Test (priority=1)
    public void renamePlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage =new PlaylistPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        String updatedPlaylistMsg = "Updated playlist \""+newPlaylistName+".\"";
        loginPage.login();
        playlistPage.doubleClickPlaylist().enterNewPlaylistName();
        Assert.assertTrue(homePage.getNotificationText().contains(updatedPlaylistMsg));
    }
    @Test (priority=2)
    public void addSongToPlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage =new PlaylistPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        String newSongAddedNotification = "Added 1 song into";

        loginPage.login();
        homePage.searchSong("Dark Days").clickViewAllBtn().clickTheFirstSong().clickAddToBtn().choosePlaylist();

        Assert.assertTrue(homePage.getNotificationText().contains(newSongAddedNotification));

    }
    @Test (priority=3)
    public void deletePlaylistTest() {
        //String deletedPlaylistMessage = "Deleted playlist";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.clickFirstPlayist().clickDeleteBtn().clickOk();

        Assert.assertTrue(homePage.successfullNotifMessage().isDisplayed());
    }
}
