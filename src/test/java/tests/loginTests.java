package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.LoginPage;
import base.baseTestIsolation;
import org.testng.annotations.Test;

public class loginTests extends baseTestIsolation {

    @Test
    public void loginSite() {
        LoginPage login = new LoginPage(driver);
        login.loginToTheWebsite("student", "Password123");

        Assert.assertTrue(driver.getCurrentUrl().contains("logged-in-successfully/"));

        WebElement text = driver.findElement(By.cssSelector(".has-text-align-center"));
        Assert.assertTrue(text.getText().contains("Congratulations"));
        Assert.assertTrue(text.getText().contains("successfully logged in"));

        WebElement logout = driver.findElement(By.xpath("//a[contains(text(), 'Log out')]"));
        Assert.assertTrue(logout.isDisplayed());

    }
}
