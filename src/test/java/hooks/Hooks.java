package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.DriverFactory;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverFactory.initDriver(ConfigReader.getBrowser());
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getTimeout()));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}