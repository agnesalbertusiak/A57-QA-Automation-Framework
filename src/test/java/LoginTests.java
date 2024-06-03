import pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailEmptyPasswordTest(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("agnes.albertusiak@testpro.io");
        loginPage.providePassword(" ");
        loginPage.clickLoginBtn();

        Assert.assertEquals(getDriver().getCurrentUrl(),url);
    }

    @Test
    public void successfullLoginTest(){
        LoginPage loginPage = new LoginPage(getDriver()); // we had before new LoginPage(driver)
        HomePage homePage = new HomePage(getDriver()); // we had (driver) everywhere before

        loginPage.provideEmail("agnes.albertusiak@testpro.io").providePassword("4Ameryka4aska!").clickLoginBtn();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
    @Test
    public void userIsUnableToLoginWithEmptyEmailAndEmptyPassword(){
        LoginPage loginPage = new LoginPage(getDriver()); // we had before new LoginPage(driver)
        HomePage homePage = new HomePage(getDriver()); // we had (driver) everywhere before

        loginPage.provideEmail("").providePassword("").clickLoginBtn();

        Assert.assertTrue(loginPage.getFillOutEmailMesssage().isDisplayed());
    }
    @Test
    public void loginInvalidEmailPasswordTest(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("agnes.albetusiak@testpro.io").providePassword("testPro").clickLoginBtn();
        Assert.assertEquals(getDriver().getCurrentUrl(),url);
    }

    @Test
    public void loginValidEmailInvalidPasswordErrorMessageIsDisplayed(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("agnes.albetusiak@testpro.io").providePassword("testPro").clickLoginBtn();
        Assert.assertEquals(loginPage.getPasswordNotificationMessage(), "Password is incorrect");
    }

    @Test (priority=1)

    public void succesfullLoginWithTestProDomain(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("agnes.albertusiak@testpro.io").providePassword("4Ameryka4aska!").clickLoginBtn();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    @Test (priority=2)
    public void userIsAbleToUpdateEmail(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        String profileUpdatedMsg = "Profile updated.";

        loginPage.login();
        homePage.userProfileIconClick();
        profilePage.enterCurrentPassword("4Ameryka4aska!").enterNewEmail("agnes23@testpro.io").clickOnSaveBtn();

        Assert.assertTrue(homePage.getNotificationText().contains(profileUpdatedMsg));
    }

    @Test (priority=3)
    public void userIsAbleToLoginWithUpdatedEmailAndValidPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agnes23@testpro.io").enterPassword("4Ameryka4aska!").clickSubmitBnt();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    @Test (priority=4)
    public void userIsUnableToLoginWithOldEmailAndValidPassword(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail("agnes.albertusiak@testpro.io").enterPassword("4Ameryka4aska!").clickSubmitBnt();
        Assert.assertEquals(getDriver().getCurrentUrl(),url);
    }

    @Test (priority=5)

    public void userIsAbleToUpdatePassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        String profileUpdatedMsg = "Profile updated.";

        loginPage.enterEmail("agnes23@testpro.io").enterPassword("4Ameryka4aska!").clickSubmitBnt();
        homePage.userProfileIconClick();
        profilePage.enterCurrentPassword("4Ameryka4aska!").enterNewPassword("te$t$tudent1").clickOnSaveBtn();

        Assert.assertTrue(homePage.getNotificationText().contains(profileUpdatedMsg));
    }
    @Test (priority=6)
    public void userIsAbleToLoginWithUpdatedPasswordAndValidEmail(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agnes23@testpro.io").enterPassword("te$t$tudent1").clickSubmitBnt();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    @Test (priority=7)
    public void userIsAbleToUpdateProfileWithOldEmailAndOldPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        String profileUpdatedMsg = "Profile updated.";

        loginPage.enterEmail("agnes23@testpro.io").enterPassword("te$t$tudent1").clickSubmitBnt();
        homePage.userProfileIconClick();
        profilePage.enterCurrentPassword("te$t$tudent1").enterNewEmail("agnes.albertusiak@testpro.io").enterNewPassword("4Ameryka4aska!").clickOnSaveBtn();

        Assert.assertTrue(homePage.getNotificationText().contains(profileUpdatedMsg));
    }
    @Test (priority=8)
    public void userIsUnableToLoginWithOldPasswordAndValidEmailErrorMessageIsDisplayed() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail("agnes23@testpro.io").enterPassword("4Ameryka4aska!").clickSubmitBnt();
       Assert.assertEquals(loginPage.getPasswordNotificationMessage(), "Password is incorrect");
    }
    @Test
    public void userIsUnableToLoginWithoutDotInTheEmailAndValidPasswordErrorMessageIsDisplayed(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail("agnesalbertusiak@testpro.io").enterPassword("4Ameryka4aska!").clickSubmitBnt();
        Assert.assertEquals(loginPage.getPasswordNotificationMessage(), "Email format is incorrect");
    }
    @Test
    public void userIsUnableToLoginWitoutAtInTheMailAndValidPasswordErrorMessageIsDisplayed(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail("agnes.albertusiaktestpro.io").enterPassword("4Ameryka4aska!").clickSubmitBnt();
        Assert.assertEquals(loginPage.getPasswordNotificationMessage(), "Email format is incorrect");
    }
    @Test
    public void userIsUnableToLoginWithoutDomainAndValidPasswordErrorMessageIsDisplayed(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail("agnes.albertusiak@").enterPassword("4Ameryka4aska!").clickSubmitBnt();
        Assert.assertEquals(loginPage.getPasswordNotificationMessage(), "Email format is incorrect");
    }
    @Test
    public void userIsUnableToLoginWithInvalidDomainAndValidPasswordErrormessageIsDisplayed(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail("agnes.albertusiak@gmail.com").enterPassword("4Ameryka4aska!").clickSubmitBnt();
        Assert.assertEquals(loginPage.getPasswordNotificationMessage(), "Email format is incorrect");
    }
    @Test
    public void userIsAbleToNavigateToCurrentQueuePageAfterLoggingIn(){
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

        loginPage.login();
        basePage.currentQueuePanel();
        Assert.assertTrue(currentQueuePage.getQueuePage());
    }
    @Test
    public void userIsAbleToNavigateToAllSongsPageAfterLoggingIn(){
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());

        loginPage.login();
        basePage.allSongsPanel();
        Assert.assertTrue(allSongsPage.getAllSongsPage());
    }

    @Test
    public void userIsAbleToNavigateToAlbumsPageAfterLoggingIn(){
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        AlbumsPage albumsPage = new AlbumsPage(getDriver());

        loginPage.login();
        basePage.albumsPanel();
        Assert.assertTrue(albumsPage.getAlbumsPage());
    }
    @Test
    public void userIsAbleToNavigateToArtistsPageAfterLoggingIn(){
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        ArtistsPage artistsPage = new ArtistsPage(getDriver());

        loginPage.login();
        basePage.artistsPanel();
        Assert.assertTrue(artistsPage.artistsListIsDisplayed());
    }
    @Test
    public void userIsAbleToNavigateToFavoritesPageAfterLoggingIn(){
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        FavoritesPage favoritesPage = new FavoritesPage(getDriver());

        loginPage.login();
        basePage.favoritesPanel();
        Assert.assertTrue(favoritesPage.listOfFavoritesIsDisplayed());
    }
    @Test
    public void userIsAbleToNavigateToRecentlyPlayedPageAfterLoggingIn(){
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        RecentlyPlayedPage recentlyPlayedPage = new RecentlyPlayedPage(getDriver());

        loginPage.login();
        basePage.recentlyPlayedPanel();
        Assert.assertTrue(recentlyPlayedPage.getRecentlyPlayedPage());
    }

    @Test
    public void userIsTakenToHomePageAfterLoggingOutAndLoggingBackIn() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        BasePage basePage = new BasePage(getDriver());

        loginPage.login();
        basePage.homePanel().logoutButton();
        loginPage.login();
        Assert.assertTrue(homePage.homePageIsDisplayed());
    }

    @Test
    public void userIsTakenToCurrentQueuePageAfterLoggingOutAndLoggingBackIn(){
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());

        loginPage.login();
        basePage.currentQueuePanel().logoutButton();
        loginPage.login();
        Assert.assertTrue(currentQueuePage.getQueuePage());
    }

    @Test
    public void userIsTakenToAllSongsPageAfterLoggingOutAndLoggingBackIn(){
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());

        loginPage.login();
        basePage.allSongsPanel().logoutButton();
        loginPage.login();
        Assert.assertTrue(allSongsPage.getAllSongsPage());
    }

    @Test
    public void userIsTakenToAlbumsPageAfterLoggingOutAndLoggingBackIn(){
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        AlbumsPage albumsPage = new AlbumsPage(getDriver());

        loginPage.login();
        basePage.albumsPanel().logoutButton();
        loginPage.login();
        Assert.assertTrue(albumsPage.getAlbumsPage());
    }

    @Test
    public void userIsTakenToArtistsPageAfterLoggingOutAndLoggingBackIn(){
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        ArtistsPage artistsPage = new ArtistsPage(getDriver());

        loginPage.login();
        basePage.artistsPanel().logoutButton();
        loginPage.login();
        Assert.assertTrue(artistsPage.artistsListIsDisplayed());
    }

    @Test
    public void userIsTakenToFavoritesPageAfterLoggingOutAndLoggingBackIn(){
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        FavoritesPage favoritesPage = new FavoritesPage(getDriver());

        loginPage.login();
        basePage.favoritesPanel().logoutButton();
        loginPage.login();
        Assert.assertTrue(favoritesPage.listOfFavoritesIsDisplayed());
    }

    @Test
    public void userIsTakenToRecentlyPlayedPageAfterLoggingOutAndLoggingBackIn(){
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        RecentlyPlayedPage recentlyPlayedPage = new RecentlyPlayedPage(getDriver());

        loginPage.login();
        basePage.recentlyPlayedPanel().logoutButton();
        loginPage.login();
        Assert.assertTrue(recentlyPlayedPage.getRecentlyPlayedPage());

    }
}
