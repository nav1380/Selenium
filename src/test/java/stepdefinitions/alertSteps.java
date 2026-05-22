package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class alertSteps {

    WebDriver driver;
    WebDriverWait wait;

    public alertSteps() {
        this.driver = Hooks.driver;
        this.wait = Hooks.wait;
    }

    @When("I am on the JS alerts page")
    public void alertsPage() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Then("I click the {string} alert")
    public void clickTheAlert(String alert) {
        switch (alert) {
            case "alert":
                driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
                break;
            case "confirm", "confirmCancel":
                driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
                break;
            case "prompt":
                driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        }
    }

    @Then("I accept the {string} alert")
    public void acceptTheAlert(String alertType) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        switch (alertType) {
            case "alert":
                alert.accept();
                WebElement alertResult = driver.findElement(By.id("result"));
                Assert.assertTrue(alertResult.getText().contains("You successfully clicked an alert"));
                break;
            case "confirm":
                alert.accept();
                WebElement confirmResult = driver.findElement(By.id("result"));
                Assert.assertTrue(confirmResult.getText().contains("You clicked: Ok"));
                break;
            case "confirmCancel":
                alert.dismiss();
                WebElement confirmCancelResult = driver.findElement(By.id("result"));
                Assert.assertTrue(confirmCancelResult.getText().contains("You clicked: Cancel"));
                break;
            case "prompt":
                String keys = "Keys that will be sent";
                alert.sendKeys(keys);
                alert.accept();
                WebElement promptResult = driver.findElement(By.id("result"));
                Assert.assertTrue(promptResult.getText().contains(keys));
                break;
        }
    }
}
