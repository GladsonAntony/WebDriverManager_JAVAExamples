package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WDM_InternetExplorer {
    public static WebDriver ieDriver;

    @Test(enabled = false)
    public void test_InternetExplorer() throws Exception {
        WebDriverManager.iedriver().setup();
//        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        ieDriver = new InternetExplorerDriver();
        ieDriver.manage().window().maximize();
        ieDriver.get("https://www.google.co.in/");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        ieDriver.quit();
    }
}
