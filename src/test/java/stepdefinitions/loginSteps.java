package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.loginPage;

import java.time.Duration;

public class loginSteps {

    WebDriver driver;

    public loginSteps() {
        this.driver = Hooks.driver;
    }

    @Given("user is on login page")
    public void verifyUserIsOnTheLoginPage() {
        loginPage login = new loginPage(driver);
        driver.get("https://www.saucedemo.com/");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @When("user enters username and password")
    public void verifyUserCanEnterUsernameAndPassword() {
        loginPage login = new loginPage(driver);
//        driver.findElement(By.cssSelector("[name='user-name']")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        login.enterUsernameAndPassword("standard_user", "secret_sauce");
        login.clickLogin();
    }

    @When("user should see dashboard")
    public void verifyUserCanSeeDashboard() {
        loginPage login = new loginPage(driver);
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

    }

}