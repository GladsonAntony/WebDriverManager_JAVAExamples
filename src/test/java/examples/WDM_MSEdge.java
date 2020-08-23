package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WDM_MSEdge {
    public static WebDriver edgeDriver;

    @Test
    public void test_MSEdge() throws Exception {
        WebDriverManager.edgedriver().setup();
        edgeDriver = new EdgeDriver();
        edgeDriver.manage().window().maximize();
        edgeDriver.get("https://www.google.co.in");
        Assert.assertEquals(edgeDriver.getTitle(), "Google");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        edgeDriver.quit();
    }
}
