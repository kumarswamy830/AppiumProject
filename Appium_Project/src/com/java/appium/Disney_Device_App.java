package com.java.appium;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Disney_Device_App {

	AppiumDriver driver = null;

	@BeforeMethod
	public void setup() throws Throwable {
		
		File appDir = new File("C://apps");
		File app = new File(appDir, "Android-MDX-release-26.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Vitor Campos Instituto Lope (SGH");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("platformName", "Android");
		// Here we mention the app's package name, to find the package name we
		// have to convert .apk file into java class files
		capabilities.setCapability("app-package", "com.disney.mdx.wdw.google");
		// Here we mention the activity name, which is invoked initially as
		// app's first page.
		capabilities.setCapability("app-activity", "com.disney.wdpro.android.mdx.activities.SplashActivity");
		// capabilities.setCapability("app-wait-activity","LoginActivity,NewAccountActivity");
		capabilities.setCapability("app", app.getAbsolutePath());

		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}

	@Test
	public void menuTest() throws Exception {

		//Click on Menu icon
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.id("com.cricbuzz.android:id/menubtn")));
		driver.findElement(By.id("com.cricbuzz.android:id/menubtn")).click();
		System.out.println("Clicked on Menu icon");
		
		//Verify menu items
		driver.findElement(By.xpath("//android.widget.TextView[@text='News']"));
		//Verified News menu item
		System.out.println("Verified News menu item");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Matches']"));
		//Verified Matches menu item
		System.out.println("Verified Matches menu item");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Schedule']"));
		//Verified Schedule menu item
		System.out.println("Verified Schedule menu item");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Gallery']"));
		//Verified Gallery menu item
		System.out.println("Verified Gallery menu item");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Search player']"));
		//Verified Search player menu item
		System.out.println("Verified Search player menu item");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Rankings']"));
		//Verified Rankings menu item
		System.out.println("Verified Rankings menu item");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Share the App']"));
		//Verified Share the App menu item
		System.out.println("Verified Share the App menu item");
		driver.findElement(By.xpath("//android.widget.TextView[@text='More']"));
		//Verified More menu item
		System.out.println("Verified More menu item");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}