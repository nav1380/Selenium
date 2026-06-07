package tests;

import base.baseTestIsolation;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IframesPage;
import utils.ConfigReader;

public class IframesTests extends baseTestIsolation {

    @Test
    public void IFramesTest() {
        IframesPage iframes = new IframesPage(driver);
        System.out.println(ConfigReader.getBooleanProperty("headless"));
        System.out.println(ConfigReader.getBooleanProperty("headless").getClass());

        iframes.switchToIFrame("frame1");
        iframes.clickTheClickMeButton("click_me_1");
        Assert.assertEquals(iframes.getTheClickMeButtonText("click_me_1"), "Clicked", "The text is incorrect");

        iframes.switchToIFrame("frame2");
        iframes.clickTheClickMeButton("click_me_2");
        Assert.assertEquals(iframes.getTheClickMeButtonText("click_me_2"), "Clicked", "The text is incorrect");

        iframes.returnToParentFrame();
        iframes.switchToIFrame("frame3");

        iframes.switchToIFrame("frame4");
        iframes.clickTheClickMeButton("click_me_4");
        Assert.assertEquals(iframes.getTheClickMeButtonText("click_me_4"), "Clicked", "The text is incorrect");

        iframes.returnToWindow();
    }

}
