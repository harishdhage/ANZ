package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {

    public static WebElement explicitWait(WebDriver driver, int timeUnit, WebElement webElement){
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeUnit);
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
