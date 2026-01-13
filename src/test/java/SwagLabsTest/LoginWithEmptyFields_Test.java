package SwagLabsTest;

import SwagLabs.AuthorizationPage;
import Utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Urls.Urls.BaseUrl;

public class LoginWithEmptyFields_Test {
    private WebDriver driver;
    private AuthorizationPage authorizationPage;
    private final String TextError = "Epic sadface: Username is required";
    @BeforeTest
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get(BaseUrl);
        authorizationPage = new AuthorizationPage(driver);
    }
    @Test
    public void testContinueButtonClick() {
        authorizationPage.interUserName("");
        authorizationPage.interPassword("");
        authorizationPage.clickButtonLogin();
        authorizationPage.visibleIcon();
        authorizationPage.visibleButtonError();
        String actualtext = authorizationPage.getErrorText();
        Assert.assertEquals(actualtext, TextError);


    }
    @AfterTest
    public void tearDown() {
        authorizationPage.clicButtonError();
        authorizationPage.clearInput();
        authorizationPage.clearPassword();
    }
}
