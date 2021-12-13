package pageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenFXDemoAccountPage extends BasePage{

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/table[2]/tbody/tr[4]/td[3]/a")
    private WebElement topUpButton;

    @FindBy(css = ".fixSyle2 > span:nth-child(4) > button:nth-child(1)")
    private WebElement acceptTopUpButton;
    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/table[2]/tbody/tr[4]/td[2]/span")
    public WebElement BalanceSpanInPage;
    public String currentBalanceString;
    public String previousBalanceString;
    public OpenFXDemoAccountPage(WebDriver driver) {
        super(driver);
    }
    public OpenFXDemoAccountPage writePreviousBalance(){
        waitForElementToBeClickable(driver, BalanceSpanInPage);
        previousBalanceString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/table[2]/tbody/tr[4]/td[2]/span")).getText();
        return this;
    }
    public OpenFXDemoAccountPage writeCurrentBalance(){
        currentBalanceString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/table[2]/tbody/tr[4]/td[2]/span")).getText();
        return this;
    }
    public OpenFXDemoAccountPage clickTopUpButton(){
        waitForElementToBeClickable(driver, topUpButton);
        topUpButton.click();
        return this;
    }
    public OpenFXDemoAccountPage clickAcceptTopUpButton(){
        waitForElementToBeClickable(driver, acceptTopUpButton);
        acceptTopUpButton.click();
        return this;
    }
}
