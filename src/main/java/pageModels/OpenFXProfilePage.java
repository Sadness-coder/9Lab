package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenFXProfilePage extends BasePage {

    @FindBy(css = "#sidebar > div > ul > li:nth-child(1) > div > div.d-flex.align-items-center.multiple-menu-item.py-2.px-3 > i.fa.fa-caret-down.fa-lg.mr-2.ml-auto")
    private WebElement MyAccountsTab;
    @FindBy(css = "#outer-element-0 > ul > li:nth-child(2) > a")
    private WebElement ViewAccountsTab;

    public OpenFXProfilePage selectMyAccountsTab()
    {
        waitForVisibilityOfElement(driver, MyAccountsTab);
        MyAccountsTab.click();
        return this;
    }
    public OpenFXAccountsPage selectViewAccountsTab(){
        waitForVisibilityOfElement(driver, ViewAccountsTab);
        ViewAccountsTab.click();
        return new OpenFXAccountsPage(driver);
    }

    public OpenFXProfilePage(WebDriver driver) {
        super(driver);
    }
}
