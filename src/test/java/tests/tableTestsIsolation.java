package tests;

import base.baseTestIsolation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class tableTestsIsolation extends baseTestIsolation {

    @Test
    public void checkingTableHeaders() {
        List<WebElement> headers = driver.findElements(By.cssSelector("table thead tr"));
        List<WebElement> value = headers.getFirst().findElements(By.className("dt-column-title"));
        for (WebElement v : value) {
            System.out.println(v.getAttribute("innerText"));
        }
    }

    @Test
    public void checkingTableFirstRow() {
        List<WebElement> tBody = driver.findElements(By.cssSelector("table tbody"));
        List<WebElement> tBodyRow = tBody.get(3).findElements(By.cssSelector("tr"));
        List<WebElement> tBodyData = tBodyRow.get(1).findElements(By.cssSelector("td"));
        for (WebElement t : tBodyData) {
            System.out.println(t.getAttribute("innerText"));
        }

    }

}
