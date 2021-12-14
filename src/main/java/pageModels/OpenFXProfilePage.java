package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenFXProfilePage extends BasePage {

    @FindBy(css = "#sidebar > div > ul > li:nth-child(1) > div > div.d-flex.align-items-center.multiple-menu-item.py-2.px-3 > i.fa.fa-caret-down.fa-lg.mr-2.ml-auto")
    private WebElement MyAccountsTab;
    @FindBy(css = "#outer-element-0 > ul > li:nth-child(2) > a")
    private WebElement ViewAccountsTab;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div/ul/li[3]/div/div[2]/ul/li[1]/a")
    private WebElement personalDataTab;
    @FindBy(css = "ul.mt-2 > li:nth-child(3) > div:nth-child(1) > div:nth-child(1)")
    private WebElement myProfileTab;
    public OpenFXProfilePage selectMyAccountsTab()
    {
        waitForVisibilityOfElement(driver, MyAccountsTab);
        MyAccountsTab.click();
        return this;
    }
    public OpenFXProfilePage selectMyProfileTab()
    {
        waitForVisibilityOfElement(driver, myProfileTab);
        myProfileTab.click();
        return this;
    }
    public OpenFXAccountsPage selectViewAccountsTab(){
        waitForVisibilityOfElement(driver, ViewAccountsTab);
        ViewAccountsTab.click();
        return new OpenFXAccountsPage(driver);
    }
    public OpenFXPersonalData selectPersonalDataTab(){
        waitForVisibilityOfElement(driver, personalDataTab);
        personalDataTab.click();
        return new OpenFXPersonalData(driver);
    }

    public OpenFXProfilePage(WebDriver driver) {
        super(driver);
    }
}
