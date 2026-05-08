import base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;

public class selenium extends Base {

//    @Test
//    public void loginInSauceDemo() {
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.enterUsernameAndPassword("standard_user", "secret_sauce");
//        loginPage.clickLogin();
//
//        String validate = driver.findElement(By.cssSelector(".app_logo")).getText();
//        Assert.assertEquals(validate, "Swag Labs");
//    }

    @Test
    public void datatablesPage() {
        List<WebElement> headers = driver.findElements(By.cssSelector("table thead tr th .dt-column-title"));
        String[] validateHeaders = {"Name", "Position", "Office", "Age", "Start date", "Salary"};

//        int looper = 0;
//        for (WebElement h : headers) {
//            Assert.assertEquals(h.getAttribute("textContent"), validateHeaders[looper]);
//            looper++;
//        }

        for (int i = 0; i < headers.size(); i++) {
            System.out.println(headers.get(i).getAttribute("innerText"));
            WebElement headerToValidate = headers.get(i);
            Assert.assertEquals(headerToValidate.getAttribute("innerText"), validateHeaders[i]);
        }

    }

//    @BeforeClass
//    public void setupOnce() {
//        driver.get("https://play1.automationcamp.ir/index.html");
//        driver.findElement(By.cssSelector("[href='forms.html']")).click();
//    }
//
//    @Test
//    public void clickTheRadioButton() {
//        driver.findElement(By.cssSelector("[href='forms.html']")).click();
//        driver.findElement(By.cssSelector("[id='rad_protractor']")).click();
//        String validate = driver.findElement(By.cssSelector("#rad_validate")).getText();
//        Assert.assertEquals(validate, "PROTRACTOR");
//    }
//
//    @Test
//    public void enterTextInTheTextarea() {
//        driver.findElement(By.id("notes")).sendKeys("Notez");
//        String validate = driver.findElement(By.cssSelector("#area_notes_validate")).getText();
//        Assert.assertEquals(validate, "Notez");
//    }
//
//    @Test
//    public void theSecondSelectOption() {
//        Select select = new Select(driver.findElement(By.id("select_tool")));
//        select.selectByIndex(0);
//    }
//
//    @Test
//    public void Meter() {
//        WebElement slider = driver.findElement(By.id("fluency"));
//        slider.click();
//        slider.sendKeys(Keys.ARROW_LEFT);
//        slider.sendKeys(Keys.ARROW_LEFT);
//    }
//
//    @Test
//    public void theSecondSelectOption() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.get("https://play1.automationcamp.ir/index.html");
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='forms.html']")));
//        driver.findElement(By.cssSelector("[href='forms.html']")).click();
//
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("select_tool")));
//
//        Select select = new Select(driver.findElement(By.id("select_tool")));
//        List<WebElement> dropdowns = select.getOptions();
//        for (WebElement drop : dropdowns) {
//            System.out.println(drop.getText());
//        }
//    }
}