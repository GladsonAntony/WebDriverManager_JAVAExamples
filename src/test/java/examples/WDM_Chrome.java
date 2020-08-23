package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WDM_Chrome {
    public static WebDriver chromeDriver;


    @Test
    public void test_Chrome() throws Exception {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.get("http://www.google.co.in");
        chromeDriver.manage().window().maximize();
        Assert.assertEquals(chromeDriver.getTitle(), "Google");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        chromeDriver.close();
        chromeDriver.quit();
    }

}
