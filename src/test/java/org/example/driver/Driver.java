package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.util.GetProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void openURL() {
        driver.get(GetProperties.getProperties("config", "mainUrl"));
    }
}
