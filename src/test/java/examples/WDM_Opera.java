package examples;

import io.github.bonigarcia.wdm.OperaDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WDM_Opera
{
    public static WebDriver operaDriver;

    @Test
    public void test_Opera() throws Exception
    {
        WebDriverManager.operadriver().arch64().setup();
        System.out.println(WebDriverManager.operadriver().getBinaryPath());
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.setBinary("C:\\Program Files\\Opera\\57.0.3098.106\\opera.exe");
        operaDriver = new OperaDriver(operaOptions);
        operaDriver.manage().window().maximize();
        operaDriver.get("https://www.google.co.in");
        Assert.assertEquals(operaDriver.getTitle(),"Google");
        System.out.println(WebDriverManager.operadriver().getBinaryPath());
    }

    @AfterMethod
    public void tearDown() throws Exception
    {
        operaDriver.quit();
    }
}
