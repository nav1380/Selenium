package tests;

import base.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class tableTests extends baseTest {

    @Test(priority = 1)
    public void headerTest() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://datatables.net/examples/basic_init/multiple_tables.html"));

        List<WebElement> tHead = driver.findElements(By.cssSelector("thead"));
        List<WebElement> tHeadRow = tHead.getFirst().findElements(By.cssSelector("tr"));
        List<WebElement> tHeadValue = tHead.getFirst().findElements(By.cssSelector("th"));

        for (WebElement headers : tHeadValue) {
            System.out.println(headers.getText());
        }
    }

    @Test(priority = 2)
    public void bodyTest() {
        List<WebElement> tBody = driver.findElements(By.cssSelector("tbody"));
        List<WebElement> tBodyRow = tBody.getFirst().findElements(By.cssSelector("tr"));
        List<WebElement> tBodyValue = tBodyRow.getFirst().findElements(By.cssSelector("td"));

        for (WebElement Body : tBodyValue) {
            System.out.println(Body.getText());
        }

    }

}