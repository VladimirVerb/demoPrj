package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class ApplicationManager {
    private WebDriver driver;
    private static Wait<WebDriver> wait;

    public ApplicationManager initWD(){
        if(driver == null) {
            if(Config.getBrowser().equals(FIREFOX)){
                System.setProperty("webdriver.gecko.driver", Config.getDrvPath());
                driver =new FirefoxDriver();
            } else {
                System.setProperty("webdriver.chrome.driver", Config.getDrvPath());
                driver =new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 5).withMessage("Element was not found");
        }
        return this;
    }

    public ApplicationManager stopWD(){
        driver.close();
        return this;
    }

    public WebDriver getDriver(){
        return driver;
    }
    public static Wait<WebDriver> getWaiter(){
        return wait;
    }
}
