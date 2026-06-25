package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initDriver(String driverInput) {

        switch (driverInput.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");

                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + driverInput);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
