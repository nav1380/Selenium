package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;

import java.time.Duration;

public class baseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void getSetup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterClass
    public void exitSetup() {
        driver.quit();
    }

}
