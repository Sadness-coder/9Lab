package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageModels.*;

public class OpenFXTest {
    private WebDriver driver;
    private OpenFXProfilePage openFXProfilePage;
    private OpenFXAccountsPage openFXAccountsPage;
    private OpenFXDemoAccountPage openFXDemoAccountPage;
    private OpenFXLoginPage openFXLoginPage;

    private String phoneNumber = "333898719";
    private String password = "Aezakmi123";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        openFXProfilePage = new OpenFXHomePage(driver)
                .openPage()
                .openLoginWindow()
                .enterPhoneNumber(phoneNumber)
                .enterPassword(password)
                .signIn();
    }
    @Test
    public void TopUpDemoBalance() throws InterruptedException {
        openFXProfilePage.selectMyAccountsTab();
        openFXAccountsPage = openFXProfilePage.selectViewAccountsTab();
        openFXAccountsPage.openSettingOfDemoAccountButtonClick();
        openFXDemoAccountPage = openFXAccountsPage.infoAboutAccountButtonClick();
        openFXDemoAccountPage.writePreviousBalance()
                .clickTopUpButton()
                .clickAcceptTopUpButton();
                Thread.sleep(1000);
        openFXDemoAccountPage.writeCurrentBalance();
        Assert.assertNotEquals(openFXDemoAccountPage.currentBalanceString, openFXDemoAccountPage.previousBalanceString);

    }

    @AfterMethod(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
