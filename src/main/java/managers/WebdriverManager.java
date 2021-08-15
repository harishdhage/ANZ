package managers;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverManager {
    private static String driverPath, driverType;
    private static WebDriver driver;
    private static ConfigFileReader configFileReader;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static String applicationUrl;

    public WebdriverManager(){
        configFileReader = new ConfigFileReader();
        driverPath = configFileReader.getWebdriverPath();
        driverType = configFileReader.getDriverType();
        applicationUrl = configFileReader.getUrl();
    }

    public String getUrl(){
        return applicationUrl;
    }

    public WebDriver getDriver(){
        if (driver == null)
            driver = setDriver();
        return driver;
    }

    private WebDriver setDriver(){
        if (driverType.equals("chrome")){
            System.setProperty(CHROME_DRIVER_PROPERTY, driverPath);
            driver = new ChromeDriver();
        }else {
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
