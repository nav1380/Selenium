package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseTest {
    protected WebDriver driver;

    @BeforeClass
    public void getSetup() {
        driver = new ChromeDriver();
        driver.get("https://datatables.net/examples/basic_init/multiple_tables.html");
    }

    @AfterClass
    public void exitSetup() {
        driver.quit();
    }

}
