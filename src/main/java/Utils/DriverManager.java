package Utils;

import Paths.Paths;
import SwagLabs.AuthorizationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver driver;
    private DriverManager(){}

    public static WebDriver getDriver(){
        if(driver == null){
            initializeDriver();
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver !=null){
            driver.quit();
            driver = null;
        }
    }
    private static void initializeDriver(){
        System.setProperty("webdriver.chrome.driver", Paths.driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
