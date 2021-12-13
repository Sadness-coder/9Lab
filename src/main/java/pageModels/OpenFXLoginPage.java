package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenFXLoginPage extends BasePage {

    @FindBy(css = "#login > form > div:nth-child(1) > div.col-12.input-group > input")
    private WebElement fieldForPhoneNumber;

    @FindBy(css = "#login > form > div:nth-child(2) > div > div > input:nth-child(1)")
    private WebElement fieldForPassword;
    @FindBy(css = "#login > form > div:nth-child(3) > div.col-12.text-center > button")
    private WebElement submitLogInButton;

    protected OpenFXLoginPage(WebDriver driver) {
        super(driver);
    }

    public OpenFXLoginPage enterPhoneNumber(String email) {
        waitForVisibilityOfElement(driver, fieldForPhoneNumber);
        fieldForPhoneNumber.sendKeys(email);
        return this;
    }
    public OpenFXLoginPage enterPassword(String password) {
        waitForVisibilityOfElement(driver, fieldForPassword);
        fieldForPassword.sendKeys(password);
        return this;
    }
    public OpenFXProfilePage signIn() {
        waitForElementToBeClickable(driver, submitLogInButton);
        submitLogInButton.click();
        return new OpenFXProfilePage(driver);
    }
}
