package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class baseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void getSetup() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver = new ChromeDriver();
        driver.get("https://datatables.net/examples/basic_init/multiple_tables.html");
    }

//    @AfterClass
//    public void exitSetup() {
//        driver.quit();
//    }

}
