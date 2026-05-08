package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Base {
    protected WebDriver driver;

    @BeforeClass
    public void goTo() {
//        ChromeOptions options = new ChromeOptions();
//
//        options.addArguments("--incognito");
//        options.addArguments("--headless=new");

        driver = new ChromeDriver();
        driver.get("https://datatables.net/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
