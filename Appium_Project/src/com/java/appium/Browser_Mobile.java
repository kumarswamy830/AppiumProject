package com.java.appium;

import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Browser_Mobile {
	
	WebDriver driver = null;
	
	
	@BeforeMethod
	
	public void openBrowser() throws MalformedURLException{
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		/* capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.APP,"chrome");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);*/
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Browser"); 
		    //capabilities.setCapability(MobileCapabilityType.APP,"Chrome");
		    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
		    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"4.4.2");

		 
		driver = new RemoteWebDriver(new URL(
				"http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
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
	    Thread.sleep(5000);
	    driver.findElement(By.id("Email")).click();
	    driver.findElement(By.id("Email")).sendKeys("kumarswamy830@gmail.com");
	    driver.findElement(By.id("Passwd")).click();
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
