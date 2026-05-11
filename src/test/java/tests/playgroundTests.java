package tests;

import base.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class playgroundTests extends baseTest {

    @Test(priority = 1)
    public void inputInTextbox() {
        driver.findElement(By.cssSelector("a[href='forms.html']")).click();

        String expected = "16";
        driver.findElement(By.cssSelector("[placeholder='years of automation experience']")).sendKeys(expected);
        WebElement outputText = driver.findElement(By.id("exp_help"));

        wait.until(ExpectedConditions.textToBePresentInElement(outputText, "16"));
    }

    @Test(priority = 2)
    public void clickCheckbox() {
        Assert.assertFalse(driver.findElement(By.id("check_java")).isEnabled());

        driver.findElement(By.id("check_python")).click();
        driver.findElement(By.cssSelector("[name='javascript']")).click();
        WebElement outputText = driver.findElement(By.cssSelector("[id='check_validate']"));
        wait.until(ExpectedConditions.textToBePresentInElement(outputText, "PYTHON JAVASCRIPT"));
    }

    @Test(priority = 3)
    public void clickRadioButtons() {
        Assert.assertFalse(driver.findElement(By.id("rad_selenium")).isSelected());

        driver.findElement(By.id("rad_selenium")).click();

        Assert.assertTrue(driver.findElement(By.id("rad_selenium")).isSelected());

    }

    @Test (priority = 4)
    public void selectFromDropdown() {
        WebElement dropdown = driver.findElement(By.id("select_tool"));
        Select select = new Select(dropdown);
        List<WebElement> dropdownValues = select.getOptions();

//        for (WebElement s : dropdownValues) {
//            System.out.println(s.getText());
//        }

        Assert.assertTrue(dropdownValues.getFirst().isSelected());

        select.selectByIndex(1);
        Assert.assertFalse(dropdownValues.get(0).isSelected());
        Assert.assertTrue(dropdownValues.get(1).isSelected());

        select.selectByValue("cyp");
        Assert.assertFalse(dropdownValues.get(0).isSelected());
        Assert.assertFalse(dropdownValues.get(1).isSelected());
        Assert.assertTrue(dropdownValues.get(2).isSelected());

    }

    @Test (priority = 4)
    public void selectFromListbox() {
        WebElement listbox = driver.findElement(By.id("select_lang"));
        Select select = new Select(listbox);
        List<WebElement> listboxValues = select.getOptions();

        select.selectByIndex(0);
        Assert.assertTrue(listboxValues.getFirst().isSelected());
    }

    @Test (priority = 5)
    public void typeInTextarea() {
        WebElement textarea = driver.findElement(By.id("notes"));
        String expected = "this is the text";

        textarea.sendKeys(expected);
        Assert.assertEquals(driver.findElement(By.id("area_notes_validate")).getText(), expected);
    }


}
