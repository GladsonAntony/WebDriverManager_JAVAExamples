package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WDM_ChromeHeadless {
    public static WebDriver chromeHeadlessDriver;


    @Test
    public void test_ChromeHeadless() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeHeadlessDriver = new ChromeDriver(chromeOptions);
        chromeHeadlessDriver.get("http://www.google.co.in");
        Assert.assertEquals(chromeHeadlessDriver.getTitle(), "Google");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        chromeHeadlessDriver.close();
        chromeHeadlessDriver.quit();
    }

}
