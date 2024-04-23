import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    public void loginInvalidEmailPasswordTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("agnes.albertusiak@testpro.io").providePassword("testPro").clickLoginBtn();
        Assert.assertEquals(getDriver().getCurrentUrl(),url);
    }

    @Test

    public void succesfullLoginPF(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agnes.albertusiak@testpro.io").enterPassword("4Ameryka4aska!").clickSubmitBnt();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
}
