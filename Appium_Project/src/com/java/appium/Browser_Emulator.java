package com.java.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Browser_Emulator {

	WebDriver driver = null;

	@BeforeMethod
	public void setup() throws Throwable {
		
		
			DesiredCapabilities capabilities = new DesiredCapabilities();
			/* capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			capabilities.setCapability(MobileCapabilityType.APP,"chrome");
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);*/
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
				"Android");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				"4.4.2");

//			try{
//			 webdriver = new RemoteWebDriver(new URL(appUrl),capabilities);
//			} catch (MalformedURLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			}

//		File appDir = new File("C://apps");
//		File app = new File(appDir, "Chrome.apk");
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("deviceName", "Moto G");
//		capabilities.setCapability("browserName", "Browser");
//		//capabilities.setCapability("app", "chrome");
//		capabilities.setCapability("platformVersion", "5.0.2");
//		capabilities.setCapability("platformName", "Android");
		// Here we mention the app's package name, to find the package name we
		// have to convert .apk file into java class files
		//capabilities.setCapability("app-package", "com.android.chrome");
		// Here we mention the activity name, which is invoked initially as
		// app's first page.
//		capabilities.setCapability("app-activity", "com.google.android.apps.chrome.Main");
//		// capabilities.setCapability("app-wait-activity","LoginActivity,NewAccountActivity");
//		 capabilities.setCapability("app", app.getAbsolutePath());

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		//http://10.103.20.61:4444/wd/hub,http://127.0.0.1:4723/wd/hub
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		//driver.get("http://www.seleniumhq.org/");

	}

	@Test
	public void menuTest() throws Exception {
		
//		Thread.sleep(5000);
//
//		driver.navigate().to("http://www.seleniumhq.org/");
//		
//		Thread.sleep(10000);
		String    baseUrl = "http://www.gmail.com";
		
		System.out.println("Starting browser");
	    // driver.get(mediaUrl);
		Thread.sleep(10000);
	    driver.get(baseUrl);
	 //   final String expectedPageTitle = "Disneyland Resort | Welcome to the Magic";
	    Thread.sleep(10000);
	    driver.findElement(By.id("Email")).sendKeys("kumarswamy830@gmail.com");
	    driver.findElement(By.id("Passwd")).sendKeys("Test@0060");
//	    driver.findElement(By.xpath(".//*[@id='Passwd']")).click();
//	    driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("Test@0060");
	    driver.findElement(By.id("signIn")).click();
//	    final String pageTitle = driver.getTitle();
//
//	    if (pageTitle.equals(expectedPageTitle)) {
//	      System.out.println("Verified page loaded");
//	    } else {
//	      System.out.println("FAIL verify page loaded, expecting: "
//	          + expectedPageTitle + " + got: " + pageTitle);
//	    }

	    

//	    try {
//	      System.out.println("Clicking on: Purchase tickets");
//	      driver.findElement(By.xpath("//*[@id=\"ticketsButton\"]")).click();
//	    } catch (final NoSuchElementException e) {
//	      e.printStackTrace();
//	    }

	    System.out.println("Quiting driver");
	    Thread.sleep(10000);
	    
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}