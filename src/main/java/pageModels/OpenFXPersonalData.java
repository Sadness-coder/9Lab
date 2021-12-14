package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenFXPersonalData extends BasePage{
    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/table/tbody/tr[4]/td[2]/a")
    private WebElement editSkypeButton;
    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/table/tbody/tr[4]/td[1]")
    private WebElement skypeSpan;
    public String prevSkypeString;
    public OpenFXPersonalData(WebDriver driver) {
        super(driver);
    }
    public OpenFXPersonalData writePrevSkype(){
        waitForVisibilityOfElement(driver, skypeSpan);
        prevSkypeString = skypeSpan.getText();
        return this;
    }
    public OpenFXSkypeEditPage clickEditSkypeButton(){
        waitForVisibilityOfElement(driver, editSkypeButton);
        editSkypeButton.click();
        return new OpenFXSkypeEditPage(driver);
    }
}
