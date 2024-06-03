import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest{
    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        BasePage basePage = new BasePage(getDriver());

        loginPage.login();
        homePage.clickPlayBtn().click();
        Assert.assertTrue(basePage.soundBarIconDisplayed());

    }
}
