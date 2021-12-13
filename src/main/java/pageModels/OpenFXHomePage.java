package pageModels;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OpenFXHomePage extends BasePage {
    private static final String HOMEPAGE_URL = "https://openfx.by/#01";
    @FindBy(css = "#fullpage > section.section.fp-section.active.fp-table.fp-completely > div > div > div > div.header-top > div > div.header-link > a.span.enter")
    private WebElement loginButton;

    public OpenFXHomePage(WebDriver driver) {
        super(driver);
    }

    public OpenFXHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }
    public OpenFXLoginPage openLoginWindow() {
        loginButton.click();
        return new OpenFXLoginPage(driver);
    }
}
