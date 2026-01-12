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

public class PerformanceGlitchUser_Test {
    private WebDriver driver;
    private AuthorizationPage authorizationPage;
    private final String TextError = "Epic sadface: Username and password do not match any user in this service";
    @BeforeTest
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get(BaseUrl);
        authorizationPage = new AuthorizationPage(driver);
    }
    @Test
    public void testContinueButtonClick() {
        authorizationPage.interUserName("performance_glitch_user");
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
