package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IframesPage extends BasePage {

    public IframesPage(WebDriver driver) {
        super(driver);
    }

//    public void switchToIFrameInList(int frame) {
//        List<WebElement> IFrames = driver.findElements(By.tagName("iframe"));
//        driver.switchTo().frame(IFrames.get(0));
//    }
//
//    public String getIFrame1Text() {
//        return driver.findElement(By.cssSelector("[title='back to Selenium Tutorial']")).getText();
//    }
//
//    public String getIFrame2Text() {
//        return driver.findElement(By.xpath("//h1[contains(text(), 'New Tab')]")).getText();
//    }

    public void switchToIFrame(String id) {
        driver.switchTo().frame(id);
    }

    public void returnToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void returnToWindow() {
        driver.switchTo().defaultContent();
    }

    public void clickTheClickMeButton(String id) {
        driver.findElement(By.id(id)).click();
    }

    public WebElement getTheClickMeButton(String id) {
        return driver.findElement(By.id(id));
    }

    public String getTheClickMeButtonText(String id) {
        return driver.findElement(By.id(id)).getText();
    }

}
