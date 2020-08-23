package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WDM_Firefox {
    public static WebDriver firefoxDriver;

    @Test
    public void test_Firefox() throws Exception {
        WebDriverManager.firefoxdriver().arch64().setup();
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().window().maximize();
        firefoxDriver.get("https://www.google.co.in");
        Assert.assertEquals(firefoxDriver.getTitle(), "Google");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        firefoxDriver.quit();
    }
}
