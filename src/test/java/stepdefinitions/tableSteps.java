package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class tableSteps {

    WebDriver driver;

    @Given("user is on the dataTables page")
    public void userOnDataTablesPage() {
        driver = Hooks.driver;
        driver.get("https://datatables.net/");
    }

    @When("user checks that the tables are visible")
    public void userChecksTables() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement table = driver.findElement(By.cssSelector("table thead tr"));
        wait.until(ExpectedConditions.visibilityOf(table));

        List<WebElement> tableHeaders = table.findElements(By.className("dt-column-title"));

        String[] validate = {"Name", "Position", "Office", "Age", "Start date", "Salary"};
        int counter = 0;

        for (WebElement t : tableHeaders) {
            Assert.assertEquals(validate[counter], t.getAttribute("textContent"));
            counter++;
        }

    }

}
