package tests;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;;

public class selenium extends baseTest {

    @Test
    public void Eureeka() {


        Assert.assertTrue(driver.getCurrentUrl().equals("https://datatables.net/examples/basic_init/multiple_tables.html"));
    }

}