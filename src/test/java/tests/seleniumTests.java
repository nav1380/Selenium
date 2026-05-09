package tests;

import base.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class seleniumTests extends baseTest {

    @Test
    public void Eureeka2() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://datatables.net/examples/basic_init/multiple_tables.html"));

        List<WebElement> tBody = driver.findElements(By.cssSelector("thead"));
        List<WebElement> tBodyTD = tBody.get(0).findElements(By.cssSelector("tr"));
        List<WebElement> tBodyValue = tBodyTD.getFirst().findElements(By.cssSelector("th"));

        for (WebElement h : tBodyValue) {
            System.out.println(h.getText());
        }
    }

}