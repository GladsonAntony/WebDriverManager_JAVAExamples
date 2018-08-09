package examples;

import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WDM_Phantom
{
    public static WebDriver phantomDriver;

    @Test
    public void test_Phantom() throws Exception
    {
        PhantomJsDriverManager.getInstance().setup();
        phantomDriver = new PhantomJSDriver();
        System.out.println("Phantom JS Driver Setup");
        phantomDriver.get("https://www.google.co.in/");
        Assert.assertEquals(phantomDriver.getTitle(), "Google");
    }

    @AfterMethod
    public void tearDown() throws Exception
    {
        phantomDriver.quit();
    }
}
