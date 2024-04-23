import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest{

    @Test
    public void changeProfileName(){

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        String randomName = generateRandomName();
        loginPage.login();
        homePage.clickAvatorIcon();
        profilePage.provideCurrentPassword("4Ameryka4aska!");
        profilePage.provideProfileName(randomName).clickOnSaveBtn();
        homePage.successMessage().isDisplayed();

        Assert.assertEquals(profilePage.actualProfileName().getText(),randomName);

    }

    private String generateRandomName() {
        return UUID.randomUUID().toString().replace("-","");
    }

}
