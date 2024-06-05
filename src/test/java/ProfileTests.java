import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePreferencesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest{

    @Test
    public void changeProfileName(){

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePreferencesPage profilePage = new ProfilePreferencesPage(getDriver());

        String randomName = generateRandomName();
        loginPage.login();
        homePage.clickAvatorIcon();
        profilePage.enterCurrentPassword("4Ameryka4aska!");
        profilePage.provideProfileName(randomName).clickOnSaveBtn();
        homePage.successMessage().isDisplayed();

        Assert.assertEquals(profilePage.actualProfileName().getText(),randomName);

    }

    private String generateRandomName() {
        return UUID.randomUUID().toString().replace("-","");
    }

}
