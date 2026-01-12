package SwagLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {
    WebDriver driver;
    @FindBy(xpath = ("//input[@placeholder = 'Username']"))
    WebElement blockTitleUserName;

    @FindBy(xpath = ("//input[@placeholder = 'Password']"))
    WebElement blockTitlePassword;

    @FindBy(xpath = ("//input[@value = 'Login']"))
    WebElement buttonLogin;


    @FindBy(xpath = ("//input[@class = 'input_error form_input' and @placeholder ='Username']"))
    WebElement inputUserName;

    @FindBy(xpath = ("//input[@class = 'input_error form_input' and @placeholder ='Password']"))
    WebElement inputPassword;

    @FindBy(xpath = ("//h3[@data-test = 'error']"))
    WebElement errorText;

    @FindBy(xpath = ("//*[@data-icon = 'times-circle'][1]"))
    WebElement iconClose;
    @FindBy(xpath = ("//button[@class='error-button']"))
    WebElement buttonError;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visibleButtonError() {buttonError.isDisplayed();}

    public void visibleIcon() {iconClose.isDisplayed();}

    public String getErrorText() {return errorText.getText();}

    public String getBlockTitleUserName() {
        return blockTitleUserName.getAttribute("placeholder");
    }

    public String getBlockTitlePassword() {
        return blockTitlePassword.getAttribute("placeholder");
    }

    public String getButtonLoginText() {
        return buttonLogin.getAttribute("value");
    }

    public void clickButtonLogin() {
        buttonLogin.click();
    }

    public void interUserName(String name) {
        inputUserName.sendKeys(name);
    }

    public void interPassword(String password) {
        inputPassword.sendKeys(password);
    }
}
