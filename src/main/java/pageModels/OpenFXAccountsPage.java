package pageModels;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenFXAccountsPage extends BasePage {

    @FindBy(css = "div.row:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(8) > div:nth-child(1) > button:nth-child(1)")
    private WebElement settingsOfDemoAccountButton;
    @FindBy(css = "#table-accounts > tbody > tr > td:nth-child(8) > div > div > a:nth-child(1)")
    private WebElement infoAboutAccountButton;

    protected OpenFXAccountsPage(WebDriver driver) {
        super(driver);
    }
    public OpenFXAccountsPage openSettingOfDemoAccountButtonClick(){
        waitForVisibilityOfElement(driver, settingsOfDemoAccountButton);
        settingsOfDemoAccountButton.click();
        return this;
    }
    public OpenFXDemoAccountPage infoAboutAccountButtonClick(){
        waitForVisibilityOfElement(driver, infoAboutAccountButton);
        infoAboutAccountButton.click();
        return new OpenFXDemoAccountPage(driver);
    }
}
