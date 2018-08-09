package examples;

import io.github.bonigarcia.wdm.OperaDriverManager;
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
        OperaDriverManager.getInstance().arch64().setup();
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.setBinary("C:\\Program Files\\Opera\\54.0.2952.64\\opera.exe");
        operaDriver = new OperaDriver(operaOptions);
        operaDriver.manage().window().maximize();
        operaDriver.get("https://www.google.co.in");
        Assert.assertEquals(operaDriver.getTitle(),"Google");
    }

    @AfterMethod
    public void tearDown() throws Exception
    {
        operaDriver.quit();
    }
}
