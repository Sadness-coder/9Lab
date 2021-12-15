package test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
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
    private OpenFXPersonalData openFXPersonalData;
    private OpenFXSkypeEditPage openFXSkypeEditPage;

    private String phoneNumber = "7404483675";
    private String password = "1234567Aa";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        driver = new FirefoxDriver(options);
        Dimension d = new Dimension(1296, 1010);
        driver.manage().window().setSize(d);
        openFXProfilePage = new OpenFXHomePage(driver)
                .openPage()
                .openLoginWindow()
                .enterPhoneNumber(phoneNumber)
                .enterPassword(password)
                .signIn();
    }
    @Test
    public void topUpDemoBalance() throws InterruptedException {
        openFXProfilePage.selectMyAccountsTab();
        openFXAccountsPage = openFXProfilePage.selectViewAccountsTab();
        openFXAccountsPage.openSettingOfDemoAccountButtonClick();
        openFXDemoAccountPage = openFXAccountsPage.infoAboutAccountButtonClick();
        openFXDemoAccountPage.writePreviousBalance()
                .clickTopUpButton()
                .clickAcceptTopUpButton();
                Thread.sleep(2000);
        openFXDemoAccountPage.writeCurrentBalance();
        Assert.assertNotEquals(openFXDemoAccountPage.currentBalanceString, openFXDemoAccountPage.previousBalanceString);
    }
    @Test
    public void switchSkypeInAccount() throws InterruptedException {
        openFXProfilePage.selectMyProfileTab();
        openFXPersonalData = openFXProfilePage.selectPersonalDataTab()
                .writePrevSkype();
        openFXSkypeEditPage = openFXPersonalData.clickEditSkypeButton();
        openFXSkypeEditPage.insertSkype()
                .writeCurrentSkype()
                .saveNewSkype();
        Assert.assertNotEquals(openFXSkypeEditPage.currSkypeString,openFXPersonalData.prevSkypeString );
    }

    @AfterMethod(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
