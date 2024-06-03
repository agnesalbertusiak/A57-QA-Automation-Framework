import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest{
    @Test

    public void registrationNavigation() {

        String registrationURl = "https://qa.koel.app/registration";
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.registrationLinkClick();
        Assert.assertEquals(getDriver().getCurrentUrl(),registrationURl);
    }
}
