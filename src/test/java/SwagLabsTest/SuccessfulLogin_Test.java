package SwagLabsTest;

import SwagLabs.AuthorizationPage;
import Utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Urls.Urls.BaseUrl;

public class SuccessfulLogin_Test {
    private WebDriver driver;
    private AuthorizationPage authorizationPage;
    private final String ExpectedUserName = "Username";
    private final String ExpectedPassword = "Password";
    private final String ExpectedButtonText = "Login";

    @BeforeTest
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get(BaseUrl);
        authorizationPage = new AuthorizationPage(driver);
    }

    @Test(priority = 1)
    public void titleText() {
        String actualText1 = authorizationPage.getBlockTitleUserName();
        String actualText2 = authorizationPage.getBlockTitlePassword();
        Assert.assertEquals(actualText1, ExpectedUserName);
        Assert.assertEquals(actualText2, ExpectedPassword);
    }

    @Test(priority = 2)
    public void testLogginText() {
        String buttonText = authorizationPage.getButtonLoginText();
        Assert.assertEquals(buttonText, ExpectedButtonText);
    }

    @Test(priority = 3)
    public void testContinueButtonClick() {
        authorizationPage.interUserName("standard_user");
        authorizationPage.interPassword("secret_sauce");
        authorizationPage.clickButtonLogin();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
