/**
 * @Author Gladson Antony
 * @Date Apr 18, 2017
 */
package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.automation.remarks.video.enums.RecorderType;
import com.automation.remarks.video.enums.RecordingMode;
import com.automation.remarks.video.enums.VideoSaveMode;
import com.automation.remarks.video.recorder.VideoRecorder;
import com.automation.remarks.video.recorder.monte.MonteRecorder;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;

@Listeners(VideoListener.class)
public class test1 
{
	public static WebDriver driver;

	@BeforeMethod
	public void beforeClass() throws Exception
	{
	
		VideoRecorder.conf()         // Default is ${user.dir}/video.
		.videoEnabled(true)                       	// Disabled video globally
		.withVideoSaveMode(VideoSaveMode.ALL)     	// Save videos for passed and failed tests
		.withRecorderType(RecorderType.FFMPEG)    // Monte is Default recorder
		.withRecordMode(RecordingMode.ALL)  ;		// Record video only for tests with @Video
		//.withScreenSize(1024,768);					// Set screen size
/*		
		MonteRecorder.conf()
		.withVideoFolder("C:\\Gladson\\EclipseWorkspace\\WebAutomation_AllureParallel\\video")
		.withRecordMode(RecordingMode.ALL)
        .withRecorderType(RecorderType.MONTE);*/
	}


	@Test @Video(name="ChromeTest")
	public void test_Chrome() throws Exception
	{
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		Assert.assertEquals(driver.getTitle(), "Boogle");
		//driver.close();
	}

	@Test @Video
	public void test_Firefox() throws Exception
	{
		FirefoxDriverManager.getInstance().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		Assert.assertEquals(driver.getTitle(), "Google");
		//driver.close();
	}

	@Test
	public void test_Phanthom() throws Exception
	{
		PhantomJsDriverManager.getInstance().setup();
		driver = new PhantomJSDriver();
		System.out.println("Phantom JS Driver Setup");		
		driver.get("https://www.google.co.in/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs("Google"));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Google");
		//driver.close();
	}

	@Test @Video()
	public void test_IE() throws Exception
	{
		InternetExplorerDriverManager.getInstance().setup();
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		driver = new InternetExplorerDriver(ieCapabilities);
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		Assert.assertEquals(driver.getTitle(), "Google");
		//driver.close();
	}
	
	
	@AfterMethod
	public void teardown() throws Exception
	{
		driver.close();
		driver.quit();
	}
}
