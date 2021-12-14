package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenFXSkypeEditPage extends BasePage{
    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div[2]/div[3]/input")
    private WebElement fieldToEnterSkype;
    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div[2]/div[5]/button")
    private WebElement changeSkypeButton;
    public String currSkypeString = "";
    public OpenFXSkypeEditPage(WebDriver driver) {
        super(driver);
    }
    public OpenFXSkypeEditPage insertSkype(){
        waitForVisibilityOfElement(driver, fieldToEnterSkype);
        fieldToEnterSkype.sendKeys(generateSkype());
        return this;
    }
    public OpenFXSkypeEditPage writeCurrentSkype(){
        waitForVisibilityOfElement(driver, fieldToEnterSkype);
        currSkypeString = fieldToEnterSkype.getText();
        return this;
    }

    public OpenFXSkypeEditPage saveNewSkype(){
        waitForVisibilityOfElement(driver, changeSkypeButton);
        changeSkypeButton.click();
        return this;
    }
    private String generateSkype(){
        String newSkype = "";
        for(int i =0; i<10;i++){
            newSkype += (char)(Math.random()*26+65);
        }
        return newSkype;
    }
}
