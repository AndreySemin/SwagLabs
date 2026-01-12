package SwagLabsTest;

import SwagLabs.AuthorizationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static Paths.Paths.driverPath;
import static Urls.Urls.urlMane;

public class SuccessfulLogin_Test {
    private WebDriver driver;
    private AuthorizationPage authorizationPage;

    @BeforeTest
    void setup() {
        System.setProperty("webdriver.chrome.driver",
                driverPath);
        driver = new ChromeDriver();
        driver.get(urlMane);
        authorizationPage = new AuthorizationPage(driver);
    }
    private void waitForPageLoad(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void titleText() {
        String text1 = "Username";
        String text2 = "Password";
        String actualText1 = authorizationPage.getBlockTitleUserName();
        String actualText2 = authorizationPage.getBlockTitlePassword();
        if (actualText1.contains(text1)& actualText2.contains(text2)) {
            System.out.println("Текст присутствует");
        } else {
            System.out.println("Текст отсутствует");
        }
    }
    @Test(priority = 2)
    public void testLogginText(){
        String buttonText = authorizationPage.getButtonLoginText();
        Assert.assertEquals(buttonText, "Login");
    }

    @Test(priority = 3)
    private void testContinueButtonClick(){
        authorizationPage.interUserName("standard_user");
        authorizationPage.interPassword("secret_sauce");
        authorizationPage.clickButtonLogin();
        waitForPageLoad(driver);
        ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html");
        driver.quit();

    }

}
