package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WDM_FirefoxHeadless {
    public static WebDriver firefoxHeadlessDriver;

    @Test
    public void test_Firefox() throws Exception {
        WebDriverManager.firefoxdriver().arch64().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        firefoxHeadlessDriver = new FirefoxDriver(firefoxOptions);
        firefoxHeadlessDriver.manage().window().maximize();
        firefoxHeadlessDriver.get("https://www.google.co.in");
        Assert.assertEquals(firefoxHeadlessDriver.getTitle(), "Google");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        firefoxHeadlessDriver.quit();
    }
}
