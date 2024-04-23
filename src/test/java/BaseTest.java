import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import javax.swing.*;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver;

    private static final ThreadLocal<WebDriver> threadDriver= new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadDriver.get();
    }
    WebDriverWait wait;
    public Actions actions= null;
    public String url = null;
    String newPlaylistName = "Summer2024";

    @BeforeSuite
    static void setupClass() {

        //WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
    }


    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser (String BaseURL)throws MalformedURLException{
        threadDriver.set(pickBrowser(System.getProperty("browser"))); //this one for parallel testing
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        url = BaseURL;
        getDriver().get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        actions = new Actions(driver);
    }
@AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
}
    public static WebDriver pickBrowser (String browser) throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.0.0.105:4444";
        switch(browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--incognito");
                edgeOptions.addArguments("--start-maximized");
                return driver = new EdgeDriver(edgeOptions);


                // GRID cases

            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(chromeOptions);
        }
    }

    public static WebDriver lambdaTest() throws MalformedURLException{
        String hubURL ="http://hub.lambdatest.com/wd/hub";
        String userName ="a23ska";
        String accessKey ="51pxhdIT5SNNtUNX3dbZAeYq5wfT2JMoAoPKTS1MguEsK6sHHz";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "123.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "a23ska");
        ltOptions.put("accessKey", "51pxhdIT5SNNtUNX3dbZAeYq5wfT2JMoAoPKTS1MguEsK6sHHz");
        ltOptions.put("project", "Koel Automation");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        capabilities.setCapability("LT:Options", ltOptions);

        return driver= new RemoteWebDriver(new URL(hubURL), capabilities);
    }
    public void clickLoginBtn() {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submit.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.sendKeys(email);
    }

    public void navigateToPage() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }





    public String getNotificationText() {
        WebElement notificationT = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return notificationT.getText();
    }






  //Mouse Hover


    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist")));
        deletePlaylistBtn.click();
    }

    public void clickAnyPlaylist() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        clickPlaylist.click();
    }





    public String getRenamePlaylistSuccessMsg(){
   WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
   return notification.getText();
}
}