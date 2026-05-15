package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.loginPage;

import java.time.Duration;

public class loginSteps {

    WebDriver driver;

    @Given("user is on login page")
    public void verifyUserIsOnTheLoginPage() {
        driver = Hooks.driver;
        loginPage login = new loginPage(driver);
        driver.get("https://www.saucedemo.com/");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @When("user enters username and password")
    public void verifyUserCanEnterUsernameAndPassword() {
        driver = Hooks.driver;
        loginPage login = new loginPage(driver);
//        driver.findElement(By.cssSelector("[name='user-name']")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        login.enterUsernameAndPassword("standard_user", "secret_sauce");
        login.clickLogin();
    }

    @When("user should see dashboard")
    public void verifyUserCanSeeDashboard() {
        driver = Hooks.driver;
        loginPage login = new loginPage(driver);
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

    }

}